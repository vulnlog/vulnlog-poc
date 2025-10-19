plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
    id("org.jsonschema2pojo") version "1.2.2"
    id("org.graalvm.buildtools.native") version "0.11.1"
}

val jacksonVersion = "2.20.0"

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
}

application {
    mainClass = "dev.vulnlog.yaml.YamlAppKt"
}

jsonSchema2Pojo {
    sourceFiles = files("src/main/resources/json-schema")
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
                    "-Os",
                    "--emit build-report"
                )
            )
        }
    }

    metadataRepository {
        enabled.set(true)
    }
}

val bundleJsonSchema = tasks.register<Exec>("bundleJsonSchema") {
    val inputFile = project.projectDir.resolve("src/main/resources/json-schema/vulnlog.schema.json")
    val schemaDir = project.projectDir.resolve("src/main/resources/json-schema")
    val outputFile = project.projectDir.resolve("vulnlog.json")

    inputs.file(inputFile)
    inputs.dir(schemaDir)
    outputs.file(outputFile)

    workingDir(project.rootDir)
    standardOutput = outputFile.outputStream()

    commandLine(
        "jsonschema",
        "bundle",
        inputFile.toString(),
        "--resolve",
        schemaDir.toString(),
        "--extension",
        "schema.json",
        "-w"
    )

    // Ensure the output directory exists
    doFirst {
        outputFile.parentFile.mkdirs()
    }
}

tasks.build {
    dependsOn(bundleJsonSchema)
}

val validateVulnlogYaml = tasks.register<Exec>("validateVulnlogYaml") {
    val yamlFileToValidate = project.rootDir.resolve("yaml-data/product.vl.yml")
    val schemaFile = project.projectDir.resolve("src/main/resources/json-schema/vulnlog.schema.json")
    val schemaDir = project.projectDir.resolve("src/main/resources/json-schema")

    inputs.file(schemaFile)
    inputs.dir(schemaDir)

    workingDir(project.rootDir)

    commandLine(
        "jsonschema",
        "validate",
        schemaFile.toString(),
        yamlFileToValidate.toString(),
        "--resolve",
        schemaDir.toString(),
    )
}

val validateJsonSchema = tasks.register<Exec>("validateJsonSchema") {
    val schemaFile = project.projectDir.resolve("src/main/resources/json-schema/vulnlog.schema.json")
    val schemaDir = project.projectDir.resolve("src/main/resources/json-schema")

    inputs.file(schemaFile)
    inputs.dir(schemaDir)

    workingDir(project.rootDir)

    commandLine(
        "jsonschema",
        "metaschema",
        schemaFile.toString(),
        "--resolve",
        schemaDir.toString(),
    )
}

val lintJsonSchema = tasks.register<Exec>("lintJsonSchema") {
    val schemaFile = project.projectDir.resolve("src/main/resources/json-schema/vulnlog.schema.json")
    val schemaDir = project.projectDir.resolve("src/main/resources/json-schema")

    inputs.file(schemaFile)
    inputs.dir(schemaDir)

    workingDir(project.rootDir)

    commandLine(
        "jsonschema",
        "lint",
        schemaFile.toString(),
        "--resolve",
        schemaDir.toString(),
    )
}

val formatJsonSchema = tasks.register<Exec>("formatJsonSchema") {
    val schemaDir = project.projectDir.resolve("src/main/resources/json-schema")

    inputs.dir(schemaDir)

    workingDir(project.rootDir)

    commandLine(
        "jsonschema",
        "fmt",
        schemaDir.toString(),
    )
}

tasks.check {
    dependsOn(lintJsonSchema)
    dependsOn(formatJsonSchema)
    dependsOn(validateJsonSchema)
}
