
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
 * Vulnlog Vulnerability Resolutions Accept Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "note",
    "on-id"
})
public class VulnerabilitiesResolutionsAcceptVulnlogSchema {

    /**
     * Note on this Resolution
     * <p>
     * Gives additional insight why this resolution was chosen.
     * 
     */
    @JsonProperty("note")
    @JsonPropertyDescription("Gives additional insight why this resolution was chosen.")
    private String note;
    /**
     * Vulnlog On Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("on-id")
    private Object onId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesResolutionsAcceptVulnlogSchema() {
    }

    /**
     * 
     * @param note
     *     Note on this Resolution. Gives additional insight why this resolution was chosen.
     * @param onId
     *     Accept on Release. Accept the potential risk of the vulnerability on the given release.
     */
    public VulnerabilitiesResolutionsAcceptVulnlogSchema(String note, Object onId) {
        super();
        this.note = note;
        this.onId = onId;
    }

    /**
     * Note on this Resolution
     * <p>
     * Gives additional insight why this resolution was chosen.
     * 
     */
    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    /**
     * Note on this Resolution
     * <p>
     * Gives additional insight why this resolution was chosen.
     * 
     */
    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
