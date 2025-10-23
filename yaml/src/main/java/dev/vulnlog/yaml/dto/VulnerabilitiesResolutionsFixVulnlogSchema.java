
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
 * Vulnlog Vulnerability Resolutions Fxi Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "note",
    "on-id",
    "resolved-at"
})
public class VulnerabilitiesResolutionsFixVulnlogSchema {

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
     * Fix on Release
     * <p>
     * The releases on which this vulnerability should be fixed.
     * 
     */
    @JsonProperty("on-id")
    @JsonPropertyDescription("The releases on which this vulnerability should be fixed.")
    private Object onId;
    /**
     * Resolved at Date
     * <p>
     * The date on which this resolution is applied. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("resolved-at")
    @JsonPropertyDescription("The date on which this resolution is applied. Format: YYYY-MM-DD")
    private String resolvedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesResolutionsFixVulnlogSchema() {
    }

    /**
     * 
     * @param note
     *     Note on this Resolution. Gives additional insight why this resolution was chosen.
     * @param resolvedAt
     *     Resolved at Date. The date on which this resolution is applied. Format: YYYY-MM-DD.
     * @param onId
     *     Fix on Release. The releases on which this vulnerability should be fixed.
     */
    public VulnerabilitiesResolutionsFixVulnlogSchema(String note, Object onId, String resolvedAt) {
        super();
        this.note = note;
        this.onId = onId;
        this.resolvedAt = resolvedAt;
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
     * Fix on Release
     * <p>
     * The releases on which this vulnerability should be fixed.
     * 
     */
    @JsonProperty("on-id")
    public Object getOnId() {
        return onId;
    }

    /**
     * Fix on Release
     * <p>
     * The releases on which this vulnerability should be fixed.
     * 
     */
    @JsonProperty("on-id")
    public void setOnId(Object onId) {
        this.onId = onId;
    }

    /**
     * Resolved at Date
     * <p>
     * The date on which this resolution is applied. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("resolved-at")
    public String getResolvedAt() {
        return resolvedAt;
    }

    /**
     * Resolved at Date
     * <p>
     * The date on which this resolution is applied. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("resolved-at")
    public void setResolvedAt(String resolvedAt) {
        this.resolvedAt = resolvedAt;
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
