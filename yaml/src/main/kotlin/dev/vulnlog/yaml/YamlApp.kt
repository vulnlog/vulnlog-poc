package dev.vulnlog.yaml

import dev.vulnlog.yaml.dto.VulnlogSchema
import dev.vulnlog.yaml.validate.Severity
import dev.vulnlog.yaml.validate.ValidationService
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.absolute
import kotlin.io.path.isDirectory
import kotlin.io.path.isRegularFile
import kotlin.system.exitProcess
import kotlin.time.measureTimedValue

fun main(args: Array<String>) {
    if (args.isEmpty() || args.contains("--help") || args.contains("-h")) {
        println("Usage: vl-yaml <path-to-yaml-file> [--benchmark | --generate-schema=output.json | --reset-schema=output.json] | --validate | --version | --help")
        println("Flags")
        println("  --init=DIR:                     initialize a new Vulnlog project with a minimal Vulnlog file and JSON schema")
        println("  --benchmark:                    print the number of vulnerabilities and the time to parse the file")
        println("  --generate-schema=output.json:  generate a JSON-Schema for the YAML file and save it to output.json")
        println("  --reset-schema=output.json:     reset to the default JSON-Schema and save it to output.json")
        println("  --validate:                     validate the Vulnlog files")
        println("  --version:                      show the version of the application")
        println("  --help:                         show this help message")
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

    val isInit = args.isNotEmpty() && args.find { it.startsWith("--init=") } != null

    var generatedInitFile: Path? = null
    if (isInit) {
        val initDir: String = args.find { it.startsWith("--init=") }?.substringAfter("=")
            ?: error("Missing --init=<dir> argument")
        val initPath = Path.of(initDir).absolute().normalize()
        if (initPath.isDirectory()) {
            print("project name: ")
            val projectName = readln()
            val initGenerator = InitGenerator(initPath, projectName)
            initGenerator.init()
            generatedInitFile = initPath.resolve("$projectName.vl.yml")
        } else {
            error("--init=<dir> argument must be a directory, not a file: $initDir")
        }
    }

    val inputVulnlogFile: Path = if (Path(args[0]).isRegularFile()) {
        Path(args[0])
    } else if (isInit && generatedInitFile != null) {
        generatedInitFile
    } else {
        println("Invalid file path: ${args[0]}")
        exitProcess(1)
    }

    val isBenchMark = args.contains("--benchmark")
    val isResetSchema = args.find { it.startsWith("--reset-schema=") } != null
    val isGenerateSchema = args.find { it.startsWith("--generate-schema=") } != null || isInit
    val isValidate = args.contains("--validate")

    val (result, timeToParseInMs) = measureTimedValue {
        val parser = Parser()
        val result: VulnlogSchema = parser.read(inputVulnlogFile)
        result
    }

    if (isBenchMark) {
        println("Number of vulnerabilities: ${result.vulnerabilities.size}")
        println("Time to parse: ${timeToParseInMs.inWholeMilliseconds} ms")
    } else if (isResetSchema) {
        val parseFilename: String? =
            args.find { it.startsWith("--reset-schema=") }?.substringAfter("=")
        val outputFilename: Path = if (parseFilename != null) {
            Path(parseFilename)
        } else {
            inputVulnlogFile.parent.resolve("vulnlog-schema.json")
        }
        val generator = GenerateCustomJsonSchema(result, outputFilename)
        generator.reset()
    } else if (isGenerateSchema) {
        val parseFilename: String? =
            args.find { it.startsWith("--generate-schema=") }?.substringAfter("=")
        val outputFilename: Path = if (parseFilename != null) {
            Path(parseFilename)
        } else {
            inputVulnlogFile.parent.resolve("vulnlog-schema.json")
        }
        val generator = GenerateCustomJsonSchema(result, outputFilename)
        generator.generate()
    } else if (isValidate) {
        handleValidation(result)
        println("Validation successful")
    } else {
        handleValidation(result)
        val printer = SimplePrinter(result)
        printer.print()
    }
}

private fun handleValidation(result: VulnlogSchema) {
    val validationService = ValidationService()
    val validationResults = validationService.validate(result)
    if (validationResults.isNotEmpty()) {
        println("Validation failed")
        validationResults.forEach {
            println("${it.severity}: ${it.message} (${it.ruleId})")
            println("  at ${it.location}")
        }
        if (validationResults.any { it.severity == Severity.ERROR }) {
            exitProcess(1)
        }
    }
}
