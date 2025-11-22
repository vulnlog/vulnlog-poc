package dev.vulnlog.yaml

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.dataformat.yaml.YAMLAnchorReplayingFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import dev.vulnlog.yaml.dto.ReleasesVulnlogSchema
import dev.vulnlog.yaml.dto.ReportersVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema
import dev.vulnlog.yaml.dto.VulnlogSchema
import org.yaml.snakeyaml.LoaderOptions
import java.nio.file.Path
import kotlin.io.path.exists

class Parser {

    private val factory: YAMLFactory = YAMLFactory.builder()
        .loaderOptions(LoaderOptions().apply {
            codePointLimit = 100 * 1024 * 1024 // 100MB
        }).build()
    private val yamlFactory = YAMLAnchorReplayingFactory(factory, YAMLMapper())
    private val mapper = ObjectMapper(yamlFactory).apply {
        registerKotlinModule()
        registerModule(JavaTimeModule())

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
            .addDeserializer(
                ReportersVulnlogSchema.Vendor::class.java,
                VendorDeserializer()
            )
        registerModule(module)
    }

    /**
     * Read the YAML root file and resolve direct referenced files.
     */
    fun read(pathToFile: Path): VulnlogSchema {
        val filePath: Path = pathToFile.toAbsolutePath().normalize()
        val rootSchema = readYamlFile(filePath)

        if (rootSchema.include.isNotEmpty()) {
            val parentDir: Path = filePath.parent

            val parts: List<VulnlogSchema> = rootSchema.include.map { include ->
                parseYamlFile(parentDir.resolve(include))
            }

            val newReleases: MutableList<ReleasesVulnlogSchema> = rootSchema.releases
            val newReporters: MutableList<ReportersVulnlogSchema> = rootSchema.reporters

            parts.forEach { part ->
                if (!part.releases.isNullOrEmpty()) {
                    newReleases += part.releases
                }
                if (!part.reporters.isNullOrEmpty()) {
                    newReporters += part.reporters
                }
            }
            rootSchema.releases = newReleases
            rootSchema.reporters = newReporters
            rootSchema.include = emptyList()
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
