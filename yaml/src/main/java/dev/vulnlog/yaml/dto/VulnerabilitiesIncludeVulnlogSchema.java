
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
 * Vulnlog Vulnerability Include Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "releases",
    "reporters"
})
public class VulnerabilitiesIncludeVulnlogSchema {

    /**
     * Include Releases
     * <p>
     * TODO
     * 
     */
    @JsonProperty("releases")
    @JsonPropertyDescription("TODO")
    private Releases releases;
    /**
     * Include Reporters
     * <p>
     * TODO
     * 
     */
    @JsonProperty("reporters")
    @JsonPropertyDescription("TODO")
    private Reporters reporters;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesIncludeVulnlogSchema() {
    }

    /**
     * 
     * @param reporters
     *     Include Reporters. TODO.
     * @param releases
     *     Include Releases. TODO.
     */
    public VulnerabilitiesIncludeVulnlogSchema(Releases releases, Reporters reporters) {
        super();
        this.releases = releases;
        this.reporters = reporters;
    }

    /**
     * Include Releases
     * <p>
     * TODO
     * 
     */
    @JsonProperty("releases")
    public Releases getReleases() {
        return releases;
    }

    /**
     * Include Releases
     * <p>
     * TODO
     * 
     */
    @JsonProperty("releases")
    public void setReleases(Releases releases) {
        this.releases = releases;
    }

    /**
     * Include Reporters
     * <p>
     * TODO
     * 
     */
    @JsonProperty("reporters")
    public Reporters getReporters() {
        return reporters;
    }

    /**
     * Include Reporters
     * <p>
     * TODO
     * 
     */
    @JsonProperty("reporters")
    public void setReporters(Reporters reporters) {
        this.reporters = reporters;
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
