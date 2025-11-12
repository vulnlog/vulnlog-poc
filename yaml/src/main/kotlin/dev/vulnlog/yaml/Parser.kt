package dev.vulnlog.yaml

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.dataformat.yaml.YAMLAnchorReplayingFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import dev.vulnlog.yaml.dto.ReportersVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema
import dev.vulnlog.yaml.dto.VulnlogSchema
import org.yaml.snakeyaml.LoaderOptions
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.jvm.java

class Parser {

    private val factory: YAMLFactory = YAMLFactory.builder()
        .loaderOptions(LoaderOptions().apply {
            codePointLimit = 100 * 1024 * 1024 // 100MB
        }).build()
    private val yamlFactory = YAMLAnchorReplayingFactory(factory, YAMLMapper())
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

        if (rootSchema.include != null) {
            val parentDir: Path = filePath.parent

            rootSchema.include.releases?.file?.let { releaseFile ->
                val schema: VulnlogSchema = parseYamlFile(parentDir.resolve(releaseFile))

                rootSchema.releases = schema.releases
            }

            rootSchema.include.reporters?.file?.let { reporterFile ->
                val schema: VulnlogSchema = parseYamlFile(parentDir.resolve(reporterFile))

                rootSchema.reporters = schema.reporters
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
