
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
 * Vulnlog Vulnerability Resolutions Update Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "container-dependency",
    "dependency",
    "maven-dependency",
    "note",
    "npm-dependency",
    "on-id",
    "resolved-at",
    "to"
})
public class VulnerabilitiesResolutionsUpdateVulnlogSchema {

    /**
     * Container Dependency
     * <p>
     * The maven dependency in the form of groupId:artifactId:version that should be updated.
     * 
     */
    @JsonProperty("container-dependency")
    @JsonPropertyDescription("The maven dependency in the form of groupId:artifactId:version that should be updated.")
    private String containerDependency;
    /**
     * Generic Dependency
     * <p>
     * Define a generic dependency what should be updated. Use this, if the more specific options such as Maven or NPM are not applicable.
     * 
     */
    @JsonProperty("dependency")
    @JsonPropertyDescription("Define a generic dependency what should be updated. Use this, if the more specific options such as Maven or NPM are not applicable.")
    private String dependency;
    /**
     * Maven Dependency
     * <p>
     * The maven dependency in the form of groupId:artifactId:version that should be updated.
     * 
     */
    @JsonProperty("maven-dependency")
    @JsonPropertyDescription("The maven dependency in the form of groupId:artifactId:version that should be updated.")
    private String mavenDependency;
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
     * NPM Dependency
     * <p>
     * The NPM dependency in the form of name@version that should be updated.
     * 
     */
    @JsonProperty("npm-dependency")
    @JsonPropertyDescription("The NPM dependency in the form of name@version that should be updated.")
    private String npmDependency;
    /**
     * Vulnlog On Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("on-id")
    private Object onId;
    /**
     * Resolved at Date
     * <p>
     * The date on which this resolution is applied. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("resolved-at")
    @JsonPropertyDescription("The date on which this resolution is applied. Format: YYYY-MM-DD")
    private LocalDate resolvedAt;
    /**
     * To Version
     * <p>
     * The version to which the dependency should be updated.
     * 
     */
    @JsonProperty("to")
    @JsonPropertyDescription("The version to which the dependency should be updated.")
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
     *     Maven Dependency. The maven dependency in the form of groupId:artifactId:version that should be updated.
     * @param note
     *     Note on this Resolution. Gives additional insight why this resolution was chosen.
     * @param npmDependency
     *     NPM Dependency. The NPM dependency in the form of name@version that should be updated.
     * @param resolvedAt
     *     Resolved at Date. The date on which this resolution is applied. Format: YYYY-MM-DD.
     * @param dependency
     *     Generic Dependency. Define a generic dependency what should be updated. Use this, if the more specific options such as Maven or NPM are not applicable.
     * @param to
     *     To Version. The version to which the dependency should be updated.
     * @param containerDependency
     *     Container Dependency. The maven dependency in the form of groupId:artifactId:version that should be updated.
     * @param onId
     *     Update on Release. The releases a dependency should be updated on.
     */
    public VulnerabilitiesResolutionsUpdateVulnlogSchema(String containerDependency, String dependency, String mavenDependency, String note, String npmDependency, Object onId, LocalDate resolvedAt, String to) {
        super();
        this.containerDependency = containerDependency;
        this.dependency = dependency;
        this.mavenDependency = mavenDependency;
        this.note = note;
        this.npmDependency = npmDependency;
        this.onId = onId;
        this.resolvedAt = resolvedAt;
        this.to = to;
    }

    /**
     * Container Dependency
     * <p>
     * The maven dependency in the form of groupId:artifactId:version that should be updated.
     * 
     */
    @JsonProperty("container-dependency")
    public String getContainerDependency() {
        return containerDependency;
    }

    /**
     * Container Dependency
     * <p>
     * The maven dependency in the form of groupId:artifactId:version that should be updated.
     * 
     */
    @JsonProperty("container-dependency")
    public void setContainerDependency(String containerDependency) {
        this.containerDependency = containerDependency;
    }

    /**
     * Generic Dependency
     * <p>
     * Define a generic dependency what should be updated. Use this, if the more specific options such as Maven or NPM are not applicable.
     * 
     */
    @JsonProperty("dependency")
    public String getDependency() {
        return dependency;
    }

    /**
     * Generic Dependency
     * <p>
     * Define a generic dependency what should be updated. Use this, if the more specific options such as Maven or NPM are not applicable.
     * 
     */
    @JsonProperty("dependency")
    public void setDependency(String dependency) {
        this.dependency = dependency;
    }

    /**
     * Maven Dependency
     * <p>
     * The maven dependency in the form of groupId:artifactId:version that should be updated.
     * 
     */
    @JsonProperty("maven-dependency")
    public String getMavenDependency() {
        return mavenDependency;
    }

    /**
     * Maven Dependency
     * <p>
     * The maven dependency in the form of groupId:artifactId:version that should be updated.
     * 
     */
    @JsonProperty("maven-dependency")
    public void setMavenDependency(String mavenDependency) {
        this.mavenDependency = mavenDependency;
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
     * NPM Dependency
     * <p>
     * The NPM dependency in the form of name@version that should be updated.
     * 
     */
    @JsonProperty("npm-dependency")
    public String getNpmDependency() {
        return npmDependency;
    }

    /**
     * NPM Dependency
     * <p>
     * The NPM dependency in the form of name@version that should be updated.
     * 
     */
    @JsonProperty("npm-dependency")
    public void setNpmDependency(String npmDependency) {
        this.npmDependency = npmDependency;
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

    /**
     * To Version
     * <p>
     * The version to which the dependency should be updated.
     * 
     */
    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    /**
     * To Version
     * <p>
     * The version to which the dependency should be updated.
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
