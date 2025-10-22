
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
 * Vulnlog Vulnerability Resolutions Remove Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "note",
    "on"
})
public class VulnerabilitiesResolutionsRemoveVulnlogSchema {

    /**
     * Note
     * <p>
     * TODO
     * 
     */
    @JsonProperty("note")
    @JsonPropertyDescription("TODO")
    private String note;
    /**
     * Remove on Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on")
    @JsonPropertyDescription("TODO")
    private String on;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesResolutionsRemoveVulnlogSchema() {
    }

    /**
     * 
     * @param note
     *     Note. TODO.
     * @param on
     *     Remove on Release. TODO.
     */
    public VulnerabilitiesResolutionsRemoveVulnlogSchema(String note, String on) {
        super();
        this.note = note;
        this.on = on;
    }

    /**
     * Note
     * <p>
     * TODO
     * 
     */
    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    /**
     * Note
     * <p>
     * TODO
     * 
     */
    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Remove on Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on")
    public String getOn() {
        return on;
    }

    /**
     * Remove on Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on")
    public void setOn(String on) {
        this.on = on;
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
