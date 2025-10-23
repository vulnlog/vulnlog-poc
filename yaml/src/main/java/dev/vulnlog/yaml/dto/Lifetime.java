
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


/**
 * Pipeline Lifetime
 * <p>
 * From when until when this pipeline is active.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "end",
    "start"
})
public class Lifetime {

    /**
     * End date of this pipeline
     * <p>
     * Date when this pipeline is no longer active. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("end")
    @JsonPropertyDescription("Date when this pipeline is no longer active. Format: YYYY-MM-DD")
    private String end;
    /**
     * Start date of this pipeline
     * <p>
     * Date from when this pipeline is active. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("start")
    @JsonPropertyDescription("Date from when this pipeline is active. Format: YYYY-MM-DD")
    private String start;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Lifetime() {
    }

    /**
     * 
     * @param start
     *     Start date of this pipeline. Date from when this pipeline is active. Format: YYYY-MM-DD.
     * @param end
     *     End date of this pipeline. Date when this pipeline is no longer active. Format: YYYY-MM-DD.
     */
    public Lifetime(String end, String start) {
        super();
        this.end = end;
        this.start = start;
    }

    /**
     * End date of this pipeline
     * <p>
     * Date when this pipeline is no longer active. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("end")
    public String getEnd() {
        return end;
    }

    /**
     * End date of this pipeline
     * <p>
     * Date when this pipeline is no longer active. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("end")
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Start date of this pipeline
     * <p>
     * Date from when this pipeline is active. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    /**
     * Start date of this pipeline
     * <p>
     * Date from when this pipeline is active. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
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
