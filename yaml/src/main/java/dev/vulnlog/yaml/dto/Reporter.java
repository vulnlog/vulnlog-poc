
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
    "reporter",
    "suppression"
})
public class Reporter {

    /**
     * Reporter
     * <p>
     * Reporter of this vulnerability report and suppression information.
     * 
     */
    @JsonProperty("reporter")
    @JsonPropertyDescription("Reporter of this vulnerability report and suppression information.")
    private Object reporter;
    @JsonProperty("suppression")
    private Object suppression;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Reporter() {
    }

    /**
     * 
     * @param reporter
     *     Reporter. Reporter of this vulnerability report and suppression information.
     */
    public Reporter(Object reporter, Object suppression) {
        super();
        this.reporter = reporter;
        this.suppression = suppression;
    }

    /**
     * Reporter
     * <p>
     * Reporter of this vulnerability report and suppression information.
     * 
     */
    @JsonProperty("reporter")
    public Object getReporter() {
        return reporter;
    }

    /**
     * Reporter
     * <p>
     * Reporter of this vulnerability report and suppression information.
     * 
     */
    @JsonProperty("reporter")
    public void setReporter(Object reporter) {
        this.reporter = reporter;
    }

    @JsonProperty("suppression")
    public Object getSuppression() {
        return suppression;
    }

    @JsonProperty("suppression")
    public void setSuppression(Object suppression) {
        this.suppression = suppression;
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
