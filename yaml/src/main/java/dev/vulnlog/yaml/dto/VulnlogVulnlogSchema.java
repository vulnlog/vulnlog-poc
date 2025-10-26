
package dev.vulnlog.yaml.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Vulnlog Vulnlog Schema
 * <p>
 * Validates Vulnlog Vulnlog YAML files.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "version",
    "vendor",
    "product"
})
public class VulnlogVulnlogSchema {

    /**
     * Version
     * <p>
     * The version of the Vulnlog file.
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("The version of the Vulnlog file.")
    private String version;
    /**
     * Vendor
     * <p>
     * The vendor of the product.
     * 
     */
    @JsonProperty("vendor")
    @JsonPropertyDescription("The vendor of the product.")
    private String vendor;
    /**
     * Product
     * <p>
     * The product this Vulnlog files covers.
     * 
     */
    @JsonProperty("product")
    @JsonPropertyDescription("The product this Vulnlog files covers.")
    private String product;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnlogVulnlogSchema() {
    }

    /**
     * 
     * @param product
     *     Product. The product this Vulnlog files covers.
     * @param vendor
     *     Vendor. The vendor of the product.
     * @param version
     *     Version. The version of the Vulnlog file.
     */
    public VulnlogVulnlogSchema(String version, String vendor, String product) {
        super();
        this.version = version;
        this.vendor = vendor;
        this.product = product;
    }

    /**
     * Version
     * <p>
     * The version of the Vulnlog file.
     * 
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version
     * <p>
     * The version of the Vulnlog file.
     * 
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Vendor
     * <p>
     * The vendor of the product.
     * 
     */
    @JsonProperty("vendor")
    public String getVendor() {
        return vendor;
    }

    /**
     * Vendor
     * <p>
     * The vendor of the product.
     * 
     */
    @JsonProperty("vendor")
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * Product
     * <p>
     * The product this Vulnlog files covers.
     * 
     */
    @JsonProperty("product")
    public String getProduct() {
        return product;
    }

    /**
     * Product
     * <p>
     * The product this Vulnlog files covers.
     * 
     */
    @JsonProperty("product")
    public void setProduct(String product) {
        this.product = product;
    }

}
