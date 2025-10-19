package dev.vulnlog.yaml

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema

class VexDeserializer :
    JsonDeserializer<VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex>() {
    override fun deserialize(
        p: JsonParser,
        ctxt: DeserializationContext
    ): VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex {
        val value = p.text
        return when (value) {
            "Component not present" -> VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex.COMPONENT_NOT_PRESENT
            "Inline mitigations already exist" -> VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex.INLINE_MITIGATIONS_ALREADY_EXIST
            "Vulnerable code cannot be controlled by adversary" -> VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex.VULNERABLE_CODE_CANNOT_BE_CONTROLLED_BY_ADVERSARY
            "Vulnerable code not in execute path" -> VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex.VULNERABLE_CODE_NOT_IN_EXECUTE_PATH
            "Vulnerable code not present" -> VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex.VULNERABLE_CODE_NOT_PRESENT
            else -> throw IllegalArgumentException("Unknown VEX value: $value")
        }
    }
}
