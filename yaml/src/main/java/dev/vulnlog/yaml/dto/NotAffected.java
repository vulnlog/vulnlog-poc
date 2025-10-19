
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
 * Not Affected
 * <p>
 * TODO
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vex"
})
public class NotAffected {

    /**
     * VEX Justification
     * <p>
     * TODO
     * 
     */
    @JsonProperty("vex")
    @JsonPropertyDescription("TODO")
    private NotAffected.Vex vex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NotAffected() {
    }

    /**
     * 
     * @param vex
     *     VEX Justification. TODO.
     */
    public NotAffected(NotAffected.Vex vex) {
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
    public NotAffected.Vex getVex() {
        return vex;
    }

    /**
     * VEX Justification
     * <p>
     * TODO
     * 
     */
    @JsonProperty("vex")
    public void setVex(NotAffected.Vex vex) {
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

        FOO("foo"),
        BAR("bar"),
        INLINE_MITIGATIONS_ALREADY_EXIST("Inline mitigations already exist");
        private final String value;
        private final static Map<String, NotAffected.Vex> CONSTANTS = new HashMap<String, NotAffected.Vex>();

        static {
            for (NotAffected.Vex c: values()) {
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
        public static NotAffected.Vex fromValue(String value) {
            NotAffected.Vex constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
