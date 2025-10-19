
package dev.vulnlog.yaml.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Vulnlog Vulnerability Analysis Verdict Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "not-affected",
    "affected"
})
public class VulnerabilitiesAnalysisVerdictVulnlogSchema {

    /**
     * Vulnlog Vulnerability Analysis Verdict Not Affected Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("not-affected")
    private VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema notAffected;
    /**
     * Vulnlog Vulnerability Analysis Verdict Affected Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("affected")
    private VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema affected;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesAnalysisVerdictVulnlogSchema() {
    }

    /**
     * 
     * @param notAffected
     *     Not Affected. TODO.
     * @param affected
     *     Affected. TODO.
     */
    public VulnerabilitiesAnalysisVerdictVulnlogSchema(VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema notAffected, VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema affected) {
        super();
        this.notAffected = notAffected;
        this.affected = affected;
    }

    /**
     * Vulnlog Vulnerability Analysis Verdict Not Affected Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("not-affected")
    public VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema getNotAffected() {
        return notAffected;
    }

    /**
     * Vulnlog Vulnerability Analysis Verdict Not Affected Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("not-affected")
    public void setNotAffected(VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema notAffected) {
        this.notAffected = notAffected;
    }

    /**
     * Vulnlog Vulnerability Analysis Verdict Affected Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("affected")
    public VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema getAffected() {
        return affected;
    }

    /**
     * Vulnlog Vulnerability Analysis Verdict Affected Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("affected")
    public void setAffected(VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema affected) {
        this.affected = affected;
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
