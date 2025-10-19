
package dev.vulnlog.yaml.dto;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "analysis",
    "cwe",
    "desc",
    "reports"
})
public class VulnerabilitiesVulnlogSchema {

    /**
     * Vulnlog Vulnerability Analysis Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("analysis")
    private List<VulnerabilitiesAnalysisVulnlogSchema> analysis = new ArrayList<VulnerabilitiesAnalysisVulnlogSchema>();
    /**
     * Common Weakness Enumeration
     * <p>
     * TODO
     * 
     */
    @JsonProperty("cwe")
    @JsonPropertyDescription("TODO")
    private int cwe;
    /**
     * Vulnerability Description
     * <p>
     * TODO
     * 
     */
    @JsonProperty("desc")
    @JsonPropertyDescription("TODO")
    private String desc;
    /**
     * Vulnlog Vulnerability Reports Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("reports")
    private List<VulnerabilitiesReportsVulnlogSchema> reports = new ArrayList<VulnerabilitiesReportsVulnlogSchema>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesVulnlogSchema() {
    }

    /**
     * 
     * @param cwe
     *     Common Weakness Enumeration. TODO.
     * @param reports
     *     Reports. TODO.
     * @param analysis
     *     Analysis. TODO.
     * @param desc
     *     Vulnerability Description. TODO.
     */
    public VulnerabilitiesVulnlogSchema(List<VulnerabilitiesAnalysisVulnlogSchema> analysis, int cwe, String desc, List<VulnerabilitiesReportsVulnlogSchema> reports) {
        super();
        this.analysis = analysis;
        this.cwe = cwe;
        this.desc = desc;
        this.reports = reports;
    }

    /**
     * Vulnlog Vulnerability Analysis Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("analysis")
    public List<VulnerabilitiesAnalysisVulnlogSchema> getAnalysis() {
        return analysis;
    }

    /**
     * Vulnlog Vulnerability Analysis Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("analysis")
    public void setAnalysis(List<VulnerabilitiesAnalysisVulnlogSchema> analysis) {
        this.analysis = analysis;
    }

    /**
     * Common Weakness Enumeration
     * <p>
     * TODO
     * 
     */
    @JsonProperty("cwe")
    public int getCwe() {
        return cwe;
    }

    /**
     * Common Weakness Enumeration
     * <p>
     * TODO
     * 
     */
    @JsonProperty("cwe")
    public void setCwe(int cwe) {
        this.cwe = cwe;
    }

    /**
     * Vulnerability Description
     * <p>
     * TODO
     * 
     */
    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    /**
     * Vulnerability Description
     * <p>
     * TODO
     * 
     */
    @JsonProperty("desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Vulnlog Vulnerability Reports Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("reports")
    public List<VulnerabilitiesReportsVulnlogSchema> getReports() {
        return reports;
    }

    /**
     * Vulnlog Vulnerability Reports Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("reports")
    public void setReports(List<VulnerabilitiesReportsVulnlogSchema> reports) {
        this.reports = reports;
    }

}
