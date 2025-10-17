
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
 * Include Releases
 * <p>
 * TODO
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "file",
    "ref-ids"
})
public class Releases {

    /**
     * File to include
     * <p>
     * TODO
     * 
     */
    @JsonProperty("file")
    @JsonPropertyDescription("TODO")
    private String file;
    /**
     * Release IDs to Reference from
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
    public Releases() {
    }

    /**
     * 
     * @param refIds
     *     Release IDs to Reference from. TODO.
     * @param file
     *     File to include. TODO.
     */
    public Releases(String file, List<String> refIds) {
        super();
        this.file = file;
        this.refIds = refIds;
    }

    /**
     * File to include
     * <p>
     * TODO
     * 
     */
    @JsonProperty("file")
    public String getFile() {
        return file;
    }

    /**
     * File to include
     * <p>
     * TODO
     * 
     */
    @JsonProperty("file")
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * Release IDs to Reference from
     * <p>
     * TODO
     * 
     */
    @JsonProperty("ref-ids")
    public List<String> getRefIds() {
        return refIds;
    }

    /**
     * Release IDs to Reference from
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
