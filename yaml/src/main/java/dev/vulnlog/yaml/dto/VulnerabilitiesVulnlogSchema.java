
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
    "reports",
    "resolutions"
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
     * The Common Weakness Enumeration (CWE) identifier that represents the type of vulnerability. CWE is a community-developed list of software and hardware weakness types.
     * 
     */
    @JsonProperty("cwe")
    @JsonPropertyDescription("The Common Weakness Enumeration (CWE) identifier that represents the type of vulnerability. CWE is a community-developed list of software and hardware weakness types.")
    private Object cwe;
    /**
     * Vulnerability Description
     * <p>
     * A short summary of the vulnerability and its impact on the product.
     * 
     */
    @JsonProperty("desc")
    @JsonPropertyDescription("A short summary of the vulnerability and its impact on the product.")
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
     * Vulnlog Vulnerability Resolutions Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("resolutions")
    private List<VulnerabilitiesResolutionsVulnlogSchema> resolutions = new ArrayList<VulnerabilitiesResolutionsVulnlogSchema>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesVulnlogSchema() {
    }

    /**
     * 
     * @param cwe
     *     Common Weakness Enumeration. The Common Weakness Enumeration (CWE) identifier that represents the type of vulnerability. CWE is a community-developed list of software and hardware weakness types.
     * @param reports
     *     Vulnerability Reports. A list of vulnerability reports, each issues by a reporter.
     * @param resolutions
     *     Vulnerability Resolutions. A list of resolutions describing how the vulnerability may be resolved.
     * @param analysis
     *     Vulnerability Analysis. Analysis of the vulnerability and assessment of whether and, if so, how problematic the vulnerability is for the product.
     * @param desc
     *     Vulnerability Description. A short summary of the vulnerability and its impact on the product.
     */
    public VulnerabilitiesVulnlogSchema(List<VulnerabilitiesAnalysisVulnlogSchema> analysis, Object cwe, String desc, List<VulnerabilitiesReportsVulnlogSchema> reports, List<VulnerabilitiesResolutionsVulnlogSchema> resolutions) {
        super();
        this.analysis = analysis;
        this.cwe = cwe;
        this.desc = desc;
        this.reports = reports;
        this.resolutions = resolutions;
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
     * The Common Weakness Enumeration (CWE) identifier that represents the type of vulnerability. CWE is a community-developed list of software and hardware weakness types.
     * 
     */
    @JsonProperty("cwe")
    public Object getCwe() {
        return cwe;
    }

    /**
     * Common Weakness Enumeration
     * <p>
     * The Common Weakness Enumeration (CWE) identifier that represents the type of vulnerability. CWE is a community-developed list of software and hardware weakness types.
     * 
     */
    @JsonProperty("cwe")
    public void setCwe(Object cwe) {
        this.cwe = cwe;
    }

    /**
     * Vulnerability Description
     * <p>
     * A short summary of the vulnerability and its impact on the product.
     * 
     */
    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    /**
     * Vulnerability Description
     * <p>
     * A short summary of the vulnerability and its impact on the product.
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

    /**
     * Vulnlog Vulnerability Resolutions Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("resolutions")
    public List<VulnerabilitiesResolutionsVulnlogSchema> getResolutions() {
        return resolutions;
    }

    /**
     * Vulnlog Vulnerability Resolutions Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("resolutions")
    public void setResolutions(List<VulnerabilitiesResolutionsVulnlogSchema> resolutions) {
        this.resolutions = resolutions;
    }

}
