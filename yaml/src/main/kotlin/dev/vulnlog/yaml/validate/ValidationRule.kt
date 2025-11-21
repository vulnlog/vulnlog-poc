package dev.vulnlog.yaml.validate

interface ValidationRule<T> {
    val id: String
    val description: String
    fun validate(model: T): List<ValidationResult>
}

enum class Severity {
    /**
     * Indicates a minor issue or redundancy or potential improvement in the Vulnlog definitions.
     * The application will continue to process the Vulnlog file.
     */
    INFO,

    /**
     * Indicates issues in the Vulnlog file informing the user of a potential unintended definition in the Vulnlog file.
     * The application will continue to process the Vulnlog file.
     */
    WARNING,

    /**
     * Indicates critical issues in the Vulnlog file so validation fails, and the application exits.
     */
    ERROR
}

data class ValidationResult(
    val ruleId: String,
    val severity: Severity,
    val message: String,
    val location: String
)
