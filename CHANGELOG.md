# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.5.0] - 2025-11-12

### Changed
- Replace `vulnlog` field with `version` and `metadata` in schema files by @ryru in [#15](https://github.com/vulnlog/vulnlog-poc/pull/15)
- Remove release groups and reporter pipelines to simplify Vulnlog files by @ryru in [#14](https://github.com/vulnlog/vulnlog-poc/pull/14)
- Upgrade Gradle wrapper to version 9.2.0 by @ryru in [#13](https://github.com/vulnlog/vulnlog-poc/pull/13)
- Document IDE auto-completion and schema reset in README with examples and visuals by @ryru in [#12](https://github.com/vulnlog/vulnlog-poc/pull/12)
- Restructure schema files and streamline multi-file JSON schema generation by @ryru
- Use `Path` for output handling and improve file path validation in schema generation by @ryru
- Support reporter in the custom schema generation CLI by @ryru
- Support for custom JSON schema generation in CLI by @ryru
- Extract the release 'on' JSON schema into a separate file and reference it from other locations by @ryru
- Add Snapcraft installation instructions and badge to README by @ryru
- Update for refs/tags/v0.4.1 by @github-actions[bot]

## [0.4.1] - 2025-10-31

### Changed
- Use dump plugin in snapcraft task by @ryru
- Simplify Snapcraft build and publishing workflow with updated actions by @ryru
- Move snapcraft.yaml to repo root because CI pipeline does not see it otherwise by @ryru
- Fix file upload filename by @ryru
- Reset GraalVM version back to 24 because of CI pipeline issues by @ryru
- Add Snapcraft packaging and publishing to the CD workflow by @ryru
- Add --version flag by @ryru
- Update to Java 25 in CD workflow and optimize build with -O2 flag by @ryru
- Move JSON schema files out of the Kotlin resources directory to not have them copied into the compiled JAR by @ryru
- Dont print empty groups by @ryru
- Support for multiple cwe per vulnerability by @ryru
- Support for multiple reporter-id per vulnerability report by @ryru
- Bump jsonschema to version 12.0.0 by @ryru
- Improve and update the project README.md and add single-file example.vl.yml by @ryru
- Update for refs/tags/v0.3.1 by @github-actions[bot]

## [0.3.1] - 2025-10-26

### Changed
- Fix macOS artifact name from x64 to arm64 by @ryru
- Update for refs/tags/v0.3.0 by @github-actions[bot]

## [0.3.0] - 2025-10-26

### Changed
- Add a simple benchmarking functionality into the CLI by @ryru
- Add Vulnlog version, vendor and product information to the schema by @ryru
- Allow to define vendor specific suppression properties for trivy, owasp and snyk by @ryru
- Update for refs/tags/v0.2.0 by @github-actions[bot]

## [0.2.0] - 2025-10-23

### Changed
- Add documentation description text on all YAML fields by @ryru
- Add more specific update resolution dependeny definitions by @ryru
- Update for refs/tags/v0.1.1 by @github-actions[bot]

### Fixed
- Add missing on-id in all resolutions and add remove resolution by @ryru

### New Contributors
* @github-actions[bot] made their first contribution

## [0.1.1] - 2025-10-20

### Added
- Add quick start instruction in the root README.md by @ryru

### Changed
- Add changelog generation and release creation to CD workflow by @ryru
- Simplify YAML include handling and extract reusable logic by @ryru

### Fixed
- Prevent NPE when an input file has no parent path by @ryru

## [0.1.0] - 2025-10-19

### Added
- Add windows to the CD native build job by @ryru
- Add macOS to the CD native build job by @ryru
- Add minimal GitHub workflows for CI and CD by @ryru
- Add a project README and remove unused files by @ryru
- Add resolutions definition by @ryru
- Add parsing for severity enum by @ryru
- Add analysis definition by @ryru
- Add more YAML and JSON schema parsing features by @ryru

### Changed
- Revert "Add windows to the CD native build job" by @ryru
- Fix missing jsonschema tool in CD pipeline by @ryru
- Fix missing jsonschema tool in CI pipeline by @ryru
- Bump Gradle to version 9.1.0 by @ryru
- Complete reporters definition by @ryru
- Fix linting task by @ryru
- Fix format applying Gradle task by @ryru
- Improve VEX enum processing and allow using user-friendly enum values instead of enum keys. by @ryru
- Bump GraalVM and Jackson libraries by @ryru
- Set up YAML parser as a native build by @ryru
- Set up YAML and JSON schema poc by @ryru
- Init vulnlog poc repo by @ryru

### New Contributors
* @ryru made their first contribution

[0.5.0]: https://github.com/vulnlog/vulnlog-poc/compare/v0.4.1...v0.5.0
[0.4.1]: https://github.com/vulnlog/vulnlog-poc/compare/v0.3.1...v0.4.1
[0.3.1]: https://github.com/vulnlog/vulnlog-poc/compare/v0.3.0...v0.3.1
[0.3.0]: https://github.com/vulnlog/vulnlog-poc/compare/v0.2.0...v0.3.0
[0.2.0]: https://github.com/vulnlog/vulnlog-poc/compare/v0.1.1...v0.2.0
[0.1.1]: https://github.com/vulnlog/vulnlog-poc/compare/v0.1.0...v0.1.1

<!-- generated by git-cliff -->
