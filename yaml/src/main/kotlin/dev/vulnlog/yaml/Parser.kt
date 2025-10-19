package dev.vulnlog.yaml

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.dataformat.yaml.YAMLAnchorReplayingFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema
import dev.vulnlog.yaml.dto.VulnlogSchema
import java.io.File

class Parser {
    private val yamlFactory = YAMLAnchorReplayingFactory()
    private val mapper = ObjectMapper(yamlFactory).apply {
        registerKotlinModule()

        // Register custom deserializer for Vex enum
        val module = SimpleModule()
        module
            .addDeserializer(
                VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex::class.java,
                VexDeserializer()
            )
            .addDeserializer(
                VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity::class.java,
                SeverityDeserializer()
            )
        registerModule(module)
    }

    /**
     * Read yaml root file and resolve referenced files.
     */
    fun read(pathToFile: String): VulnlogSchema {
        val file = File(pathToFile)
        val rootFile = readYamlFile(file)

        if (rootFile.include != null) {
            val rootDir = file.parentFile

            if (rootFile.include.releases != null) {
                val referencedFilename: String = rootFile.include.releases.file
                val referencedFilePath = rootDir.resolve(File(referencedFilename))
                if (!referencedFilePath.exists()) {
                    error("Referenced file does not exist: $referencedFilePath")
                }

                val parsedInnerYamlFile = readYamlFile(referencedFilePath)

                rootFile.releases = parsedInnerYamlFile.releases
                rootFile.releaseGroups = parsedInnerYamlFile.releaseGroups
            }

            if (rootFile.include.reporters != null) {
                val referencedFilename: String = rootFile.include.reporters.file
                val referencedFilePath = rootDir.resolve(File(referencedFilename))
                if (!referencedFilePath.exists()) {
                    error("Referenced file does not exist: $referencedFilePath")
                }

                val parsedInnerYamlFile = readYamlFile(referencedFilePath)

                rootFile.reporters = parsedInnerYamlFile.reporters
                rootFile.reporterPipelines = parsedInnerYamlFile.reporterPipelines
            }
        }
        return rootFile
    }

    private fun readYamlFile(file: File): VulnlogSchema {
        return mapper.readValue(file, VulnlogSchema::class.java)
    }
}
