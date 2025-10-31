
package dev.vulnlog.yaml.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "at",
    "on-id",
    "reporter-id",
    "suppression",
    "vuln-id"
})
public class VulnerabilitiesReportsVulnlogSchema {

    /**
     * Reported at Date
     * <p>
     * Date on which this report was created. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("at")
    @JsonPropertyDescription("Date on which this report was created. Format: YYYY-MM-DD")
    private String at;
    /**
     * Reported Release
     * <p>
     * Releases on which this vulnerability report applies to.
     * 
     */
    @JsonProperty("on-id")
    @JsonPropertyDescription("Releases on which this vulnerability report applies to.")
    private Object onId;
    /**
     * Reporter
     * <p>
     * Reporter of this vulnerability report.
     * 
     */
    @JsonProperty("reporter-id")
    @JsonPropertyDescription("Reporter of this vulnerability report.")
    private Object reporterId;
    /**
     * Vulnlog Vulnerability Report Suppression Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("suppression")
    private List<VulnerabilitiesReportsSuppressionVulnlogSchema> suppression = new ArrayList<VulnerabilitiesReportsSuppressionVulnlogSchema>();
    /**
     * Vulnerability ID
     * <p>
     * Identifier of the vulnerability. Can be a CVE or a Snyk ID.
     * 
     */
    @JsonProperty("vuln-id")
    @JsonPropertyDescription("Identifier of the vulnerability. Can be a CVE or a Snyk ID.")
    private Object vulnId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesReportsVulnlogSchema() {
    }

    /**
     * 
     * @param at
     *     Reported at Date. Date on which this report was created. Format: YYYY-MM-DD.
     * @param vulnId
     *     Vulnerability ID. Identifier of the vulnerability. Can be a CVE or a Snyk ID.
     * @param suppression
     *     Suppress Report. Whether this report should be suppressed.
     * @param reporterId
     *     Reporter. Reporter of this vulnerability report.
     * @param onId
     *     Reported Release. Releases on which this vulnerability report applies to.
     */
    public VulnerabilitiesReportsVulnlogSchema(String at, Object onId, Object reporterId, List<VulnerabilitiesReportsSuppressionVulnlogSchema> suppression, Object vulnId) {
        super();
        this.at = at;
        this.onId = onId;
        this.reporterId = reporterId;
        this.suppression = suppression;
        this.vulnId = vulnId;
    }

    /**
     * Reported at Date
     * <p>
     * Date on which this report was created. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("at")
    public String getAt() {
        return at;
    }

    /**
     * Reported at Date
     * <p>
     * Date on which this report was created. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("at")
    public void setAt(String at) {
        this.at = at;
    }

    /**
     * Reported Release
     * <p>
     * Releases on which this vulnerability report applies to.
     * 
     */
    @JsonProperty("on-id")
    public Object getOnId() {
        return onId;
    }

    /**
     * Reported Release
     * <p>
     * Releases on which this vulnerability report applies to.
     * 
     */
    @JsonProperty("on-id")
    public void setOnId(Object onId) {
        this.onId = onId;
    }

    /**
     * Reporter
     * <p>
     * Reporter of this vulnerability report.
     * 
     */
    @JsonProperty("reporter-id")
    public Object getReporterId() {
        return reporterId;
    }

    /**
     * Reporter
     * <p>
     * Reporter of this vulnerability report.
     * 
     */
    @JsonProperty("reporter-id")
    public void setReporterId(Object reporterId) {
        this.reporterId = reporterId;
    }

    /**
     * Vulnlog Vulnerability Report Suppression Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("suppression")
    public List<VulnerabilitiesReportsSuppressionVulnlogSchema> getSuppression() {
        return suppression;
    }

    /**
     * Vulnlog Vulnerability Report Suppression Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("suppression")
    public void setSuppression(List<VulnerabilitiesReportsSuppressionVulnlogSchema> suppression) {
        this.suppression = suppression;
    }

    /**
     * Vulnerability ID
     * <p>
     * Identifier of the vulnerability. Can be a CVE or a Snyk ID.
     * 
     */
    @JsonProperty("vuln-id")
    public Object getVulnId() {
        return vulnId;
    }

    /**
     * Vulnerability ID
     * <p>
     * Identifier of the vulnerability. Can be a CVE or a Snyk ID.
     * 
     */
    @JsonProperty("vuln-id")
    public void setVulnId(Object vulnId) {
        this.vulnId = vulnId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
