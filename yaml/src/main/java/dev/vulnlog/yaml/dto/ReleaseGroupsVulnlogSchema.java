
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "ref-ids"
})
public class ReleaseGroupsVulnlogSchema {

    /**
     * Release Group Identifier
     * <p>
     * Identifier of the Release Group. A release group contains multiple releases under a single name. This allows filtering by release group.
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Identifier of the Release Group. A release group contains multiple releases under a single name. This allows filtering by release group.")
    private String id;
    /**
     * Name of the Release Group
     * <p>
     * Name of the release group.
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name of the release group.")
    private String name;
    /**
     * Release Identifier
     * <p>
     * Release identifiers that belong to this release group.
     * 
     */
    @JsonProperty("ref-ids")
    @JsonPropertyDescription("Release identifiers that belong to this release group.")
    private List<String> refIds = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReleaseGroupsVulnlogSchema() {
    }

    /**
     * 
     * @param refIds
     *     Release Identifier. Release identifiers that belong to this release group.
     * @param name
     *     Name of the Release Group. Name of the release group.
     * @param id
     *     Release Group Identifier. Identifier of the Release Group. A release group contains multiple releases under a single name. This allows filtering by release group.
     */
    public ReleaseGroupsVulnlogSchema(String id, String name, List<String> refIds) {
        super();
        this.id = id;
        this.name = name;
        this.refIds = refIds;
    }

    /**
     * Release Group Identifier
     * <p>
     * Identifier of the Release Group. A release group contains multiple releases under a single name. This allows filtering by release group.
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Release Group Identifier
     * <p>
     * Identifier of the Release Group. A release group contains multiple releases under a single name. This allows filtering by release group.
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Name of the Release Group
     * <p>
     * Name of the release group.
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the Release Group
     * <p>
     * Name of the release group.
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Release Identifier
     * <p>
     * Release identifiers that belong to this release group.
     * 
     */
    @JsonProperty("ref-ids")
    public List<String> getRefIds() {
        return refIds;
    }

    /**
     * Release Identifier
     * <p>
     * Release identifiers that belong to this release group.
     * 
     */
    @JsonProperty("ref-ids")
    public void setRefIds(List<String> refIds) {
        this.refIds = refIds;
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
