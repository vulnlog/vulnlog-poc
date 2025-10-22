
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
 * Vulnlog Vulnerability Resolutions Update Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maven-dependency",
    "note",
    "on-id",
    "resolved-at",
    "to"
})
public class VulnerabilitiesResolutionsUpdateVulnlogSchema {

    /**
     * Maven Dependency
     * <p>
     * TODO
     * 
     */
    @JsonProperty("maven-dependency")
    @JsonPropertyDescription("TODO")
    private String mavenDependency;
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
     * Update on Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on-id")
    @JsonPropertyDescription("TODO")
    private Object onId;
    /**
     * Resolved at Date
     * <p>
     * TODO
     * 
     */
    @JsonProperty("resolved-at")
    @JsonPropertyDescription("TODO")
    private String resolvedAt;
    /**
     * To Version
     * <p>
     * TODO
     * 
     */
    @JsonProperty("to")
    @JsonPropertyDescription("TODO")
    private String to;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesResolutionsUpdateVulnlogSchema() {
    }

    /**
     * 
     * @param mavenDependency
     *     Maven Dependency. TODO.
     * @param note
     *     Note. TODO.
     * @param resolvedAt
     *     Resolved at Date. TODO.
     * @param to
     *     To Version. TODO.
     * @param onId
     *     Update on Release. TODO.
     */
    public VulnerabilitiesResolutionsUpdateVulnlogSchema(String mavenDependency, String note, Object onId, String resolvedAt, String to) {
        super();
        this.mavenDependency = mavenDependency;
        this.note = note;
        this.onId = onId;
        this.resolvedAt = resolvedAt;
        this.to = to;
    }

    /**
     * Maven Dependency
     * <p>
     * TODO
     * 
     */
    @JsonProperty("maven-dependency")
    public String getMavenDependency() {
        return mavenDependency;
    }

    /**
     * Maven Dependency
     * <p>
     * TODO
     * 
     */
    @JsonProperty("maven-dependency")
    public void setMavenDependency(String mavenDependency) {
        this.mavenDependency = mavenDependency;
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
     * Update on Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on-id")
    public Object getOnId() {
        return onId;
    }

    /**
     * Update on Release
     * <p>
     * TODO
     * 
     */
    @JsonProperty("on-id")
    public void setOnId(Object onId) {
        this.onId = onId;
    }

    /**
     * Resolved at Date
     * <p>
     * TODO
     * 
     */
    @JsonProperty("resolved-at")
    public String getResolvedAt() {
        return resolvedAt;
    }

    /**
     * Resolved at Date
     * <p>
     * TODO
     * 
     */
    @JsonProperty("resolved-at")
    public void setResolvedAt(String resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    /**
     * To Version
     * <p>
     * TODO
     * 
     */
    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    /**
     * To Version
     * <p>
     * TODO
     * 
     */
    @JsonProperty("to")
    public void setTo(String to) {
        this.to = to;
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
