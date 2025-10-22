
package dev.vulnlog.yaml.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accept",
    "fix",
    "rebuild",
    "remove",
    "update"
})
public class VulnerabilitiesResolutionsVulnlogSchema {

    /**
     * Vulnlog Vulnerability Resolutions Accept Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("accept")
    private VulnerabilitiesResolutionsAcceptVulnlogSchema accept;
    /**
     * Vulnlog Vulnerability Resolutions Fxi Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("fix")
    private VulnerabilitiesResolutionsFixVulnlogSchema fix;
    /**
     * Vulnlog Vulnerability Resolutions Rebuild Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("rebuild")
    private VulnerabilitiesResolutionsRebuildVulnlogSchema rebuild;
    /**
     * Vulnlog Vulnerability Resolutions Accept Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("remove")
    private VulnerabilitiesResolutionsAcceptVulnlogSchema remove;
    /**
     * Vulnlog Vulnerability Resolutions Update Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("update")
    private VulnerabilitiesResolutionsUpdateVulnlogSchema update;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesResolutionsVulnlogSchema() {
    }

    /**
     * 
     * @param rebuild
     *     Rebuild. Rebuild a product component.
     * @param fix
     *     Fix. Fix code parts in the project.
     * @param update
     *     Update. Update a dependency to a specific version.
     * @param remove
     *     Remove. Remove a dependency or functionality.
     * @param accept
     *     Accept. Accept a vulnerability.
     */
    public VulnerabilitiesResolutionsVulnlogSchema(VulnerabilitiesResolutionsAcceptVulnlogSchema accept, VulnerabilitiesResolutionsFixVulnlogSchema fix, VulnerabilitiesResolutionsRebuildVulnlogSchema rebuild, VulnerabilitiesResolutionsAcceptVulnlogSchema remove, VulnerabilitiesResolutionsUpdateVulnlogSchema update) {
        super();
        this.accept = accept;
        this.fix = fix;
        this.rebuild = rebuild;
        this.remove = remove;
        this.update = update;
    }

    /**
     * Vulnlog Vulnerability Resolutions Accept Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("accept")
    public VulnerabilitiesResolutionsAcceptVulnlogSchema getAccept() {
        return accept;
    }

    /**
     * Vulnlog Vulnerability Resolutions Accept Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("accept")
    public void setAccept(VulnerabilitiesResolutionsAcceptVulnlogSchema accept) {
        this.accept = accept;
    }

    /**
     * Vulnlog Vulnerability Resolutions Fxi Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("fix")
    public VulnerabilitiesResolutionsFixVulnlogSchema getFix() {
        return fix;
    }

    /**
     * Vulnlog Vulnerability Resolutions Fxi Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("fix")
    public void setFix(VulnerabilitiesResolutionsFixVulnlogSchema fix) {
        this.fix = fix;
    }

    /**
     * Vulnlog Vulnerability Resolutions Rebuild Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("rebuild")
    public VulnerabilitiesResolutionsRebuildVulnlogSchema getRebuild() {
        return rebuild;
    }

    /**
     * Vulnlog Vulnerability Resolutions Rebuild Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("rebuild")
    public void setRebuild(VulnerabilitiesResolutionsRebuildVulnlogSchema rebuild) {
        this.rebuild = rebuild;
    }

    /**
     * Vulnlog Vulnerability Resolutions Accept Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("remove")
    public VulnerabilitiesResolutionsAcceptVulnlogSchema getRemove() {
        return remove;
    }

    /**
     * Vulnlog Vulnerability Resolutions Accept Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("remove")
    public void setRemove(VulnerabilitiesResolutionsAcceptVulnlogSchema remove) {
        this.remove = remove;
    }

    /**
     * Vulnlog Vulnerability Resolutions Update Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("update")
    public VulnerabilitiesResolutionsUpdateVulnlogSchema getUpdate() {
        return update;
    }

    /**
     * Vulnlog Vulnerability Resolutions Update Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("update")
    public void setUpdate(VulnerabilitiesResolutionsUpdateVulnlogSchema update) {
        this.update = update;
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
