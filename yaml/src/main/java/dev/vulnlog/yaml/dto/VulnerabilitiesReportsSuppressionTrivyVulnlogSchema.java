
package dev.vulnlog.yaml.dto;

import java.time.LocalDate;
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
    "purls",
    "until"
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
    /**
     * Suppress Until
     * <p>
     * Date until this suppression should be active to. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("until")
    @JsonPropertyDescription("Date until this suppression should be active to. Format: YYYY-MM-DD")
    private LocalDate until;
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
     * @param until
     *     Suppress Until. Date until this suppression should be active to. Format: YYYY-MM-DD.
     */
    public VulnerabilitiesReportsSuppressionTrivyVulnlogSchema(List<String> paths, List<String> purls, LocalDate until) {
        super();
        this.paths = paths;
        this.purls = purls;
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

    /**
     * Suppress Until
     * <p>
     * Date until this suppression should be active to. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("until")
    public LocalDate getUntil() {
        return until;
    }

    /**
     * Suppress Until
     * <p>
     * Date until this suppression should be active to. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("until")
    public void setUntil(LocalDate until) {
        this.until = until;
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
