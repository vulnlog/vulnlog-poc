
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
     * Identifier of the reporter. Must be unique. Example: "trivy".
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Identifier of the reporter. Must be unique. Example: \"trivy\".")
    private String id;
    /**
     * Reporter Name
     * <p>
     * Printable name of the reporter. Example: "OWASP Dependency Check".
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Printable name of the reporter. Example: \"OWASP Dependency Check\".")
    private String name;
    /**
     * Reporter Product
     * <p>
     * WIP: An identifier describing the product. This identifier should be used later to match predefined templates for suppression files for example.
     * 
     */
    @JsonProperty("product")
    @JsonPropertyDescription("WIP: An identifier describing the product. This identifier should be used later to match predefined templates for suppression files for example.")
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
     *     Reporter Product. WIP: An identifier describing the product. This identifier should be used later to match predefined templates for suppression files for example.
     * @param name
     *     Reporter Name. Printable name of the reporter. Example: "OWASP Dependency Check".
     * @param id
     *     Reporter Identifier. Identifier of the reporter. Must be unique. Example: "trivy".
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
     * Identifier of the reporter. Must be unique. Example: "trivy".
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Reporter Identifier
     * <p>
     * Identifier of the reporter. Must be unique. Example: "trivy".
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Reporter Name
     * <p>
     * Printable name of the reporter. Example: "OWASP Dependency Check".
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Reporter Name
     * <p>
     * Printable name of the reporter. Example: "OWASP Dependency Check".
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Reporter Product
     * <p>
     * WIP: An identifier describing the product. This identifier should be used later to match predefined templates for suppression files for example.
     * 
     */
    @JsonProperty("product")
    public String getProduct() {
        return product;
    }

    /**
     * Reporter Product
     * <p>
     * WIP: An identifier describing the product. This identifier should be used later to match predefined templates for suppression files for example.
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
