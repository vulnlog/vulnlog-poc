
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
    "lifetime",
    "name",
    "reporter-ref-id"
})
public class ReporterPipelinesVulnlogSchema {

    /**
     * Reporter Pipeline Identifier
     * <p>
     * Identifier of this reporter pipeline. Must be unique.
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Identifier of this reporter pipeline. Must be unique.")
    private String id;
    /**
     * Pipeline Lifetime
     * <p>
     * From when until when this pipeline is active.
     * 
     */
    @JsonProperty("lifetime")
    @JsonPropertyDescription("From when until when this pipeline is active.")
    private Lifetime lifetime;
    /**
     * Reporter Pipeline Name
     * <p>
     * Name of this reporter pipeline.
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name of this reporter pipeline.")
    private String name;
    /**
     * Reporter
     * <p>
     * Reporter which is used by this pipeline. The reporter's unique identifier is required.
     * 
     */
    @JsonProperty("reporter-ref-id")
    @JsonPropertyDescription("Reporter which is used by this pipeline. The reporter's unique identifier is required.")
    private String reporterRefId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReporterPipelinesVulnlogSchema() {
    }

    /**
     * 
     * @param lifetime
     *     Pipeline Lifetime. From when until when this pipeline is active.
     * @param name
     *     Reporter Pipeline Name. Name of this reporter pipeline.
     * @param reporterRefId
     *     Reporter. Reporter which is used by this pipeline. The reporter's unique identifier is required.
     * @param id
     *     Reporter Pipeline Identifier. Identifier of this reporter pipeline. Must be unique.
     */
    public ReporterPipelinesVulnlogSchema(String id, Lifetime lifetime, String name, String reporterRefId) {
        super();
        this.id = id;
        this.lifetime = lifetime;
        this.name = name;
        this.reporterRefId = reporterRefId;
    }

    /**
     * Reporter Pipeline Identifier
     * <p>
     * Identifier of this reporter pipeline. Must be unique.
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Reporter Pipeline Identifier
     * <p>
     * Identifier of this reporter pipeline. Must be unique.
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Pipeline Lifetime
     * <p>
     * From when until when this pipeline is active.
     * 
     */
    @JsonProperty("lifetime")
    public Lifetime getLifetime() {
        return lifetime;
    }

    /**
     * Pipeline Lifetime
     * <p>
     * From when until when this pipeline is active.
     * 
     */
    @JsonProperty("lifetime")
    public void setLifetime(Lifetime lifetime) {
        this.lifetime = lifetime;
    }

    /**
     * Reporter Pipeline Name
     * <p>
     * Name of this reporter pipeline.
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Reporter Pipeline Name
     * <p>
     * Name of this reporter pipeline.
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Reporter
     * <p>
     * Reporter which is used by this pipeline. The reporter's unique identifier is required.
     * 
     */
    @JsonProperty("reporter-ref-id")
    public String getReporterRefId() {
        return reporterRefId;
    }

    /**
     * Reporter
     * <p>
     * Reporter which is used by this pipeline. The reporter's unique identifier is required.
     * 
     */
    @JsonProperty("reporter-ref-id")
    public void setReporterRefId(String reporterRefId) {
        this.reporterRefId = reporterRefId;
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
