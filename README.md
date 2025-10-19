# Vulnlog Proof of Concepts

## YAML and JSON Schema PoC

- [yaml](yaml) contains the JSON Schema and a simple CLI that parses Vulnlog YAML files.
  The [README](yaml/README.md) contains information to build and run the CLI and some learnings.
- [yaml-data](yaml-data) contains minimalistic Vulnlog YAML files.

### Quick Start

1. Download the latest release from [Releases](https://github.com/vulnlog/vulnlog-poc/releases).
2. Unzip the release.
3. Run the CLI: `./vulnlog-yaml-poc-0.1.0-linux/vl-yaml vulnlog-poc/yaml-data/product.vl.yml`

The output should be:

```console
Hello YAML/JSON-Schema Vulnlog!

Releases
id: product803
name: Product 8.0.3
version: 8.0.3
release date: 2024-10-05
id: product804
name: Product 8.0.4
version: 8.0.4
release date: 2024-12-09

Release Groups
id: product80
name: Product 8.0
refId: product803, product804

Reporters
id: trivy
name: Trivy
product: aquasec/trivy
id: owasp
name: OWASP Dependency Check
product: owasp/dependency-check

Reporter Pipelines
id: trivy-pipeline
name: Trivy Pipeline
id: owasp-pipeline
name: OWASP Dependency Check Pipeline
reporter: owasp
lifetime start: 2021-03-01
lifetime end: 2025-09-30

Vulnerabilities
desc: Information leak via uninitialized stack contents in the rsync daemon.
cwe: 908
reports:
  vulnerability id: CVE-2024-12085
  reporter id: trivy-pipeline
  at: 2024-12-18
  on-ids: product803, product804
  suppression:
    until: 2026-01-01
  vulnerability id: CVE-2024-12086, CVE-2024-12087
  reporter id: owasp-pipeline
  at: 2024-12-18
  on id: product804
analysis:
  at: 2024-12-18
  verdict not affected:
    vex: Component not present
  reasoning: In a typical environment the ports necessary for rsync are not exposed to the internet. Furthermore, the above vulnerability only occurs in the rsync daemon, which by default does not run on the product Docker container. Therefore, product is not affected. This vulnerability was reported in product 8.0.8, the latest publicly available version of the product 8.0 branch. The newest version of this branch, product 8.0.10, was released on 2025-05-07, and no longer reports this vulnerability.
resolutions:
  accept
    note: This is a test note.
  update
    note: This is another test note.
    maven dependency: foo:bar:1.2.3
    to version: 1.2.4
    resolved at: 2025-04-29
```
