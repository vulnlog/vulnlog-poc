package dev.vulnlog.yaml

import dev.vulnlog.yaml.dto.ReleaseGroupsVulnlogSchema
import dev.vulnlog.yaml.dto.ReleasesVulnlogSchema
import dev.vulnlog.yaml.dto.ReporterPipelinesVulnlogSchema
import dev.vulnlog.yaml.dto.ReportersVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesReportsSuppressionVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesReportsVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesResolutionsUpdateVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesResolutionsVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesVulnlogSchema
import dev.vulnlog.yaml.dto.VulnlogSchema

class SimplePrinter(val result: VulnlogSchema) {

    fun print() {
        println("version: ${result.vulnlog.version}")
        println("vendor: ${result.vulnlog.vendor}")
        println("product: ${result.vulnlog.product}")
        println()

        println("Releases")
        result.releases.filter { it != null }.forEach(::printReleaseEntry)
        println()
        println()

        println("Release Groups")
        result.releaseGroups.filter { it != null }.forEach(::printReleaseGroupEntry)
        println()
        println()

        println("Reporters")
        result.reporters.filter { it != null }.forEach(::printReporterEntry)
        println()
        println()

        println("Reporter Pipelines")
        result.reporterPipelines.filter { it != null }.forEach(::printReporterPipelineEntry)
        println()
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
    reporterEntry.vendor?.let { println("vendor: $it") }
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
    when (vulnEntry.cwe) {
        is String -> println("cwe: ${vulnEntry.cwe}")
        is Collection<*> -> println("cwe: " + (vulnEntry.cwe as Collection<*>).joinToString(", "))
    }
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
    println()
}

private fun printVulnReportEntry(vulnReportEntry: VulnerabilitiesReportsVulnlogSchema) {
    when (vulnReportEntry.vulnId) {
        is String -> println("  vulnerability id: ${vulnReportEntry.vulnId}")
        is Collection<*> -> println(
            "  vulnerability id: " + (vulnReportEntry.vulnId as Collection<*>)
                .joinToString(", ")
        )
    }
    when (vulnReportEntry.reporterId) {
        is String -> println("  reporter ID: ${vulnReportEntry.reporterId}")
        is Collection<*> -> println(
            "  reporter IDs: " + (vulnReportEntry.reporterId as Collection<*>).joinToString(
                ", "
            )
        )
    }
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
    if (vulnReportSuppressEntry.trivy != null) {
        println("    trivy:")
        if (vulnReportSuppressEntry.trivy.paths != null && vulnReportSuppressEntry.trivy.paths.isNotEmpty()) {
            println("      paths:")
            vulnReportSuppressEntry.trivy.paths.forEach { println("        $it") }
        }
        if (vulnReportSuppressEntry.trivy.purls != null && vulnReportSuppressEntry.trivy.purls.isNotEmpty()) {
            println("      purls:")
            vulnReportSuppressEntry.trivy.purls.forEach { println("        $it") }
        }
    }
    if (vulnReportSuppressEntry.owasp != null) {
        println("    owasp:")
        if (vulnReportSuppressEntry.owasp.paths != null && vulnReportSuppressEntry.owasp.paths.isNotEmpty()) {
            println("      paths:")
            vulnReportSuppressEntry.owasp.paths.forEach { println("        $it") }
        }
        if (vulnReportSuppressEntry.owasp.purls != null && vulnReportSuppressEntry.owasp.purls.isNotEmpty()) {
            println("      purls:")
            vulnReportSuppressEntry.owasp.purls.forEach { println("        $it") }
        }
        if (vulnReportSuppressEntry.owasp.cpe != null && vulnReportSuppressEntry.owasp.cpe.isNotEmpty()) {
            println("      cpe:")
            vulnReportSuppressEntry.owasp.cpe.forEach { println("        $it") }
        }
    }
    if (vulnReportSuppressEntry.snyk != null) {
        println("    snyk:")
        if (vulnReportSuppressEntry.snyk.paths != null && vulnReportSuppressEntry.snyk.paths.isNotEmpty()) {
            println("      paths:")
            vulnReportSuppressEntry.snyk.paths.forEach { println("        $it") }
        }
    }
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
    printVulnResolutionOnEntry(vulnAnalysisEntry.onId, 2)
}

private fun printVulnResolutionsEntry(vulnResolutionEntry: VulnerabilitiesResolutionsVulnlogSchema) {
    if (vulnResolutionEntry.accept != null) {
        println("  accept")
        vulnResolutionEntry.accept.note?.let { println("    note: $it") }
        printVulnResolutionOnEntry(vulnResolutionEntry.accept.onId, 4)
    } else if (vulnResolutionEntry.fix != null) {
        println("  fix")
        vulnResolutionEntry.fix.note?.let { println("    note: $it") }
        printVulnResolutionOnEntry(vulnResolutionEntry.fix.onId, 4)
    } else if (vulnResolutionEntry.rebuild != null) {
        println("  rebuild")
        vulnResolutionEntry.rebuild.note?.let { println("    note: $it") }
        printVulnResolutionOnEntry(vulnResolutionEntry.rebuild.onId, 4)
    } else if (vulnResolutionEntry.remove != null) {
        println("  remove")
        vulnResolutionEntry.remove.note?.let { println("    note: $it") }
        printVulnResolutionOnEntry(vulnResolutionEntry.remove.onId, 4)
    } else if (vulnResolutionEntry.update != null) {
        println("  update")
        vulnResolutionEntry.update.note?.let { println("    note: $it") }
        printVulnResolutionDependencyEntry(vulnResolutionEntry.update)
        vulnResolutionEntry.update.to?.let { println("    to version: $it") }
        printVulnResolutionOnEntry(vulnResolutionEntry.update.onId, 4)
        vulnResolutionEntry.update.resolvedAt?.let { println("    resolved at: $it") }
    }
}

private fun printVulnResolutionOnEntry(onId: Any?, indent: Int) {
    if (onId == null) return
    when (onId) {
        is String -> println("on id: $onId".prependIndent(" ".repeat(indent)))
        is Collection<*> -> println(
            "on-ids: ${onId.joinToString(", ")}".prependIndent(
                " ".repeat(
                    indent
                )
            )
        )
    }
}

private fun printVulnResolutionDependencyEntry(update: VulnerabilitiesResolutionsUpdateVulnlogSchema) {
    if (update.mavenDependency != null) {
        update.mavenDependency?.let { println("    maven dependency: $it") }
    } else if (update.npmDependency != null) {
        update.npmDependency?.let { println("    npm dependency: $it") }
    } else if (update.dependency != null) {
        update.dependency?.let { println("    generic dependency: $it") }
    } else if (update.containerDependency != null) {
        update.containerDependency?.let { println("    container dependency: $it") }
    } else {
        error("Unknown dependency type")
    }
}
