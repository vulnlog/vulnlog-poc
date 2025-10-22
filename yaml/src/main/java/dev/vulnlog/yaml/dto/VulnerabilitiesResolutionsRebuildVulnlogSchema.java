
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
 * Vulnlog Vulnerability Resolutions Rebuild Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "note",
    "on-id"
})
public class VulnerabilitiesResolutionsRebuildVulnlogSchema {

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
     * Rebuild on Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on-id")
    @JsonPropertyDescription("TODO")
    private Object onId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesResolutionsRebuildVulnlogSchema() {
    }

    /**
     * 
     * @param note
     *     Note. TODO.
     * @param onId
     *     Rebuild on Release. TODO.
     */
    public VulnerabilitiesResolutionsRebuildVulnlogSchema(String note, Object onId) {
        super();
        this.note = note;
        this.onId = onId;
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
     * Rebuild on Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on-id")
    public Object getOnId() {
        return onId;
    }

    /**
     * Rebuild on Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on-id")
    public void setOnId(Object onId) {
        this.onId = onId;
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
