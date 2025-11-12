
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
    "vulnlog",
    "include",
    "releases",
    "reporters",
    "vulnerabilities"
})
public class VulnlogSchema {

    /**
     * Vulnlog Vulnlog Schema
     * <p>
     * Validates Vulnlog Vulnlog YAML files.
     * 
     */
    @JsonProperty("vulnlog")
    @JsonPropertyDescription("Validates Vulnlog Vulnlog YAML files.")
    private VulnlogVulnlogSchema vulnlog;
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
     * @param reporters
     *     Reporters. Defines the reporters of vulnerabilities on the product.
     * @param vulnlog
     *     Vulnlog General Information. Common information about the Vulnlog file.
     * @param vulnerabilities
     *     Vulnerabilities. Defines the vulnerabilities of the product.
     * @param releases
     *     Releases. Defines the releases of the product.
     */
    public VulnlogSchema(VulnlogVulnlogSchema vulnlog, VulnerabilitiesIncludeVulnlogSchema include, List<ReleasesVulnlogSchema> releases, List<ReportersVulnlogSchema> reporters, List<VulnerabilitiesVulnlogSchema> vulnerabilities) {
        super();
        this.vulnlog = vulnlog;
        this.include = include;
        this.releases = releases;
        this.reporters = reporters;
        this.vulnerabilities = vulnerabilities;
    }

    /**
     * Vulnlog Vulnlog Schema
     * <p>
     * Validates Vulnlog Vulnlog YAML files.
     * 
     */
    @JsonProperty("vulnlog")
    public VulnlogVulnlogSchema getVulnlog() {
        return vulnlog;
    }

    /**
     * Vulnlog Vulnlog Schema
     * <p>
     * Validates Vulnlog Vulnlog YAML files.
     * 
     */
    @JsonProperty("vulnlog")
    public void setVulnlog(VulnlogVulnlogSchema vulnlog) {
        this.vulnlog = vulnlog;
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
     * 
     */
    @JsonProperty("vulnerabilities")
    public void setVulnerabilities(List<VulnerabilitiesVulnlogSchema> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

}
