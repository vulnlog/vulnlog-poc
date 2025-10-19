# YAML and JSON Schema PoC

This PoC requires [jsonschema](https://github.com/sourcemeta/jsonschema) installed on the system to
run all the Gradle tasks.

- [vulnlog.json](vulnlog.json) contains the whole Vulnlog schema bundled. It can be used by the IDE
  to get typesafe, autocompletion and documentation. It is generated from the files
  in [json-schema](src/main/resources/json-schema) by the Gradle task `./gradlew bundleJsonSchema`.
  This file can be published on [schemastore.org](https://www.schemastore.org/) to make it available
  in common IDEs like IntelliJ or VSCode.
- When adding new JSON schema files to [json-schema](src/main/resources/json-schema), make sure to
  add the according definitions
  to [reflect-config.json](src/main/resources/META-INF/native-image/reflect-config.json). Otherwise,
  the native image will fail to parse the Vulnlog file.

## Build

```console
./gradlew build
```

### Build native binaries:

Requires GraalVM version 24.0.1 or later. Use SDKMAN `sdk use java 24.0.1-graal` to switch JVM.

```console
./gradlew nativeCompile
```

Test:

```console
./yaml/build/native/nativeCompile/vl-yaml yaml-data/product.vl.yml
```

## Learnings

- GraalVM native image compiled with JSON schema enums does not work out of the box. It works fine
  when using the enum keys e.g. `COMPONENT_NOT_PRESENT`, but not with its value
  `Component not present`. The latter ist way more convenient to use.
    - The Problem: GraalVM native images don't properly handle the static initialization of the
      CONSTANTS HashMap in the generated enum class, which Jackson's @JsonCreator method relies on
      for deserializing enum values by their @JsonValue strings.
    - The Solution: Bypass the problematic static initialization by creating a custom
      JsonDeserializer that directly maps the string values to enum constants, and registered it
      with Jackson's ObjectMapper.
