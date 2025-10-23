
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
 * When releases are defined in another file, they can be included here.
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
     * File containing the releases to be included.
     * 
     */
    @JsonProperty("file")
    @JsonPropertyDescription("File containing the releases to be included.")
    private String file;
    /**
     * Release IDs to Reference from
     * <p>
     * Create a list of references to the release ids defined in the included file. This is useful to create local YAML anchors.
     * 
     */
    @JsonProperty("ref-ids")
    @JsonPropertyDescription("Create a list of references to the release ids defined in the included file. This is useful to create local YAML anchors.")
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
     *     Release IDs to Reference from. Create a list of references to the release ids defined in the included file. This is useful to create local YAML anchors.
     * @param file
     *     File to include. File containing the releases to be included.
     */
    public Releases(String file, List<String> refIds) {
        super();
        this.file = file;
        this.refIds = refIds;
    }

    /**
     * File to include
     * <p>
     * File containing the releases to be included.
     * 
     */
    @JsonProperty("file")
    public String getFile() {
        return file;
    }

    /**
     * File to include
     * <p>
     * File containing the releases to be included.
     * 
     */
    @JsonProperty("file")
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * Release IDs to Reference from
     * <p>
     * Create a list of references to the release ids defined in the included file. This is useful to create local YAML anchors.
     * 
     */
    @JsonProperty("ref-ids")
    public List<String> getRefIds() {
        return refIds;
    }

    /**
     * Release IDs to Reference from
     * <p>
     * Create a list of references to the release ids defined in the included file. This is useful to create local YAML anchors.
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
