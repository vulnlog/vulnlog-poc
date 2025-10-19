
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
     * TODO
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("TODO")
    private String id;
    /**
     * Pipeline Lifetime
     * <p>
     * TODO
     * 
     */
    @JsonProperty("lifetime")
    @JsonPropertyDescription("TODO")
    private Lifetime lifetime;
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
     *     Pipeline Lifetime. TODO.
     * @param name
     *     Reporter Pipeline Name. TODO.
     * @param reporterRefId
     *     Reporter. TODO.
     * @param id
     *     Reporter Pipeline Identifier. TODO.
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
