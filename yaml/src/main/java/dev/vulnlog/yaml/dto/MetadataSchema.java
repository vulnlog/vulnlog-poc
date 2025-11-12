
package dev.vulnlog.yaml.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Vulnlog Metadata Schema
 * <p>
 * Validates Vulnlog Vulnlog YAML files.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vendor",
    "product",
    "author"
})
public class MetadataSchema {

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
     * Author
     * <p>
     * This Vulnlog file is curated by the authoring person or team.
     * 
     */
    @JsonProperty("author")
    @JsonPropertyDescription("This Vulnlog file is curated by the authoring person or team.")
    private String author;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MetadataSchema() {
    }

    /**
     * 
     * @param product
     *     Product. The product this Vulnlog files covers.
     * @param vendor
     *     Vendor. The vendor of the product.
     * @param author
     *     Author. This Vulnlog file is curated by the authoring person or team.
     */
    public MetadataSchema(String vendor, String product, String author) {
        super();
        this.vendor = vendor;
        this.product = product;
        this.author = author;
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

    /**
     * Author
     * <p>
     * This Vulnlog file is curated by the authoring person or team.
     * 
     */
    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    /**
     * Author
     * <p>
     * This Vulnlog file is curated by the authoring person or team.
     * 
     */
    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

}
