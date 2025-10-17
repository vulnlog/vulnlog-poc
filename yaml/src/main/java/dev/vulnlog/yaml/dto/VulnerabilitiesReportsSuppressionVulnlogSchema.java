
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
     * TODO
     * 
     */
    @JsonProperty("on")
    @JsonPropertyDescription("TODO")
    private Object on;
    /**
     * Suppress Until
     * <p>
     * TODO
     * 
     */
    @JsonProperty("until")
    @JsonPropertyDescription("TODO")
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
     *     Suppress Until. TODO.
     * @param on
     *     Suppress on Releases. TODO.
     */
    public VulnerabilitiesReportsSuppressionVulnlogSchema(Object on, String until) {
        super();
        this.on = on;
        this.until = until;
    }

    /**
     * Suppress on Releases
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on")
    public Object getOn() {
        return on;
    }

    /**
     * Suppress on Releases
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on")
    public void setOn(Object on) {
        this.on = on;
    }

    /**
     * Suppress Until
     * <p>
     * TODO
     * 
     */
    @JsonProperty("until")
    public String getUntil() {
        return until;
    }

    /**
     * Suppress Until
     * <p>
     * TODO
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
