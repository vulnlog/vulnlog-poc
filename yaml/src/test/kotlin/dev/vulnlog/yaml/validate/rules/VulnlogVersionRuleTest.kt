package dev.vulnlog.yaml.validate.rules

import dev.vulnlog.yaml.dto.VulnlogSchema
import dev.vulnlog.yaml.validate.Severity
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class VulnlogVersionRuleTest : FunSpec({

    val rule = VulnlogVersionRule()

    test("rule should have correct id") {
        rule.id shouldBe "VulnlogVersionRule"
    }

    test("rule should have correct description") {
        rule.description shouldBe "Vulnlog version must be set and valid"
    }

    test("should return error when version is null") {
        val schema = mockk<VulnlogSchema>()
        every { schema.version } returns null

        val results = rule.validate(schema)

        results shouldHaveSize 1
        results[0].ruleId shouldBe "VulnlogVersionRule"
        results[0].severity shouldBe Severity.ERROR
        results[0].message shouldBe "Vulnlog version is missing"
        results[0].location shouldBe ".version"
    }

    test("should return error when version format is invalid - missing prefix") {
        val schema = mockk<VulnlogSchema>()
        every { schema.version } returns "v1.0.0"

        val results = rule.validate(schema)

        results shouldHaveSize 1
        results[0].ruleId shouldBe "VulnlogVersionRule"
        results[0].severity shouldBe Severity.ERROR
        results[0].message shouldBe "Invalid Vulnlog version format: v1.0.0"
        results[0].location shouldBe ".version"
    }

    test("should return error when version format is invalid - no version number") {
        val schema = mockk<VulnlogSchema>()
        every { schema.version } returns "vulnlog/v"

        val results = rule.validate(schema)

        results shouldHaveSize 1
        results[0].severity shouldBe Severity.ERROR
        results[0].message shouldBe "Invalid Vulnlog version format: vulnlog/v"
    }

    test("should return error when version format is invalid - contains non-numeric characters") {
        val schema = mockk<VulnlogSchema>()
        every { schema.version } returns "vulnlog/v1.2.3beta"

        val results = rule.validate(schema)

        results shouldHaveSize 1
        results[0].severity shouldBe Severity.ERROR
        results[0].message shouldBe "Invalid Vulnlog version format: vulnlog/v1.2.3beta"
    }

    test("should return empty list when version has valid format - major version only") {
        val schema = mockk<VulnlogSchema>()
        every { schema.version } returns "vulnlog/v1"

        val results = rule.validate(schema)

        results.shouldBeEmpty()
    }

    test("should return empty list when version has valid format - major.minor") {
        val schema = mockk<VulnlogSchema>()
        every { schema.version } returns "vulnlog/v1.0"

        val results = rule.validate(schema)

        results.shouldBeEmpty()
    }

    test("should return empty list when version has valid format - major.minor.patch") {
        val schema = mockk<VulnlogSchema>()
        every { schema.version } returns "vulnlog/v1.0.0"

        val results = rule.validate(schema)

        results.shouldBeEmpty()
    }

    test("should return empty list when version has valid format - multi-digit numbers") {
        val schema = mockk<VulnlogSchema>()
        every { schema.version } returns "vulnlog/v10.25.123"

        val results = rule.validate(schema)

        results.shouldBeEmpty()
    }

    test("should return error when version has too many segments") {
        val schema = mockk<VulnlogSchema>()
        every { schema.version } returns "vulnlog/v1.0.0.0"

        val results = rule.validate(schema)

        results shouldHaveSize 1
        results[0].severity shouldBe Severity.ERROR
        results[0].message shouldBe "Invalid Vulnlog version format: vulnlog/v1.0.0.0"
    }

    test("should return error when version has invalid separator") {
        val schema = mockk<VulnlogSchema>()
        every { schema.version } returns "vulnlog-v1.0.0"

        val results = rule.validate(schema)

        results shouldHaveSize 1
        results[0].severity shouldBe Severity.ERROR
    }
})
