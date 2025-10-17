
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
    "product"
})
public class ReportersVulnlogSchema {

    /**
     * Reporter Identifier
     * <p>
     * TODO
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("TODO")
    private String id;
    /**
     * Reporter Name
     * <p>
     * TODO
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("TODO")
    private String name;
    /**
     * Reporter Product
     * <p>
     * TODO
     * 
     */
    @JsonProperty("product")
    @JsonPropertyDescription("TODO")
    private String product;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReportersVulnlogSchema() {
    }

    /**
     * 
     * @param product
     *     Reporter Product. TODO.
     * @param name
     *     Reporter Name. TODO.
     * @param id
     *     Reporter Identifier. TODO.
     */
    public ReportersVulnlogSchema(String id, String name, String product) {
        super();
        this.id = id;
        this.name = name;
        this.product = product;
    }

    /**
     * Reporter Identifier
     * <p>
     * TODO
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Reporter Identifier
     * <p>
     * TODO
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Reporter Name
     * <p>
     * TODO
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Reporter Name
     * <p>
     * TODO
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Reporter Product
     * <p>
     * TODO
     * 
     */
    @JsonProperty("product")
    public String getProduct() {
        return product;
    }

    /**
     * Reporter Product
     * <p>
     * TODO
     * 
     */
    @JsonProperty("product")
    public void setProduct(String product) {
        this.product = product;
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
