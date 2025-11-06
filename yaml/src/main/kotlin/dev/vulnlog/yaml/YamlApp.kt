package dev.vulnlog.yaml

import dev.vulnlog.yaml.dto.VulnlogSchema
import kotlin.io.path.Path
import kotlin.io.path.isRegularFile
import kotlin.system.exitProcess
import kotlin.time.measureTimedValue

fun main(args: Array<String>) {
    if (args.isEmpty() || args.contains("--help") || args.contains("-h")) {
        println("Usage: vl-yaml <path-to-yaml-file> [--benchmark | --generate-schema=output.json]")
        println("Flags")
        println("  --benchmark:                    print the number of vulnerabilities and the time to parse the file")
        println("  --generate-schema=output.json:  generate a JSON-Schema for the YAML file and save it to output.json")
        println("  --reset-schema=output.json:     reset to the default JSON-Schema and save it to output.json")
        exitProcess(0)
    }

    if (args.contains("--version") || args.contains("-v")) {
        val cliVersion: String = object {}.javaClass.`package`.implementationVersion ?: "dev"
        println("vl-yaml version $cliVersion")
        exitProcess(0)
    }

    println("Hello YAML/JSON-Schema Vulnlog!")
    println("This is a PoC to experiment with YAML and JSON-Schema as an alternative to the existing Kotlin custom scripting DSL.")
    println("See https://github.com/vulnlog/vulnlog-poc for more information.")
    println()

    val isBenchMark = args.isNotEmpty() && args.contains("--benchmark")
    val isResetSchema = args.isNotEmpty() && args.find{ it.startsWith("--reset-schema=") } != null
    val isGenerateSchema = args.isNotEmpty() && args.find{ it.startsWith("--generate-schema=") } != null


    if (args.isNotEmpty() && args[0].isNotBlank() && Path(args[0]).isRegularFile()) {

        val (result, timeToParseInMs) = measureTimedValue {
            val parser = Parser()
            val result: VulnlogSchema = parser.read(args[0])
            result
        }

        if (isBenchMark) {
            println("Number of vulnerabilities: ${result.vulnerabilities.size}")
            println("Time to parse: ${timeToParseInMs.inWholeMilliseconds} ms")
        } else if (isResetSchema) {
            val outputFilename: String = args.find { it.startsWith("--reset-schema=") }?.substringAfter("=") ?: "output.json"
            val generator = GenerateCustomJsonSchema(result, outputFilename)
            generator.reset()
        } else if (isGenerateSchema) {
            val outputFilename: String = args.find { it.startsWith("--generate-schema=") }?.substringAfter("=") ?: "output.json"
            val generator = GenerateCustomJsonSchema(result, outputFilename)
            generator.generate()
        } else {
            val printer = SimplePrinter(result)
            printer.print()
        }
    } else {
        println("Invalid file path: ${args[0]}")
        exitProcess(1)
    }
}
