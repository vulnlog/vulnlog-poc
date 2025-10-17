plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
    id("org.jsonschema2pojo") version "1.2.2"
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
    includeConstructors = false
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
