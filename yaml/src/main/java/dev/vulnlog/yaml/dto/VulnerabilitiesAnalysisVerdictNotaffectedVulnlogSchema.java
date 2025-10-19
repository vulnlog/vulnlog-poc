
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
 * Vulnlog Vulnerability Analysis Verdict Not Affected Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vex"
})
public class VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema {

    /**
     * VEX Justification
     * <p>
     * TODO
     * 
     */
    @JsonProperty("vex")
    @JsonPropertyDescription("TODO")
    private VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex vex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema() {
    }

    /**
     * 
     * @param vex
     *     VEX Justification. TODO.
     */
    public VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema(VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex vex) {
        super();
        this.vex = vex;
    }

    /**
     * VEX Justification
     * <p>
     * TODO
     * 
     */
    @JsonProperty("vex")
    public VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex getVex() {
        return vex;
    }

    /**
     * VEX Justification
     * <p>
     * TODO
     * 
     */
    @JsonProperty("vex")
    public void setVex(VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex vex) {
        this.vex = vex;
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
     * VEX Justification
     * <p>
     * TODO
     * 
     */
    public enum Vex {

        COMPONENT_NOT_PRESENT("COMPONENT_NOT_PRESENT"),
        INLINE_MITIGATIONS_ALREADY_EXIST("INLINE_MITIGATIONS_ALREADY_EXIST"),
        VULNERABLE_CODE_CANNOT_BE_CONTROLLED_BY_ADVERSARY("VULNERABLE_CODE_CANNOT_BE_CONTROLLED_BY_ADVERSARY"),
        VULNERABLE_CODE_NOT_IN_EXECUTE_PATH("VULNERABLE_CODE_NOT_IN_EXECUTE_PATH"),
        VULNERABLE_CODE_NOT_PRESENT("VULNERABLE_CODE_NOT_PRESENT");
        private final String value;
        private final static Map<String, VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex> CONSTANTS = new HashMap<String, VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex>();

        static {
            for (VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Vex(String value) {
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
        public static VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex fromValue(String value) {
            VulnerabilitiesAnalysisVerdictNotaffectedVulnlogSchema.Vex constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
