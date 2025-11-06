
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
    "until",
    "paths"
})
public class VulnerabilitiesReportsSuppressionSnykVulnlogSchema {

    /**
     * Suppress Until
     * <p>
     * Date until this suppression should be active to. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("until")
    @JsonPropertyDescription("Date until this suppression should be active to. Format: YYYY-MM-DD")
    private String until;
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
     * @param until
     *     Suppress Until. Date until this suppression should be active to. Format: YYYY-MM-DD.
     */
    public VulnerabilitiesReportsSuppressionSnykVulnlogSchema(String until, List<String> paths) {
        super();
        this.until = until;
        this.paths = paths;
    }

    /**
     * Suppress Until
     * <p>
     * Date until this suppression should be active to. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("until")
    public String getUntil() {
        return until;
    }

    /**
     * Suppress Until
     * <p>
     * Date until this suppression should be active to. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("until")
    public void setUntil(String until) {
        this.until = until;
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
