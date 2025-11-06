package dev.vulnlog.yaml

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import dev.vulnlog.yaml.dto.ReportersVulnlogSchema

class VendorDeserializer :
    JsonDeserializer<ReportersVulnlogSchema.Vendor>() {
    override fun deserialize(
        p: JsonParser,
        ctxt: DeserializationContext
    ): ReportersVulnlogSchema.Vendor {
        val value = p.text
        return when (value) {
            "Aqua Security Trivy" -> ReportersVulnlogSchema.Vendor.AQUA_SECURITY_TRIVY
            "OWASP Dependency Check" -> ReportersVulnlogSchema.Vendor.OWASP_DEPENDENCY_CHECK
            "Snyk Open Source" -> ReportersVulnlogSchema.Vendor.SNYK_OPEN_SOURCE
            else -> throw IllegalArgumentException("Unknown vendor value: $value")
        }
    }
}
