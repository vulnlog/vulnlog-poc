package dev.vulnlog.yaml

import dev.vulnlog.yaml.dto.ReleaseGroupsVulnlogSchema
import dev.vulnlog.yaml.dto.ReleasesVulnlogSchema
import dev.vulnlog.yaml.dto.ReporterPipelinesVulnlogSchema
import dev.vulnlog.yaml.dto.ReportersVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesReportsSuppressionVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesReportsVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesVulnlogSchema
import dev.vulnlog.yaml.dto.VulnlogSchema
import kotlin.collections.filter

fun main(args: Array<String>) {
    println("Hello YAML/JSON-Schema Vulnlog!")
    println()

    if (args.isNotEmpty() && args[0].isNotBlank()) {
        val parser = Parser()
        val result: VulnlogSchema = parser.read(args[0])

        println("Releases")
        result.releases.filter { it != null }.forEach(::printReleaseEntry)
        println()

        println("Release Groups")
        result.releaseGroups.filter { it != null }.forEach(::printReleaseGroupEntry)
        println()

        println("Reporters")
        result.reporters.filter { it != null }.forEach(::printReporterEntry)
        println()

        println("Reporter Pipelines")
        result.reporterPipelines.filter { it != null }.forEach(::printReporterPipelineEntry)
        println()

        println("Vulnerabilities")
        result.vulnerabilities.filter { it != null }.forEach(::printVulnEntry)
    }
}

private fun printReleaseEntry(releaseEntry: ReleasesVulnlogSchema) {
    releaseEntry.id?.let { println("id: $it") }
    releaseEntry.name?.let { println("name: $it") }
    releaseEntry.version?.let { println("version: $it") }
    releaseEntry.releaseDate?.let { println("release date: $it") }
}

private fun printReleaseGroupEntry(releaseGroupEntry: ReleaseGroupsVulnlogSchema) {
    releaseGroupEntry.id?.let { println("id: $it") }
    releaseGroupEntry.name?.let { println("name: $it") }
    releaseGroupEntry.refIds.forEach { println("refId: $it") }
}

private fun printReporterEntry(reporterEntry: ReportersVulnlogSchema) {
    reporterEntry.id?.let { println("id: $it") }
    reporterEntry.name?.let { println("name: $it") }
    reporterEntry.product?.let { println("product: $it") }
}

private fun printReporterPipelineEntry(reporterPipelineEntry: ReporterPipelinesVulnlogSchema) {
    reporterPipelineEntry.id?.let { println("id: $it") }
    reporterPipelineEntry.name?.let { println("name: $it") }
    reporterPipelineEntry.reporterRefId?.let { println("reporter: $it") }
    if (reporterPipelineEntry.lifetime != null) {
        reporterPipelineEntry.lifetime.start?.let { println("lifetime start: $it") }
        reporterPipelineEntry.lifetime.end?.let { println("lifetime end: $it") }
    }
}

private fun printVulnEntry(vulnEntry: VulnerabilitiesVulnlogSchema) {
    vulnEntry.desc?.let { println("desc: $it") }
    println("cwe: ${vulnEntry.cwe}")
    if (vulnEntry.reports != null && vulnEntry.reports.isNotEmpty()) {
        println("reports:")
        vulnEntry.reports.filter { it != null }.forEach(::printVulnReportEntry)
    }
}

private fun printVulnReportEntry(vulnReportEntry: VulnerabilitiesReportsVulnlogSchema) {
    vulnReportEntry.vulnId?.let { println("  vulnId: $it") }
    when (vulnReportEntry.on) {
        is String -> println("  on: ${vulnReportEntry.on}")
        is Collection<*> -> (vulnReportEntry.on as Collection<*>).forEach { println("  on: $it") }
    }
    if (vulnReportEntry.suppression != null && vulnReportEntry.suppression.isNotEmpty()) {
        println("  suppression:")
        vulnReportEntry.suppression.filter { it != null }.forEach(::printVulnReportSuppressionEntry)
    }
}

private fun printVulnReportSuppressionEntry(vulnReportSuppressEntry: VulnerabilitiesReportsSuppressionVulnlogSchema) {
    when (vulnReportSuppressEntry.on) {
        is String -> println("    on: ${vulnReportSuppressEntry.on}")
        is Collection<*> -> (vulnReportSuppressEntry.on as Collection<*>).forEach { println("    on: $it") }
    }
    vulnReportSuppressEntry.until?.let { println("    until: $it") }
}
