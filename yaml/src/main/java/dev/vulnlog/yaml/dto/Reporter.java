
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
    "reporter12",
    "suppression"
})
public class Reporter {

    /**
     * My Reporter 12
     * <p>
     * Lorem ipsum dolor sit amet, consectetur adipiscing elit.
     * 
     */
    @JsonProperty("reporter12")
    @JsonPropertyDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
    private Object reporter12;
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
     * @param reporter12
     *     My Reporter 12. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
     */
    public Reporter(Object reporter12, Object suppression) {
        super();
        this.reporter12 = reporter12;
        this.suppression = suppression;
    }

    /**
     * My Reporter 12
     * <p>
     * Lorem ipsum dolor sit amet, consectetur adipiscing elit.
     * 
     */
    @JsonProperty("reporter12")
    public Object getReporter12() {
        return reporter12;
    }

    /**
     * My Reporter 12
     * <p>
     * Lorem ipsum dolor sit amet, consectetur adipiscing elit.
     * 
     */
    @JsonProperty("reporter12")
    public void setReporter12(Object reporter12) {
        this.reporter12 = reporter12;
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
