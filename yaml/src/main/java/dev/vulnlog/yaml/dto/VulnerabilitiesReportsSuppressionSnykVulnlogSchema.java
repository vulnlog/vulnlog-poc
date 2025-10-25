
package dev.vulnlog.yaml.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Vulnlog Vulnerability Report Suppression Snyk Open Source Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "paths"
})
public class VulnerabilitiesReportsSuppressionSnykVulnlogSchema {

    /**
     * Paths
     * <p>
     * The suppression only applies to files matching these paths.
     * 
     */
    @JsonProperty("paths")
    @JsonPropertyDescription("The suppression only applies to files matching these paths.")
    private List<String> paths = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesReportsSuppressionSnykVulnlogSchema() {
    }

    /**
     * 
     * @param paths
     *     Paths. The suppression only applies to files matching these paths.
     */
    public VulnerabilitiesReportsSuppressionSnykVulnlogSchema(List<String> paths) {
        super();
        this.paths = paths;
    }

    /**
     * Paths
     * <p>
     * The suppression only applies to files matching these paths.
     * 
     */
    @JsonProperty("paths")
    public List<String> getPaths() {
        return paths;
    }

    /**
     * Paths
     * <p>
     * The suppression only applies to files matching these paths.
     * 
     */
    @JsonProperty("paths")
    public void setPaths(List<String> paths) {
        this.paths = paths;
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
