plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
    id("org.jsonschema2pojo") version "1.2.2"
    id("org.graalvm.buildtools.native") version "0.11.0"
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.19.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.19.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.19.2")
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
