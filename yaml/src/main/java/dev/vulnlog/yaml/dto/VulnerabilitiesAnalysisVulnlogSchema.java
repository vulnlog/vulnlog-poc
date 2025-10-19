
package dev.vulnlog.yaml.dto;

import java.util.LinkedHashMap;
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
    "verdict",
    "at",
    "reasoning"
})
public class VulnerabilitiesAnalysisVulnlogSchema {

    /**
     * Vulnlog Vulnerability Analysis Verdict Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("verdict")
    private VulnerabilitiesAnalysisVerdictVulnlogSchema verdict;
    /**
     * Analysis Date
     * <p>
     * Date when this vulnerability report was analyzed. When left empty, the date of the first report is used implicitly. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("at")
    @JsonPropertyDescription("Date when this vulnerability report was analyzed. When left empty, the date of the first report is used implicitly. Format: YYYY-MM-DD")
    private String at;
    /**
     * Reasoning
     * <p>
     * TODO
     * 
     */
    @JsonProperty("reasoning")
    @JsonPropertyDescription("TODO")
    private String reasoning;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesAnalysisVulnlogSchema() {
    }

    /**
     * 
     * @param at
     *     Analysis Date. Date when this vulnerability report was analyzed. When left empty, the date of the first report is used implicitly. Format: YYYY-MM-DD.
     * @param verdict
     *     Verdict. TODO.
     * @param reasoning
     *     Reasoning. TODO.
     */
    public VulnerabilitiesAnalysisVulnlogSchema(VulnerabilitiesAnalysisVerdictVulnlogSchema verdict, String at, String reasoning) {
        super();
        this.verdict = verdict;
        this.at = at;
        this.reasoning = reasoning;
    }

    /**
     * Vulnlog Vulnerability Analysis Verdict Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("verdict")
    public VulnerabilitiesAnalysisVerdictVulnlogSchema getVerdict() {
        return verdict;
    }

    /**
     * Vulnlog Vulnerability Analysis Verdict Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("verdict")
    public void setVerdict(VulnerabilitiesAnalysisVerdictVulnlogSchema verdict) {
        this.verdict = verdict;
    }

    /**
     * Analysis Date
     * <p>
     * Date when this vulnerability report was analyzed. When left empty, the date of the first report is used implicitly. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("at")
    public String getAt() {
        return at;
    }

    /**
     * Analysis Date
     * <p>
     * Date when this vulnerability report was analyzed. When left empty, the date of the first report is used implicitly. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("at")
    public void setAt(String at) {
        this.at = at;
    }

    /**
     * Reasoning
     * <p>
     * TODO
     * 
     */
    @JsonProperty("reasoning")
    public String getReasoning() {
        return reasoning;
    }

    /**
     * Reasoning
     * <p>
     * TODO
     * 
     */
    @JsonProperty("reasoning")
    public void setReasoning(String reasoning) {
        this.reasoning = reasoning;
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
