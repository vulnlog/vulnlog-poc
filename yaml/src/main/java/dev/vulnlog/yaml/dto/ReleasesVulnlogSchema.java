
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
     * TODO
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("TODO")
    private String id;
    /**
     * Release Name
     * <p>
     * TODO
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("TODO")
    private String name;
    /**
     * Release Date
     * <p>
     * TODO
     * 
     */
    @JsonProperty("release-date")
    @JsonPropertyDescription("TODO")
    private String releaseDate;
    /**
     * Release Version
     * <p>
     * TODO
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("TODO")
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
     *     Release Date. TODO.
     * @param name
     *     Release Name. TODO.
     * @param id
     *     Release Identifier. TODO.
     * @param version
     *     Release Version. TODO.
     */
    public ReleasesVulnlogSchema(String id, String name, String releaseDate, String version) {
        super();
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.version = version;
    }

    /**
     * Release Identifier
     * <p>
     * TODO
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Release Identifier
     * <p>
     * TODO
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Release Name
     * <p>
     * TODO
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Release Name
     * <p>
     * TODO
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Release Date
     * <p>
     * TODO
     * 
     */
    @JsonProperty("release-date")
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Release Date
     * <p>
     * TODO
     * 
     */
    @JsonProperty("release-date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Release Version
     * <p>
     * TODO
     * 
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Release Version
     * <p>
     * TODO
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
