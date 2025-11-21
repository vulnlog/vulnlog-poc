package dev.vulnlog.yaml.validate.rules

import dev.vulnlog.yaml.dto.VulnlogSchema
import dev.vulnlog.yaml.validate.Severity
import dev.vulnlog.yaml.validate.ValidationResult
import dev.vulnlog.yaml.validate.ValidationRule

class VulnlogVersionRule : ValidationRule<VulnlogSchema> {
    override val id: String
        get() = "VulnlogVersionRule"
    override val description: String
        get() = "Vulnlog version must be set and valid"

    override fun validate(model: VulnlogSchema): List<ValidationResult> {
        val location = ".version"
        return if (model.version == null) {
            listOf(ValidationResult(id, Severity.ERROR, "Vulnlog version is missing", location))
        } else if (!model.version.matches(Regex("^vulnlog/v\\d+(\\.\\d+)?(\\.\\d+)?$"))) {
            listOf(ValidationResult(id, Severity.ERROR, "Invalid Vulnlog version format: ${model.version}", location))
        } else {
            emptyList()
        }
    }
}
