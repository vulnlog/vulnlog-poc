
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
     * TODO
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("TODO")
    private String id;
    /**
     * Name of the Release Group
     * <p>
     * TODO
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("TODO")
    private String name;
    /**
     * Release Identifier
     * <p>
     * TODO
     * 
     */
    @JsonProperty("ref-ids")
    @JsonPropertyDescription("TODO")
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
     *     Release Identifier. TODO.
     * @param name
     *     Name of the Release Group. TODO.
     * @param id
     *     Release Group Identifier. TODO.
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
     * TODO
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Release Group Identifier
     * <p>
     * TODO
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Name of the Release Group
     * <p>
     * TODO
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the Release Group
     * <p>
     * TODO
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Release Identifier
     * <p>
     * TODO
     * 
     */
    @JsonProperty("ref-ids")
    public List<String> getRefIds() {
        return refIds;
    }

    /**
     * Release Identifier
     * <p>
     * TODO
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
