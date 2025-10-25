
package dev.vulnlog.yaml.dto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "vendor"
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
     * Reporter Vendor
     * <p>
     * An identifier describing the reporter vendor. This identifier should be used later to match predefined templates for suppression files for example.
     * 
     */
    @JsonProperty("vendor")
    @JsonPropertyDescription("An identifier describing the reporter vendor. This identifier should be used later to match predefined templates for suppression files for example.")
    private ReportersVulnlogSchema.Vendor vendor;
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
     * @param vendor
     *     Reporter Vendor. An identifier describing the reporter vendor. This identifier should be used later to match predefined templates for suppression files for example.
     * @param name
     *     Reporter Name. Printable name of the reporter. Example: "OWASP Dependency Check".
     * @param id
     *     Reporter Identifier. Identifier of the reporter. Must be unique. Example: "trivy".
     */
    public ReportersVulnlogSchema(String id, String name, ReportersVulnlogSchema.Vendor vendor) {
        super();
        this.id = id;
        this.name = name;
        this.vendor = vendor;
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
     * Reporter Vendor
     * <p>
     * An identifier describing the reporter vendor. This identifier should be used later to match predefined templates for suppression files for example.
     * 
     */
    @JsonProperty("vendor")
    public ReportersVulnlogSchema.Vendor getVendor() {
        return vendor;
    }

    /**
     * Reporter Vendor
     * <p>
     * An identifier describing the reporter vendor. This identifier should be used later to match predefined templates for suppression files for example.
     * 
     */
    @JsonProperty("vendor")
    public void setVendor(ReportersVulnlogSchema.Vendor vendor) {
        this.vendor = vendor;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    /**
     * Reporter Vendor
     * <p>
     * An identifier describing the reporter vendor. This identifier should be used later to match predefined templates for suppression files for example.
     * 
     */
    public enum Vendor {

        AQUA_SECURITY_TRIVY("Aqua Security Trivy"),
        OWASP_DEPENDENCY_CHECK("OWASP Dependency Check"),
        SNYK_OPEN_SOURCE("Snyk Open Source");
        private final String value;
        private final static Map<String, ReportersVulnlogSchema.Vendor> CONSTANTS = new HashMap<String, ReportersVulnlogSchema.Vendor>();

        static {
            for (ReportersVulnlogSchema.Vendor c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Vendor(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static ReportersVulnlogSchema.Vendor fromValue(String value) {
            ReportersVulnlogSchema.Vendor constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
