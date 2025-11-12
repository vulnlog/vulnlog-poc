
package dev.vulnlog.yaml.dto;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Vulnlog Schema
 * <p>
 * Validates Vulnlog YAML files.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "version",
    "metadata",
    "include",
    "releases",
    "reporters",
    "vulnerabilities"
})
public class VulnlogSchema {

    /**
     * Version
     * <p>
     * The Schema version. Must be prefixed with "vulnlog/v" and followed by a semantic version number. Example: "vulnlog/v1.0.0".
     * (Required)
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("The Schema version. Must be prefixed with \"vulnlog/v\" and followed by a semantic version number. Example: \"vulnlog/v1.0.0\".")
    private String version;
    /**
     * Vulnlog Metadata Schema
     * <p>
     * Validates Vulnlog Vulnlog YAML files.
     * 
     */
    @JsonProperty("metadata")
    @JsonPropertyDescription("Validates Vulnlog Vulnlog YAML files.")
    private MetadataSchema metadata;
    /**
     * Vulnlog Vulnerability Include Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("include")
    private VulnerabilitiesIncludeVulnlogSchema include;
    /**
     * Vulnlog Releases Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("releases")
    private List<ReleasesVulnlogSchema> releases = new ArrayList<ReleasesVulnlogSchema>();
    /**
     * Vulnlog Reporters Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("reporters")
    private List<ReportersVulnlogSchema> reporters = new ArrayList<ReportersVulnlogSchema>();
    /**
     * Vulnlog Vulnerability Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("vulnerabilities")
    private List<VulnerabilitiesVulnlogSchema> vulnerabilities = new ArrayList<VulnerabilitiesVulnlogSchema>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnlogSchema() {
    }

    /**
     * 
     * @param include
     *     Include Files. Include other Vulnlog files in this Vulnlog file.
     * @param metadata
     *     Additional Information. Context information around this Vulnlog file. These information help to provide more context in Vulnlog generated artifacts.
     * @param reporters
     *     Reporters. Defines the reporters of vulnerabilities on the product.
     * @param vulnerabilities
     *     Vulnerabilities. Defines the vulnerabilities of the product.
     * @param version
     *     Version. The Schema version. Must be prefixed with "vulnlog/v" and followed by a semantic version number. Example: "vulnlog/v1.0.0".
     * @param releases
     *     Releases. Defines the releases of the product.
     */
    public VulnlogSchema(String version, MetadataSchema metadata, VulnerabilitiesIncludeVulnlogSchema include, List<ReleasesVulnlogSchema> releases, List<ReportersVulnlogSchema> reporters, List<VulnerabilitiesVulnlogSchema> vulnerabilities) {
        super();
        this.version = version;
        this.metadata = metadata;
        this.include = include;
        this.releases = releases;
        this.reporters = reporters;
        this.vulnerabilities = vulnerabilities;
    }

    /**
     * Version
     * <p>
     * The Schema version. Must be prefixed with "vulnlog/v" and followed by a semantic version number. Example: "vulnlog/v1.0.0".
     * (Required)
     * 
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version
     * <p>
     * The Schema version. Must be prefixed with "vulnlog/v" and followed by a semantic version number. Example: "vulnlog/v1.0.0".
     * (Required)
     * 
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Vulnlog Metadata Schema
     * <p>
     * Validates Vulnlog Vulnlog YAML files.
     * 
     */
    @JsonProperty("metadata")
    public MetadataSchema getMetadata() {
        return metadata;
    }

    /**
     * Vulnlog Metadata Schema
     * <p>
     * Validates Vulnlog Vulnlog YAML files.
     * 
     */
    @JsonProperty("metadata")
    public void setMetadata(MetadataSchema metadata) {
        this.metadata = metadata;
    }

    /**
     * Vulnlog Vulnerability Include Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("include")
    public VulnerabilitiesIncludeVulnlogSchema getInclude() {
        return include;
    }

    /**
     * Vulnlog Vulnerability Include Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("include")
    public void setInclude(VulnerabilitiesIncludeVulnlogSchema include) {
        this.include = include;
    }

    /**
     * Vulnlog Releases Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("releases")
    public List<ReleasesVulnlogSchema> getReleases() {
        return releases;
    }

    /**
     * Vulnlog Releases Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("releases")
    public void setReleases(List<ReleasesVulnlogSchema> releases) {
        this.releases = releases;
    }

    /**
     * Vulnlog Reporters Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("reporters")
    public List<ReportersVulnlogSchema> getReporters() {
        return reporters;
    }

    /**
     * Vulnlog Reporters Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("reporters")
    public void setReporters(List<ReportersVulnlogSchema> reporters) {
        this.reporters = reporters;
    }

    /**
     * Vulnlog Vulnerability Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("vulnerabilities")
    public List<VulnerabilitiesVulnlogSchema> getVulnerabilities() {
        return vulnerabilities;
    }

    /**
     * Vulnlog Vulnerability Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("vulnerabilities")
    public void setVulnerabilities(List<VulnerabilitiesVulnlogSchema> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

}
