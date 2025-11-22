
package dev.vulnlog.yaml.dto;

import java.time.LocalDate;
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
    "at",
    "on-id",
    "reasoning",
    "verdict"
})
public class VulnerabilitiesAnalysisVulnlogSchema {

    /**
     * Analysis Date
     * <p>
     * Date when this vulnerability report was analyzed. When left empty, the date of the first report is used implicitly. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("at")
    @JsonPropertyDescription("Date when this vulnerability report was analyzed. When left empty, the date of the first report is used implicitly. Format: YYYY-MM-DD")
    private LocalDate at;
    /**
     * Vulnlog On Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("on-id")
    private Object onId;
    /**
     * Reasoning
     * <p>
     * Description of the reasoning behind this analysis.
     * 
     */
    @JsonProperty("reasoning")
    @JsonPropertyDescription("Description of the reasoning behind this analysis.")
    private String reasoning;
    /**
     * Vulnlog Vulnerability Analysis Verdict Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("verdict")
    private VulnerabilitiesAnalysisVerdictVulnlogSchema verdict;
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
     * @param reasoning
     *     Reasoning. Description of the reasoning behind this analysis.
     * @param verdict
     *     Verdict. Either affected or not affected.
     * @param onId
     *     Analysis for Release. This analysis applies for these releases. If left empty, the analysis applies for all releases.
     */
    public VulnerabilitiesAnalysisVulnlogSchema(LocalDate at, Object onId, String reasoning, VulnerabilitiesAnalysisVerdictVulnlogSchema verdict) {
        super();
        this.at = at;
        this.onId = onId;
        this.reasoning = reasoning;
        this.verdict = verdict;
    }

    /**
     * Analysis Date
     * <p>
     * Date when this vulnerability report was analyzed. When left empty, the date of the first report is used implicitly. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("at")
    public LocalDate getAt() {
        return at;
    }

    /**
     * Analysis Date
     * <p>
     * Date when this vulnerability report was analyzed. When left empty, the date of the first report is used implicitly. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("at")
    public void setAt(LocalDate at) {
        this.at = at;
    }

    /**
     * Vulnlog On Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("on-id")
    public Object getOnId() {
        return onId;
    }

    /**
     * Vulnlog On Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("on-id")
    public void setOnId(Object onId) {
        this.onId = onId;
    }

    /**
     * Reasoning
     * <p>
     * Description of the reasoning behind this analysis.
     * 
     */
    @JsonProperty("reasoning")
    public String getReasoning() {
        return reasoning;
    }

    /**
     * Reasoning
     * <p>
     * Description of the reasoning behind this analysis.
     * 
     */
    @JsonProperty("reasoning")
    public void setReasoning(String reasoning) {
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
