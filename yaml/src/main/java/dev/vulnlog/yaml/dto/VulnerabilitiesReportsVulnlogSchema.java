
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
     * TODO
     * 
     */
    @JsonProperty("at")
    @JsonPropertyDescription("TODO")
    private String at;
    /**
     * Reported Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on-id")
    @JsonPropertyDescription("TODO")
    private Object onId;
    /**
     * Reporter
     * <p>
     * TODO
     * 
     */
    @JsonProperty("reporter-id")
    @JsonPropertyDescription("TODO")
    private String reporterId;
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
     * TODO
     * 
     */
    @JsonProperty("vuln-id")
    @JsonPropertyDescription("TODO")
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
     *     Reported at Date. TODO.
     * @param vulnId
     *     Vulnerability ID. TODO.
     * @param suppression
     *     Suppress this Report. TODO.
     * @param reporterId
     *     Reporter. TODO.
     * @param onId
     *     Reported Release. TODO.
     */
    public VulnerabilitiesReportsVulnlogSchema(String at, Object onId, String reporterId, List<VulnerabilitiesReportsSuppressionVulnlogSchema> suppression, Object vulnId) {
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
     * TODO
     * 
     */
    @JsonProperty("at")
    public String getAt() {
        return at;
    }

    /**
     * Reported at Date
     * <p>
     * TODO
     * 
     */
    @JsonProperty("at")
    public void setAt(String at) {
        this.at = at;
    }

    /**
     * Reported Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on-id")
    public Object getOnId() {
        return onId;
    }

    /**
     * Reported Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on-id")
    public void setOnId(Object onId) {
        this.onId = onId;
    }

    /**
     * Reporter
     * <p>
     * TODO
     * 
     */
    @JsonProperty("reporter-id")
    public String getReporterId() {
        return reporterId;
    }

    /**
     * Reporter
     * <p>
     * TODO
     * 
     */
    @JsonProperty("reporter-id")
    public void setReporterId(String reporterId) {
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
     * TODO
     * 
     */
    @JsonProperty("vuln-id")
    public Object getVulnId() {
        return vulnId;
    }

    /**
     * Vulnerability ID
     * <p>
     * TODO
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
