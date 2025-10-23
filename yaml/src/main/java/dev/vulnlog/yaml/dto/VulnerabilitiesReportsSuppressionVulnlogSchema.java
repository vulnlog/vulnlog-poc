
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
    "on",
    "until"
})
public class VulnerabilitiesReportsSuppressionVulnlogSchema {

    /**
     * Suppress on Releases
     * <p>
     * Releases on which this suppression should be applied.
     * 
     */
    @JsonProperty("on")
    @JsonPropertyDescription("Releases on which this suppression should be applied.")
    private Object on;
    /**
     * Suppress Until
     * <p>
     * Date until this suppression should be active to. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("until")
    @JsonPropertyDescription("Date until this suppression should be active to. Format: YYYY-MM-DD")
    private String until;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesReportsSuppressionVulnlogSchema() {
    }

    /**
     * 
     * @param until
     *     Suppress Until. Date until this suppression should be active to. Format: YYYY-MM-DD.
     * @param on
     *     Suppress on Releases. Releases on which this suppression should be applied.
     */
    public VulnerabilitiesReportsSuppressionVulnlogSchema(Object on, String until) {
        super();
        this.on = on;
        this.until = until;
    }

    /**
     * Suppress on Releases
     * <p>
     * Releases on which this suppression should be applied.
     * 
     */
    @JsonProperty("on")
    public Object getOn() {
        return on;
    }

    /**
     * Suppress on Releases
     * <p>
     * Releases on which this suppression should be applied.
     * 
     */
    @JsonProperty("on")
    public void setOn(Object on) {
        this.on = on;
    }

    /**
     * Suppress Until
     * <p>
     * Date until this suppression should be active to. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("until")
    public String getUntil() {
        return until;
    }

    /**
     * Suppress Until
     * <p>
     * Date until this suppression should be active to. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("until")
    public void setUntil(String until) {
        this.until = until;
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
