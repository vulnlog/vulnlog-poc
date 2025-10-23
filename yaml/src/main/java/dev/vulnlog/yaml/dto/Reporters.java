
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
 * Include Reporters
 * <p>
 * When reporters are defined in another file, they can be included here.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "file",
    "pipeline-ref-ids",
    "reporter-ref-ids"
})
public class Reporters {

    /**
     * File to include
     * <p>
     * File containing the reporter to be included.
     * 
     */
    @JsonProperty("file")
    @JsonPropertyDescription("File containing the reporter to be included.")
    private String file;
    /**
     * Reporter Pipeline References
     * <p>
     * Create a list of references to the reporter pipelines ids defined in the included file. This is useful to create local YAML anchors.
     * 
     */
    @JsonProperty("pipeline-ref-ids")
    @JsonPropertyDescription("Create a list of references to the reporter pipelines ids defined in the included file. This is useful to create local YAML anchors.")
    private List<String> pipelineRefIds = new ArrayList<String>();
    /**
     * Reporter References
     * <p>
     * Create a list of references to the reporter ids defined in the included file. This is useful to create local YAML anchors.
     * 
     */
    @JsonProperty("reporter-ref-ids")
    @JsonPropertyDescription("Create a list of references to the reporter ids defined in the included file. This is useful to create local YAML anchors.")
    private List<String> reporterRefIds = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Reporters() {
    }

    /**
     * 
     * @param reporterRefIds
     *     Reporter References. Create a list of references to the reporter ids defined in the included file. This is useful to create local YAML anchors.
     * @param file
     *     File to include. File containing the reporter to be included.
     * @param pipelineRefIds
     *     Reporter Pipeline References. Create a list of references to the reporter pipelines ids defined in the included file. This is useful to create local YAML anchors.
     */
    public Reporters(String file, List<String> pipelineRefIds, List<String> reporterRefIds) {
        super();
        this.file = file;
        this.pipelineRefIds = pipelineRefIds;
        this.reporterRefIds = reporterRefIds;
    }

    /**
     * File to include
     * <p>
     * File containing the reporter to be included.
     * 
     */
    @JsonProperty("file")
    public String getFile() {
        return file;
    }

    /**
     * File to include
     * <p>
     * File containing the reporter to be included.
     * 
     */
    @JsonProperty("file")
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * Reporter Pipeline References
     * <p>
     * Create a list of references to the reporter pipelines ids defined in the included file. This is useful to create local YAML anchors.
     * 
     */
    @JsonProperty("pipeline-ref-ids")
    public List<String> getPipelineRefIds() {
        return pipelineRefIds;
    }

    /**
     * Reporter Pipeline References
     * <p>
     * Create a list of references to the reporter pipelines ids defined in the included file. This is useful to create local YAML anchors.
     * 
     */
    @JsonProperty("pipeline-ref-ids")
    public void setPipelineRefIds(List<String> pipelineRefIds) {
        this.pipelineRefIds = pipelineRefIds;
    }

    /**
     * Reporter References
     * <p>
     * Create a list of references to the reporter ids defined in the included file. This is useful to create local YAML anchors.
     * 
     */
    @JsonProperty("reporter-ref-ids")
    public List<String> getReporterRefIds() {
        return reporterRefIds;
    }

    /**
     * Reporter References
     * <p>
     * Create a list of references to the reporter ids defined in the included file. This is useful to create local YAML anchors.
     * 
     */
    @JsonProperty("reporter-ref-ids")
    public void setReporterRefIds(List<String> reporterRefIds) {
        this.reporterRefIds = reporterRefIds;
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
