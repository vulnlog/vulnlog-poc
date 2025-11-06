package dev.vulnlog.yaml

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema

class SeverityDeserializer :
    JsonDeserializer<dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity>() {
    override fun deserialize(
        p: JsonParser,
        ctxt: DeserializationContext
    ): VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity {
        val value = p.text
        return when (value) {
            "Critical" -> VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity.CRITICAL
            "High" -> VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity.HIGH
            "Medium" -> VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity.MEDIUM
            "Low" -> VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity.LOW
            else -> throw IllegalArgumentException("Unknown severity value: $value")
        }
    }
}
