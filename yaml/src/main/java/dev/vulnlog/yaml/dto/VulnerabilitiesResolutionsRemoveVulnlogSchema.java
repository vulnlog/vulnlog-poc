
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


/**
 * Vulnlog Vulnerability Resolutions Remove Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "note",
    "on",
    "resolved-at"
})
public class VulnerabilitiesResolutionsRemoveVulnlogSchema {

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
     * Remove on Release
     * <p>
     * The release on which a dependency should be removed.
     * 
     */
    @JsonProperty("on")
    @JsonPropertyDescription("The release on which a dependency should be removed.")
    private String on;
    /**
     * Resolved at Date
     * <p>
     * The date on which this resolution is applied. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("resolved-at")
    @JsonPropertyDescription("The date on which this resolution is applied. Format: YYYY-MM-DD")
    private LocalDate resolvedAt;
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
     *     Note on this Resolution. Gives additional insight why this resolution was chosen.
     * @param resolvedAt
     *     Resolved at Date. The date on which this resolution is applied. Format: YYYY-MM-DD.
     * @param on
     *     Remove on Release. The release on which a dependency should be removed.
     */
    public VulnerabilitiesResolutionsRemoveVulnlogSchema(String note, String on, LocalDate resolvedAt) {
        super();
        this.note = note;
        this.on = on;
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
     * Remove on Release
     * <p>
     * The release on which a dependency should be removed.
     * 
     */
    @JsonProperty("on")
    public String getOn() {
        return on;
    }

    /**
     * Remove on Release
     * <p>
     * The release on which a dependency should be removed.
     * 
     */
    @JsonProperty("on")
    public void setOn(String on) {
        this.on = on;
    }

    /**
     * Resolved at Date
     * <p>
     * The date on which this resolution is applied. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("resolved-at")
    public LocalDate getResolvedAt() {
        return resolvedAt;
    }

    /**
     * Resolved at Date
     * <p>
     * The date on which this resolution is applied. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("resolved-at")
    public void setResolvedAt(LocalDate resolvedAt) {
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
