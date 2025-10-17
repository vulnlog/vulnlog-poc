
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
    "reporter-ref-id",
    "lifetime"
})
public class ReporterPipelinesVulnlogSchema {

    /**
     * Reporter Pipeline Identifier
     * <p>
     * TODO
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("TODO")
    private String id;
    /**
     * Reporter Pipeline Name
     * <p>
     * TODO
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("TODO")
    private String name;
    /**
     * Reporter
     * <p>
     * TODO
     * 
     */
    @JsonProperty("reporter-ref-id")
    @JsonPropertyDescription("TODO")
    private String reporterRefId;
    /**
     * Pipeline Lifetime
     * <p>
     * TODO
     * 
     */
    @JsonProperty("lifetime")
    @JsonPropertyDescription("TODO")
    private Lifetime lifetime;
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
     * @param name
     *     Reporter Pipeline Name. TODO.
     * @param lifetime
     *     Pipeline Lifetime. TODO.
     * @param reporterRefId
     *     Reporter. TODO.
     * @param id
     *     Reporter Pipeline Identifier. TODO.
     */
    public ReporterPipelinesVulnlogSchema(String id, String name, String reporterRefId, Lifetime lifetime) {
        super();
        this.id = id;
        this.name = name;
        this.reporterRefId = reporterRefId;
        this.lifetime = lifetime;
    }

    /**
     * Reporter Pipeline Identifier
     * <p>
     * TODO
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Reporter Pipeline Identifier
     * <p>
     * TODO
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Reporter Pipeline Name
     * <p>
     * TODO
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Reporter Pipeline Name
     * <p>
     * TODO
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Reporter
     * <p>
     * TODO
     * 
     */
    @JsonProperty("reporter-ref-id")
    public String getReporterRefId() {
        return reporterRefId;
    }

    /**
     * Reporter
     * <p>
     * TODO
     * 
     */
    @JsonProperty("reporter-ref-id")
    public void setReporterRefId(String reporterRefId) {
        this.reporterRefId = reporterRefId;
    }

    /**
     * Pipeline Lifetime
     * <p>
     * TODO
     * 
     */
    @JsonProperty("lifetime")
    public Lifetime getLifetime() {
        return lifetime;
    }

    /**
     * Pipeline Lifetime
     * <p>
     * TODO
     * 
     */
    @JsonProperty("lifetime")
    public void setLifetime(Lifetime lifetime) {
        this.lifetime = lifetime;
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
