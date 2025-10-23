
package dev.vulnlog.yaml.dto;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Vulnlog Schema
 * <p>
 * Validates Vulnlog YAML files.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "include",
    "release-groups",
    "releases",
    "reporter-pipelines",
    "reporters",
    "vulnerabilities"
})
public class VulnlogSchema {

    /**
     * Vulnlog Vulnerability Include Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("include")
    private VulnerabilitiesIncludeVulnlogSchema include;
    /**
     * Vulnlog Release Groups Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("release-groups")
    private List<ReleaseGroupsVulnlogSchema> releaseGroups = new ArrayList<ReleaseGroupsVulnlogSchema>();
    /**
     * Vulnlog Releases Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("releases")
    private List<ReleasesVulnlogSchema> releases = new ArrayList<ReleasesVulnlogSchema>();
    /**
     * Vulnlog Reporter Pipeline Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("reporter-pipelines")
    private List<ReporterPipelinesVulnlogSchema> reporterPipelines = new ArrayList<ReporterPipelinesVulnlogSchema>();
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
     * @param reporterPipelines
     *     Reporter Pipelines. Defines the reporter pipelines scanning this product.
     * @param vulnerabilities
     *     Vulnerabilities. Defines the vulnerabilities of the product.
     * @param releaseGroups
     *     Release Groups. Defines the release groups of the product.
     * @param releases
     *     Releases. Defines the releases of the product.
     */
    public VulnlogSchema(VulnerabilitiesIncludeVulnlogSchema include, List<ReleaseGroupsVulnlogSchema> releaseGroups, List<ReleasesVulnlogSchema> releases, List<ReporterPipelinesVulnlogSchema> reporterPipelines, List<ReportersVulnlogSchema> reporters, List<VulnerabilitiesVulnlogSchema> vulnerabilities) {
        super();
        this.include = include;
        this.releaseGroups = releaseGroups;
        this.releases = releases;
        this.reporterPipelines = reporterPipelines;
        this.reporters = reporters;
        this.vulnerabilities = vulnerabilities;
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
     * Vulnlog Release Groups Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("release-groups")
    public List<ReleaseGroupsVulnlogSchema> getReleaseGroups() {
        return releaseGroups;
    }

    /**
     * Vulnlog Release Groups Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("release-groups")
    public void setReleaseGroups(List<ReleaseGroupsVulnlogSchema> releaseGroups) {
        this.releaseGroups = releaseGroups;
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
     * Vulnlog Reporter Pipeline Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("reporter-pipelines")
    public List<ReporterPipelinesVulnlogSchema> getReporterPipelines() {
        return reporterPipelines;
    }

    /**
     * Vulnlog Reporter Pipeline Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("reporter-pipelines")
    public void setReporterPipelines(List<ReporterPipelinesVulnlogSchema> reporterPipelines) {
        this.reporterPipelines = reporterPipelines;
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
