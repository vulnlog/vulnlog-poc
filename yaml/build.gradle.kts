import java.text.SimpleDateFormat
import java.util.*

plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
    id("org.jsonschema2pojo") version "1.2.2"
    id("org.graalvm.buildtools.native") version "0.11.1"
    kotlin("plugin.serialization") version "2.2.0"
}

val gitHash: String by lazy {
    try {
        "git rev-parse --short HEAD".runCommand(project.rootDir).trim()
    } catch (_: Exception) {
        "unknown"
    }
}

val snapshotVersion = "SNAPSHOT-${SimpleDateFormat("yyyyMMdd-HHmmss").format(Date())}+$gitHash"
val appVersion: String = project.findProperty("appVersion")?.toString() ?: snapshotVersion

version = appVersion

val jacksonVersion = "2.20.0"
val jsonSchemaCliVersion = "12.10.1"

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
}

application {
    mainClass = "dev.vulnlog.yaml.YamlAppKt"
}

tasks.withType<Jar> {
    manifest {
        attributes["Implementation-Version"] = version
    }
    dependsOn("bundleJsonSchema")
    from(project.layout.buildDirectory.dir("jsonschema/vulnlog-schema.json")) {
        into("jsonschema")
    }
}

jsonSchema2Pojo {
    sourceFiles = files("src/main/json-schema")
    targetDirectory = file("src/main/java")
    targetPackage = "dev.vulnlog.yaml.dto"
    setAnnotationStyle("jackson")
    includeConstructors = true
    constructorsRequiredPropertiesOnly = false
    includeHashcodeAndEquals = false
    includeToString = false
    usePrimitives = true
    isIncludeGeneratedAnnotation = false
    useOptionalForGetters = false
    serializable = false
    includeJsr303Annotations = false
    includeJsr305Annotations = false
    useJodaDates = false
    useJodaLocalDates = false

    dateType = "java.time.LocalDate"
}

tasks.compileKotlin {
    dependsOn(tasks.generateJsonSchema2Pojo)
}

tasks.nativeCompile {
    dependsOn(tasks.generateJsonSchema2Pojo)
}

graalvmNative {
    binaries {
        named("main") {
            imageName.set("vl-yaml")
            buildArgs.addAll(
                listOf(
                    "-O2", // good performance at a reasonable file size
                    "--emit build-report"
                )
            )
        }
    }

    metadataRepository {
        enabled.set(true)
    }
}

val downloadJsonSchemaCli = tasks.register<Task>("downloadJsonSchemaCli") {
    val os = org.gradle.internal.os.OperatingSystem.current()
    val arch = System.getProperty("os.arch")

    val platform = when {
        os.isLinux && arch.contains("aarch64") -> "linux-aarch64"
        os.isLinux -> "linux-x86_64"
        os.isMacOsX && arch.contains("aarch64") -> "macos-arm64"
        os.isMacOsX -> "macos-x86_64"
        os.isWindows -> "windows-x86_64"
        else -> throw GradleException("Unsupported platform: ${os.name} ${arch}")
    }

    val binaryName = if (os.isWindows) "jsonschema.exe" else "jsonschema"
    val downloadUrl =
        "https://github.com/sourcemeta/jsonschema/releases/download/v${jsonSchemaCliVersion}/jsonschema-${jsonSchemaCliVersion}-${platform}.zip"
    val downloadFile = project.layout.buildDirectory.file("tools/jsonschema-cli.zip").get().asFile
    val extractDir = project.layout.buildDirectory.dir("tools/extracted").get().asFile
    val finalBinaryDir = project.layout.buildDirectory.dir("tools").get().asFile
    val binaryFile = File(finalBinaryDir, binaryName)

    outputs.file(binaryFile)

    doLast {
        if (!binaryFile.exists()) {
            extractDir.mkdirs()
            finalBinaryDir.mkdirs()

            // Download the ZIP file
            ant.invokeMethod(
                "get", mapOf(
                    "src" to downloadUrl,
                    "dest" to downloadFile
                )
            )

            // Extract the ZIP file
            copy {
                from(zipTree(downloadFile))
                into(extractDir)
            }

            // Find the binary in the bin subdirectory
            val extractedBinaries = fileTree(extractDir) {
                include("**/bin/$binaryName")
            }.files

            if (extractedBinaries.isEmpty()) {
                throw GradleException("Could not find $binaryName in extracted files")
            }

            val extractedBinary = extractedBinaries.first()

            // Copy to the final location
            extractedBinary.copyTo(binaryFile, overwrite = true)

            // Make binary executable (Unix-like systems)
            binaryFile.setExecutable(true)

            // Clean up
            downloadFile.delete()
            extractDir.deleteRecursively()
        }
    }
}

val bundleJsonSchema = tasks.register<Exec>("bundleJsonSchema") {
    dependsOn(downloadJsonSchemaCli)

    val inputFile = project.projectDir.resolve("src/main/json-schema/vulnlog.schema.json")
    val schemaDir = project.projectDir.resolve("src/main/json-schema")
    val outputFile = project.layout.buildDirectory.file("jsonschema/vulnlog-schema.json")
    val os = org.gradle.internal.os.OperatingSystem.current()
    val binaryName = if (os.isWindows) "jsonschema.exe" else "jsonschema"
    val jsonSchemaBinary = project.layout.buildDirectory.file("tools/$binaryName").get().asFile

    inputs.file(inputFile)
    inputs.dir(schemaDir)
    outputs.file(outputFile)

    workingDir(project.rootDir)

    commandLine(
        jsonSchemaBinary.absolutePath,
        "bundle",
        inputFile.toString(),
        "--resolve",
        schemaDir.toString(),
        "--extension",
        "schema.json",
        "-w"
    )

    doFirst {
        standardOutput = outputFile.get().asFile.outputStream()
    }
}

tasks.build {
    dependsOn(bundleJsonSchema)
}

val validateVulnlogYaml = tasks.register<Exec>("validateVulnlogYaml") {
    dependsOn(downloadJsonSchemaCli)

    val yamlFileToValidate = project.rootDir.resolve("yaml-data/product.vl.yml")
    val schemaFile = project.projectDir.resolve("src/main/json-schema/vulnlog.schema.json")
    val schemaDir = project.projectDir.resolve("src/main/json-schema")
    val os = org.gradle.internal.os.OperatingSystem.current()
    val binaryName = if (os.isWindows) "jsonschema.exe" else "jsonschema"
    val jsonSchemaBinary = project.layout.buildDirectory.file("tools/$binaryName").get().asFile

    inputs.file(schemaFile)
    inputs.dir(schemaDir)

    workingDir(project.rootDir)

    commandLine(
        jsonSchemaBinary.absolutePath,
        "validate",
        schemaFile.toString(),
        yamlFileToValidate.toString(),
        "--resolve",
        schemaDir.toString(),
    )
}

val validateJsonSchema = tasks.register<Exec>("validateJsonSchema") {
    dependsOn(downloadJsonSchemaCli)

    val schemaFile = project.projectDir.resolve("src/main/json-schema/vulnlog.schema.json")
    val schemaDir = project.projectDir.resolve("src/main/json-schema")
    val os = org.gradle.internal.os.OperatingSystem.current()
    val binaryName = if (os.isWindows) "jsonschema.exe" else "jsonschema"
    val jsonSchemaBinary = project.layout.buildDirectory.file("tools/$binaryName").get().asFile

    inputs.file(schemaFile)
    inputs.dir(schemaDir)

    workingDir(project.rootDir)

    commandLine(
        jsonSchemaBinary.absolutePath,
        "metaschema",
        schemaFile.toString(),
        "--resolve",
        schemaDir.toString(),
    )
}

val lintJsonSchema = tasks.register<Exec>("lintJsonSchema") {
    dependsOn(downloadJsonSchemaCli)

    val schemaDir = project.projectDir.resolve("src/main/json-schema")
    val os = org.gradle.internal.os.OperatingSystem.current()
    val binaryName = if (os.isWindows) "jsonschema.exe" else "jsonschema"
    val jsonSchemaBinary = project.layout.buildDirectory.file("tools/$binaryName").get().asFile

    inputs.dir(schemaDir)

    workingDir(project.rootDir)

    commandLine(
        jsonSchemaBinary.absolutePath,
        "lint",
        schemaDir.toString(),
        "--resolve",
        schemaDir.toString(),
    )
}

val formatJsonSchema = tasks.register<Exec>("formatJsonSchema") {
    dependsOn(downloadJsonSchemaCli)

    val schemaDir = project.projectDir.resolve("src/main/json-schema")
    val os = org.gradle.internal.os.OperatingSystem.current()
    val binaryName = if (os.isWindows) "jsonschema.exe" else "jsonschema"
    val jsonSchemaBinary = project.layout.buildDirectory.file("tools/$binaryName").get().asFile

    inputs.dir(schemaDir)

    workingDir(project.rootDir)

    commandLine(
        jsonSchemaBinary.absolutePath,
        "fmt",
        schemaDir.toString(),
    )
}

tasks.check {
    dependsOn(lintJsonSchema)
    dependsOn(formatJsonSchema)
    dependsOn(validateJsonSchema)
}

private fun String.runCommand(workingDir: File): String {
    return ProcessBuilder(*split(" ").toTypedArray())
        .directory(workingDir)
        .redirectErrorStream(true)
        .start()
        .inputStream.bufferedReader().readText()
}
