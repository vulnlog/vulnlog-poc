package dev.vulnlog.yaml.validate

class ValidatorEngine<T>(private val rules: List<ValidationRule<T>>) {
    fun validate(model: T): List<ValidationResult> =
        rules.flatMap { it.validate(model) }
}
