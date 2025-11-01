package dev.vulnlog.yaml

import dev.vulnlog.yaml.dto.VulnlogSchema
import java.io.File

class GenerateCustomJsonSchema(
    private val result: VulnlogSchema,
    private val outputFilename: String
) {

    fun generate() {
        val jsonSchemaTemplate = javaClass.getResource("/jsonschema/vulnlog.json")?.readText()
            ?: throw IllegalStateException("Could not load JSON schema template")

        if (!result.releases.isNullOrEmpty()) {
            val releaseIds: Set<String> =
                result.releases.filterNotNull().mapNotNull { it.id }.toSet()
            val replacedReleases = replaceReleases(jsonSchemaTemplate, releaseIds)
            writeSchemaToFile(replacedReleases)
        }
    }

    private fun replaceReleases(jsonSchemaTemplate: String, releaseIds: Set<String>): String {
        val before = """
        |    "https://vulnlog.dev/on.vulnlog.schema.json": {
        |      "${'$'}schema": "https://json-schema.org/draft/2020-12/schema",
        |      "title": "Vulnlog On Schema",
        |      "oneOf": [
        |        {
        |          "type": "string"
        |        },
        |        {
        |          "type": "array",
        |          "items": {
        |            "type": "string"
        |          }
        |        }
        |      ]
        |    },
        """.trimMargin()


        val after = before
            .replace(
                "          \"type\": \"string\"",
                "          \"enum\": [${releaseIds.joinToString(",") { "\"$it\"" }}]"
            )
            .replace(
                "            \"type\": \"string\"",
                "            \"enum\": [${releaseIds.joinToString(",") { "\"$it\"" }}]"
            )
        
        return jsonSchemaTemplate.replace(before, after)
    }

    private fun writeSchemaToFile(replacedReleases: String) {
        println("Writing JSON schema to file: $outputFilename")
        File(outputFilename).writeText(replacedReleases)
    }
}
