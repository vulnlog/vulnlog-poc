
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "release-date",
    "version"
})
public class ReleasesVulnlogSchema {

    /**
     * Release Identifier
     * <p>
     * Identifier of the release. Must be unique.
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Identifier of the release. Must be unique.")
    private String id;
    /**
     * Release Name
     * <p>
     * Printable name of the release.
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Printable name of the release.")
    private String name;
    /**
     * Release Date
     * <p>
     * Date of the release. Format: YYYY-MM-DD.
     * 
     */
    @JsonProperty("release-date")
    @JsonPropertyDescription("Date of the release. Format: YYYY-MM-DD.")
    private LocalDate releaseDate;
    /**
     * Release Version
     * <p>
     * Version of the release. For example in the semantic version format: X.Y.Z.
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("Version of the release. For example in the semantic version format: X.Y.Z.")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReleasesVulnlogSchema() {
    }

    /**
     * 
     * @param releaseDate
     *     Release Date. Date of the release. Format: YYYY-MM-DD.
     * @param name
     *     Release Name. Printable name of the release.
     * @param id
     *     Release Identifier. Identifier of the release. Must be unique.
     * @param version
     *     Release Version. Version of the release. For example in the semantic version format: X.Y.Z.
     */
    public ReleasesVulnlogSchema(String id, String name, LocalDate releaseDate, String version) {
        super();
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.version = version;
    }

    /**
     * Release Identifier
     * <p>
     * Identifier of the release. Must be unique.
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Release Identifier
     * <p>
     * Identifier of the release. Must be unique.
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Release Name
     * <p>
     * Printable name of the release.
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Release Name
     * <p>
     * Printable name of the release.
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Release Date
     * <p>
     * Date of the release. Format: YYYY-MM-DD.
     * 
     */
    @JsonProperty("release-date")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * Release Date
     * <p>
     * Date of the release. Format: YYYY-MM-DD.
     * 
     */
    @JsonProperty("release-date")
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Release Version
     * <p>
     * Version of the release. For example in the semantic version format: X.Y.Z.
     * 
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Release Version
     * <p>
     * Version of the release. For example in the semantic version format: X.Y.Z.
     * 
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
