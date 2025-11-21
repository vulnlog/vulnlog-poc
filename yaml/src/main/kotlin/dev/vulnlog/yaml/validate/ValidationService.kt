package dev.vulnlog.yaml.validate

import dev.vulnlog.yaml.dto.VulnlogSchema
import dev.vulnlog.yaml.validate.rules.VulnlogVersionRule


class ValidationService() {

    private interface RuleSet {
        fun rules(): List<ValidationRule<VulnlogSchema>>
    }

    private object InitRuleSet : RuleSet {
        override fun rules() = listOf(VulnlogVersionRule())
    }

    private object Version1RuleSet : RuleSet {
        override fun rules() = emptyList<ValidationRule<VulnlogSchema>>()
    }

    fun validate(result: VulnlogSchema): List<ValidationResult> {
        val initResults = versionSpecificValidation(InitRuleSet, result)
        if (initResults.isNotEmpty()) {
            return initResults
        }

        return if (Regex("^vulnlog/v1.*$").matches(result.version)) {
            versionSpecificValidation(Version1RuleSet, result)
        } else {
            error("Unsupported version ${result.version}")
        }
    }

    private fun versionSpecificValidation(
        ruleSet: RuleSet,
        result: VulnlogSchema
    ): List<ValidationResult> {
        val validatorEngine = ValidatorEngine(ruleSet.rules())
        return validatorEngine.validate(result)
    }
}
