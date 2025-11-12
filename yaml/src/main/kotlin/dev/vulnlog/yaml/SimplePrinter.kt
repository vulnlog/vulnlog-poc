package dev.vulnlog.yaml

import dev.vulnlog.yaml.dto.ReleasesVulnlogSchema
import dev.vulnlog.yaml.dto.ReportersVulnlogSchema
import dev.vulnlog.yaml.dto.VulnerabilitiesAnalysisVulnlogSchema
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

        if (result.releases != null && result.releases.isNotEmpty()) {
            println("Releases")
            result.releases.filter { it != null }.forEach(::printReleaseEntry)
            println()
            println()
        }

        if (result.reporters != null && result.reporters.isNotEmpty()) {
            println("Reporters")
            result.reporters.filter { it != null }.forEach(::printReporterEntry)
            println()
            println()
        }

        if (result.vulnerabilities != null && result.vulnerabilities.isNotEmpty()) {
            println("Vulnerabilities")
            result.vulnerabilities.filter { it != null }.forEach(::printVulnEntry)
        }
    }
}

private fun printReleaseEntry(releaseEntry: ReleasesVulnlogSchema) {
    releaseEntry.id?.let { println("id: $it") }
    releaseEntry.name?.let { println("name: $it") }
    releaseEntry.version?.let { println("version: $it") }
    releaseEntry.releaseDate?.let { println("release date: $it") }
}

private fun printReporterEntry(reporterEntry: ReportersVulnlogSchema) {
    reporterEntry.id?.let { println("id: $it") }
    reporterEntry.name?.let { println("name: $it") }
    reporterEntry.vendor?.let { println("vendor: $it") }
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

    if (!vulnReportEntry.reporters.isNullOrEmpty()) {
        vulnReportEntry.reporters.map { reporter -> reporter.reporter }
    }

    if (!vulnReportEntry.reporters.isNullOrEmpty()) {
        for (reporter in vulnReportEntry.reporters) {
            println("  reporter: ${reporter.reporter}")
            if (reporter.suppression != null && reporter.suppression is Map<*, *>) {
                for ((key, value) in reporter.suppression as Map<*, *>) {
                    when (value) {
                        is String -> println("    $key: $value")
                        is Collection<*> -> println(
                            "    $key: " + value.joinToString(", ")
                        )
                    }
                }
            }
        }
    }

    vulnReportEntry.at?.let { println("  at: $it") }
    when (vulnReportEntry.onId) {
        is String -> println("  on id: ${vulnReportEntry.onId}")
        is Collection<*> -> println(
            "  on-ids: " + (vulnReportEntry.onId as Collection<*>)
                .joinToString(", ")
        )
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
