package dev.vulnlog.yaml

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.dataformat.yaml.YAMLAnchorReplayingFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema
import dev.vulnlog.yaml.dto.VulnlogSchema
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.exists

class Parser {
    private val yamlFactory = YAMLAnchorReplayingFactory()
    private val mapper = ObjectMapper(yamlFactory).apply {
        registerKotlinModule()

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
     * Read the YAML root file and resolve direct referenced files.
     */
    fun read(pathToFile: String): VulnlogSchema {
        val filePath: Path = Path(pathToFile).toAbsolutePath().normalize()
        val rootFile = readYamlFile(filePath)

        if (rootFile.include != null) {
            val parentDir: Path = filePath.parent

            if (rootFile.include.releases != null) {
                val referencedFilename: String = rootFile.include.releases.file
                val referencedFilePath = parentDir.resolve(referencedFilename)
                if (!referencedFilePath.exists()) {
                    error("Referenced file does not exist: $referencedFilePath")
                }

                val parsedInnerYamlFile = readYamlFile(referencedFilePath)

                rootFile.releases = parsedInnerYamlFile.releases
                rootFile.releaseGroups = parsedInnerYamlFile.releaseGroups
            }

            if (rootFile.include.reporters != null) {
                val referencedFilename: String = rootFile.include.reporters.file
                val referencedFilePath = parentDir.resolve(referencedFilename)
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

    private fun readYamlFile(path: Path): VulnlogSchema {
        return mapper.readValue(path.toFile(), VulnlogSchema::class.java)
    }
}
