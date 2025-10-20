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
        val rootSchema = readYamlFile(filePath)

        if (rootSchema.include != null) {
            val parentDir: Path = filePath.parent

            rootSchema.include.releases?.file?.let { releaseFile ->
                val schema: VulnlogSchema = parseYamlFile(parentDir.resolve(releaseFile))

                rootSchema.releases = schema.releases
                rootSchema.releaseGroups = schema.releaseGroups
            }

            rootSchema.include.reporters?.file?.let { reporterFile ->
                val schema: VulnlogSchema = parseYamlFile(parentDir.resolve(reporterFile))

                rootSchema.reporters = schema.reporters
                rootSchema.reporterPipelines = schema.reporterPipelines
            }
        }
        return rootSchema
    }

    private fun readYamlFile(path: Path): VulnlogSchema {
        return mapper.readValue(path.toFile(), VulnlogSchema::class.java)
    }

    private fun parseYamlFile(referencedFilePath: Path): VulnlogSchema {
        if (!referencedFilePath.exists()) {
            error("Referenced file does not exist: $referencedFilePath")
        }
        return readYamlFile(referencedFilePath)
    }
}
