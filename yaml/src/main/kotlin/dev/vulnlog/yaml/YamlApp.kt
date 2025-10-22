package dev.vulnlog.yaml

import dev.vulnlog.yaml.dto.ReleaseGroupsVulnlogSchema
import dev.vulnlog.yaml.dto.ReleasesVulnlogSchema
import dev.vulnlog.yaml.dto.ReporterPipelinesVulnlogSchema
import dev.vulnlog.yaml.dto.ReportersVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesReportsSuppressionVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesReportsVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesResolutionsVulnlogSchema
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
    println("refId: " + releaseGroupEntry.refIds.joinToString(", "))
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
    if (vulnEntry.analysis != null && vulnEntry.analysis.isNotEmpty()) {
        println("analysis:")
        vulnEntry.analysis.filter { it != null }.forEach(::printVulnAnalysisEntry)
    }
    if (vulnEntry.resolutions != null && vulnEntry.resolutions.isNotEmpty()) {
        println("resolutions:")
        vulnEntry.resolutions.filter { it != null }.forEach(::printVulnResolutionsEntry)
    }
}

private fun printVulnReportEntry(vulnReportEntry: VulnerabilitiesReportsVulnlogSchema) {
    when (vulnReportEntry.vulnId) {
        is String -> println("  vulnerability id: ${vulnReportEntry.vulnId}")
        is Collection<*> -> println(
            "  vulnerability id: " + (vulnReportEntry.vulnId as Collection<*>)
                .joinToString(", ")
        )
    }
    vulnReportEntry.reporterId?.let { println("  reporter id: $it") }
    vulnReportEntry.at?.let { println("  at: $it") }
    when (vulnReportEntry.onId) {
        is String -> println("  on id: ${vulnReportEntry.onId}")
        is Collection<*> -> println(
            "  on-ids: " + (vulnReportEntry.onId as Collection<*>)
                .joinToString(", ")
        )
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

private fun printVulnAnalysisEntry(vulnAnalysisEntry: VulnerabilitiesAnalysisVulnlogSchema) {
    vulnAnalysisEntry.at?.let { println("  at: $it") }
    print("  verdict ")
    if (vulnAnalysisEntry.verdict != null) {
        if (vulnAnalysisEntry.verdict.notAffected != null) {
            println("not affected:")
            vulnAnalysisEntry.verdict.notAffected.vex?.let { println("    vex: $it") }
        } else if (vulnAnalysisEntry.verdict.affected != null) {
            println("affected:")
            if (vulnAnalysisEntry.verdict.affected != null) {
                vulnAnalysisEntry.verdict.affected.severity?.let { println("    severity: $it") }
            }
        }
    }
    vulnAnalysisEntry.reasoning?.let { println("  reasoning: $it") }
}

private fun printVulnResolutionsEntry(vulnResolutionEntry: VulnerabilitiesResolutionsVulnlogSchema) {
    if (vulnResolutionEntry.accept != null) {
        println("  accept")
        vulnResolutionEntry.accept.note?.let { println("    note: $it") }
        printVulnResolutionOnEntry(vulnResolutionEntry.accept.onId)
    } else if (vulnResolutionEntry.fix != null) {
        println("  fix")
        vulnResolutionEntry.fix.note?.let { println("    note: $it") }
        printVulnResolutionOnEntry(vulnResolutionEntry.fix.onId)
    } else if (vulnResolutionEntry.rebuild != null) {
        println("  rebuild")
        vulnResolutionEntry.rebuild.note?.let { println("    note: $it") }
        printVulnResolutionOnEntry(vulnResolutionEntry.rebuild.onId)
    } else if (vulnResolutionEntry.update != null) {
        println("  update")
        vulnResolutionEntry.update.note?.let { println("    note: $it") }
        vulnResolutionEntry.update.mavenDependency?.let { println("    maven dependency: $it") }
        vulnResolutionEntry.update.to?.let { println("    to version: $it") }
        printVulnResolutionOnEntry(vulnResolutionEntry.update.onId)
        vulnResolutionEntry.update.resolvedAt?.let { println("    resolved at: $it") }
    }
}

private fun printVulnResolutionOnEntry(onId: Any?) {
    if (onId == null) return
    when (onId) {
        is String -> println("    on id: $onId")
        is Collection<*> -> println("    on-ids: " + onId.joinToString(", "))
    }
}
