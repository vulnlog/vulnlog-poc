
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
 * Vulnlog Vulnerability Report Suppression Trivy Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "paths",
    "purls"
})
public class VulnerabilitiesReportsSuppressionTrivyVulnlogSchema {

    /**
     * Paths
     * <p>
     * The suppression only applies to files matching these paths.
     * 
     */
    @JsonProperty("paths")
    @JsonPropertyDescription("The suppression only applies to files matching these paths.")
    private List<String> paths = new ArrayList<String>();
    /**
     * Package URL
     * <p>
     * The suppression only applies to packages matching these PURLs.
     * 
     */
    @JsonProperty("purls")
    @JsonPropertyDescription("The suppression only applies to packages matching these PURLs.")
    private List<String> purls = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesReportsSuppressionTrivyVulnlogSchema() {
    }

    /**
     * 
     * @param purls
     *     Package URL. The suppression only applies to packages matching these PURLs.
     * @param paths
     *     Paths. The suppression only applies to files matching these paths.
     */
    public VulnerabilitiesReportsSuppressionTrivyVulnlogSchema(List<String> paths, List<String> purls) {
        super();
        this.paths = paths;
        this.purls = purls;
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

    /**
     * Package URL
     * <p>
     * The suppression only applies to packages matching these PURLs.
     * 
     */
    @JsonProperty("purls")
    public List<String> getPurls() {
        return purls;
    }

    /**
     * Package URL
     * <p>
     * The suppression only applies to packages matching these PURLs.
     * 
     */
    @JsonProperty("purls")
    public void setPurls(List<String> purls) {
        this.purls = purls;
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
