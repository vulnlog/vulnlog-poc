package dev.vulnlog.yaml

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLAnchorReplayingFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import dev.vulnlog.yaml.dto.VulnlogSchema
import java.io.File

class Parser {
    fun read(pathToFile: String): VulnlogSchema {
        val yamlFactory = YAMLAnchorReplayingFactory()
        val mapper = ObjectMapper(yamlFactory).registerKotlinModule()
        val schema: VulnlogSchema = mapper.readValue(File(pathToFile), VulnlogSchema::class.java)
        return schema
    }
}
