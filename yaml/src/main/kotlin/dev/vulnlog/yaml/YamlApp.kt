package dev.vulnlog.yaml

import dev.vulnlog.yaml.dto.VulnlogSchema

fun main(args: Array<String>) {
    println("Hello YAML Vulnlog!")
    println()

    if (args.isNotEmpty() && args[0].isNotBlank()) {
        val parser = Parser()
        val result: VulnlogSchema = parser.read(args[0])
        result.additionalProperties.forEach { (k, v) -> printRecursively(k, v, 0) }
    }
}

fun printRecursively(key: String, value: Any, depth: Int) {
    when (value) {
        is Map<*, *> -> value.forEach { (k, v) -> printRecursively("$key.$k", v!!, depth + 1) }
        is List<*> -> value.forEachIndexed { i, v -> printRecursively("$key[$i]", v!!, depth + 1) }
        else -> println("$key: $value".prependIndent("  ".repeat(depth)))
    }
}
