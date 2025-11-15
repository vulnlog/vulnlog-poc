package dev.vulnlog.yaml

import dev.vulnlog.yaml.dto.ReportersVulnlogSchema.Vendor
import dev.vulnlog.yaml.dto.ReportersVulnlogSchema.Vendor.*
import dev.vulnlog.yaml.dto.VulnlogSchema
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.add
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject
import java.nio.file.Path
import kotlin.collections.flatMap
import kotlin.io.path.extension
import kotlin.io.path.isDirectory
import kotlin.io.path.writeText

class GenerateCustomJsonSchema(
    private val result: VulnlogSchema,
    outputFilename: Path
) {
    @OptIn(ExperimentalSerializationApi::class)
    val json = Json {
        prettyPrint = true
        prettyPrintIndent = "  "
    }

    private val outputFile: Path = if (outputFilename.extension == "json") {
        outputFilename
    } else if (outputFilename.isDirectory()) {
        outputFilename.resolve("vulnlog-schema.json")
    } else {
        error("Invalid output file path: $outputFilename")
    }

    /**
     * Reset the JSON schema to its original state.
     */
    fun reset() {
        val releaseSchema = loadAndParseReleaseSchema()
        val formattedJson = json.encodeToString(JsonElement.serializer(), releaseSchema)
        writeSchemaToFile(formattedJson)
    }

    /**
     * Generate and update JSON schema with enriched data from releases and reporters.
     */
    fun generate() {
        var releaseSchema = loadAndParseReleaseSchema()
        if (!result.releases.isNullOrEmpty()) {
            val releaseIds: Set<String> =
                result.releases.filterNotNull().mapNotNull { it.id }.toSet()
            releaseSchema = replaceGenericReleaseDefinitionWithSpecific(releaseIds, releaseSchema)
        }

        if (!result.reporters.isNullOrEmpty()) {
            val reporters: Map<Vendor, Set<String>> =
                result.reporters.groupBy { it.vendor }
                    .mapValues { it -> it.value.mapNotNull { it.id }.toSet() }

            var updated: JsonElement = replaceGenericReporterDefinitionWithSpecific(reporters, releaseSchema)
            updated = setReporterSpecificConstraints(reporters, updated)
            updated = removeEmptySuppressionElement(updated)
            releaseSchema = updated
        }

        val newResult = json.encodeToString(JsonElement.serializer(), releaseSchema)
        writeSchemaToFile(newResult)
    }

    private fun loadAndParseReleaseSchema(): JsonElement {
        val jsonSchemaTemplate =
            javaClass.getResource("/jsonschema/vulnlog-schema.json")?.readText()
                ?: throw IllegalStateException("Could not load JSON schema template")
        return json.parseToJsonElement(jsonSchemaTemplate)

    }

    private fun replaceGenericReleaseDefinitionWithSpecific(
        releases: Set<String>,
        root: JsonElement
    ): JsonElement {
        val path = listOf(
            $$"$defs",
            "https://vulnlog.dev/on.vulnlog.schema.json",
        )
        val releaseArray: JsonArray = buildJsonArray {
            for (release: String in releases) {
                add(release)
            }
        }
        val oneOf: JsonObject = generateOneOfElementWithData(releaseArray)
        return insertNewObjectAtLocationPath(root, path, oneOf)
    }

    private fun replaceGenericReporterDefinitionWithSpecific(
        reporters: Map<Vendor, Set<String>>,
        root: JsonElement
    ): JsonElement {
        val path = listOf(
            $$"$defs",
            "https://vulnlog.dev/vulnerabilities.reports.vulnlog.schema.json",
            "items",
            "properties",
            "reporters",
            "items",
            "properties",
            "reporter",
        )
        val reporterNames: List<String> = reporters.values.flatten().toSet().map { it }
        val reporterArray: JsonArray = buildJsonArray {
            for (reporter: String in reporterNames) {
                add(reporter)
            }
        }
        val oneOf: JsonObject = generateOneOfElementWithData(reporterArray)
        return insertNewObjectAtLocationPath(root, path, oneOf)
    }

    private fun generateOneOfElementWithData(dataArray: JsonArray): JsonObject {
        val singleEnum = buildJsonObject {
            put("enum", dataArray)
        }
        val multiEnum = buildJsonObject {
            put("type", "array")
            put("items", singleEnum)
        }
        val oneOfValues: JsonArray = buildJsonArray {
            add(singleEnum)
            add(multiEnum)
        }
        return buildJsonObject {
            put("oneOf", oneOfValues)
        }
    }

    private fun setReporterSpecificConstraints(
        reporters: Map<Vendor, Set<String>>,
        root: JsonElement
    ): JsonElement {
        val path = listOf(
            $$"$defs",
            "https://vulnlog.dev/vulnerabilities.reports.vulnlog.schema.json",
            "items",
            "properties",
            "reporters",
            "items",
        )
        val vendorSpecificConstraints: List<JsonObject> =
            reporters.flatMap { (vendor, reporterId) ->
                when (vendor) {
                    AQUA_SECURITY_TRIVY -> reporterId.map(::generateTrivyBased)
                    OWASP_DEPENDENCY_CHECK -> reporterId.map(::generateOwaspBased)
                    SNYK_OPEN_SOURCE -> reporterId.map(::generateSnykBased)
                }
            }
        val allOfValues: JsonArray = buildJsonArray { for (v in vendorSpecificConstraints) add(v) }
        val allOf: JsonObject = buildJsonObject {
            put("allOf", allOfValues)
        }
        return insertNewObjectAtLocationPath(root, path, allOf)
    }

    private fun generateOwaspBased(name: String): JsonObject {
        return buildJsonObject {
            putJsonObject("if") {
                putJsonObject("properties") {
                    putJsonObject("reporter") {
                        put("const", name)
                    }
                }
            }
            putJsonObject("then") {
                putJsonObject("properties") {
                    putJsonObject("reporter") {}
                    putJsonObject("suppression") {
                        put("title", "OWASP Suppression")
                        put("description", "OWASP Lorem ipsum")
                        put(
                            $$"$ref",
                            $$"#/$defs/https:~1~1vulnlog.dev~1vulnerabilities.reports.vulnlog.schema.json/$defs/owasp"
                        )
                        put("additionalProperties", false)
                    }
                }
            }
        }
    }

    private fun generateSnykBased(name: String): JsonObject {
        return buildJsonObject {
            putJsonObject("if") {
                putJsonObject("properties") {
                    putJsonObject("reporter") {
                        put("const", name)
                    }
                }
            }
            putJsonObject("then") {
                putJsonObject("properties") {
                    putJsonObject("reporter") {}
                    putJsonObject("suppression") {
                        put("title", "Snyk Suppression")
                        put("description", "Snyk Lorem ipsum")
                        put(
                            $$"$ref",
                            $$"#/$defs/https:~1~1vulnlog.dev~1vulnerabilities.reports.vulnlog.schema.json/$defs/snyk"
                        )
                        put("additionalProperties", false)
                    }
                }
            }
        }
    }

    private fun generateTrivyBased(name: String): JsonObject {
        return buildJsonObject {
            putJsonObject("if") {
                putJsonObject("properties") {
                    putJsonObject("reporter") {
                        put("const", name)
                    }
                }
            }
            putJsonObject("then") {
                putJsonObject("properties") {
                    putJsonObject("reporter") {}
                    putJsonObject("suppression") {
                        put("title", "Trivy Suppression")
                        put("description", "Trivy Lorem ipsum")
                        put(
                            $$"$ref",
                            $$"#/$defs/https:~1~1vulnlog.dev~1vulnerabilities.reports.vulnlog.schema.json/$defs/trivy"
                        )
                        put("additionalProperties", false)
                    }
                }
            }
        }
    }

    private fun removeEmptySuppressionElement(
        rootTree: JsonElement,
    ): JsonElement {
        val path = listOf(
            $$"$defs",
            "https://vulnlog.dev/vulnerabilities.reports.vulnlog.schema.json",
            "items",
            "properties",
            "reporters",
            "items",
            "properties",
            "suppression"
        )
        return removeAtPath(rootTree, path)
    }

    private fun removeAtPath(current: JsonElement, remainingPath: List<String>): JsonElement {
        if (remainingPath.isEmpty()) return current

        val key = remainingPath.first()
        val rest = remainingPath.drop(1)

        val obj = current.jsonObject
        if (rest.isEmpty()) {
            return JsonObject(obj.filterKeys { it != key })
        }

        val updatedChild = removeAtPath(obj.getValue(key), rest)
        return JsonObject(buildMap {
            putAll(obj)
            put(key, updatedChild)
        })
    }

    private fun insertNewObjectAtLocationPath(
        rootTree: JsonElement,
        path: List<String>,
        newObject: JsonObject
    ): JsonElement {
        if (path.isEmpty()) {
            val obj = rootTree.jsonObject
            val newContent = buildMap {
                putAll(obj)
                putAll(newObject)
            }
            return JsonObject(newContent)
        }

        val key = path.first()
        val rest = path.drop(1)

        val obj = rootTree.jsonObject
        val updatedChild = insertNewObjectAtLocationPath(obj.getValue(key), rest, newObject)

        val newContent = buildMap {
            putAll(obj)
            put(key, updatedChild)
        }
        return JsonObject(newContent)
    }

    private fun writeSchemaToFile(replacedReleases: String) {
        println("Writing JSON schema to file: $outputFile")
        outputFile.writeText(replacedReleases)
    }
}
