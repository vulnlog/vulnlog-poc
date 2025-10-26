package dev.vulnlog.yaml

import dev.vulnlog.yaml.dto.VulnlogSchema
import kotlin.io.path.Path
import kotlin.io.path.isRegularFile
import kotlin.system.exitProcess
import kotlin.time.measureTimedValue

fun main(args: Array<String>) {
    if (args.isEmpty() || args.contains("--help") || args.contains("-h")) {
        println("Usage: vl-yaml <path-to-yaml-file> [--benchmark]")
        exitProcess(0)
    }


    println("Hello YAML/JSON-Schema Vulnlog!")
    println("This is a PoC to experiment with YAML and JSON-Schema as an alternative to the existing Kotlin custom scripting DSL.")
    println("See https://github.com/vulnlog/vulnlog-poc for more information.")
    println()

    val isBenchMark = args.isNotEmpty() && args.contains("--benchmark")

    if (args.isNotEmpty() && args[0].isNotBlank() && Path(args[0]).isRegularFile()) {

        val (result, timeToParseInMs) = measureTimedValue {
            val parser = Parser()
            val result: VulnlogSchema = parser.read(args[0])
            result
        }

        if (!isBenchMark) {
            val printer = SimplePrinter(result)
            printer.print()
        } else {
            println("Number of vulnerabilities: ${result.vulnerabilities.size}")
            println("Time to parse: ${timeToParseInMs.inWholeMilliseconds} ms")
        }
    } else {
        println("Invalid file path: ${args[0]}")
        exitProcess(1)
    }
}
