
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
    "on",
    "suppression",
    "vuln-id"
})
public class VulnerabilitiesReportsVulnlogSchema {

    /**
     * Reported Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on")
    @JsonPropertyDescription("TODO")
    private Object on;
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
     * @param vulnId
     *     Vulnerability ID. TODO.
     * @param suppression
     *     Suppress this Report. TODO.
     * @param on
     *     Reported Release. TODO.
     */
    public VulnerabilitiesReportsVulnlogSchema(Object on, List<VulnerabilitiesReportsSuppressionVulnlogSchema> suppression, Object vulnId) {
        super();
        this.on = on;
        this.suppression = suppression;
        this.vulnId = vulnId;
    }

    /**
     * Reported Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on")
    public Object getOn() {
        return on;
    }

    /**
     * Reported Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on")
    public void setOn(Object on) {
        this.on = on;
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
