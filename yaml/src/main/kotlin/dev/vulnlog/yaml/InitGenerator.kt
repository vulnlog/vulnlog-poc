package dev.vulnlog.yaml

import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.writeText

class InitGenerator(val initDir: Path, val projectName: String) {
    fun init() {
        val projectFilename: Path = Path("${projectName}.vl.yml")
        initDir.resolve(projectFilename).writeText(
            """
            |---
            |version: vulnlog/v1
            |
            |vulnerabilities:
            |  - desc: Replace this text with your first vulnerability description.
            |
        """.trimMargin()
        )
    }
}
