
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


/**
 * Vulnlog Vulnerability Analysis Verdict Affected Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "severity"
})
public class VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema {

    /**
     * Severity
     * <p>
     * TODO
     * 
     */
    @JsonProperty("severity")
    @JsonPropertyDescription("TODO")
    private VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity severity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema() {
    }

    /**
     * 
     * @param severity
     *     Severity. TODO.
     */
    public VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema(VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity severity) {
        super();
        this.severity = severity;
    }

    /**
     * Severity
     * <p>
     * TODO
     * 
     */
    @JsonProperty("severity")
    public VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity getSeverity() {
        return severity;
    }

    /**
     * Severity
     * <p>
     * TODO
     * 
     */
    @JsonProperty("severity")
    public void setSeverity(VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity severity) {
        this.severity = severity;
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
     * Severity
     * <p>
     * TODO
     * 
     */
    public enum Severity {

        CRITICAL("Critical"),
        HIGH("High"),
        MEDIUM("Medium"),
        LOW("Low");
        private final String value;
        private final static Map<String, VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity> CONSTANTS = new HashMap<String, VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity>();

        static {
            for (VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Severity(String value) {
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
        public static VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity fromValue(String value) {
            VulnerabilitiesAnalysisVerdictAffectedVulnlogSchema.Severity constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
