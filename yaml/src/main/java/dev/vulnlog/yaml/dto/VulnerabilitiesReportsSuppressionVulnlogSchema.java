
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
    "on",
    "owasp",
    "snyk",
    "trivy",
    "until"
})
public class VulnerabilitiesReportsSuppressionVulnlogSchema {

    /**
     * Suppress on Releases
     * <p>
     * Releases on which this suppression should be applied.
     * 
     */
    @JsonProperty("on")
    @JsonPropertyDescription("Releases on which this suppression should be applied.")
    private Object on;
    /**
     * Vulnlog Vulnerability Report Suppression OWASP Dependency Check Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("owasp")
    private VulnerabilitiesReportsSuppressionOwaspVulnlogSchema owasp;
    /**
     * Vulnlog Vulnerability Report Suppression Snyk Open Source Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("snyk")
    private VulnerabilitiesReportsSuppressionSnykVulnlogSchema snyk;
    /**
     * Vulnlog Vulnerability Report Suppression Trivy Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("trivy")
    private VulnerabilitiesReportsSuppressionTrivyVulnlogSchema trivy;
    /**
     * Suppress Until
     * <p>
     * Date until this suppression should be active to. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("until")
    @JsonPropertyDescription("Date until this suppression should be active to. Format: YYYY-MM-DD")
    private String until;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VulnerabilitiesReportsSuppressionVulnlogSchema() {
    }

    /**
     * 
     * @param owasp
     *     OWASP Dependency Check Suppression. Setups a OWASP Dependency Check suppression.
     * @param trivy
     *     Trivy Suppression. Setups a Trivy suppression.
     * @param snyk
     *     Snyk Open Source Suppression. Setups a Snyk Open Source suppression.
     * @param until
     *     Suppress Until. Date until this suppression should be active to. Format: YYYY-MM-DD.
     * @param on
     *     Suppress on Releases. Releases on which this suppression should be applied.
     */
    public VulnerabilitiesReportsSuppressionVulnlogSchema(Object on, VulnerabilitiesReportsSuppressionOwaspVulnlogSchema owasp, VulnerabilitiesReportsSuppressionSnykVulnlogSchema snyk, VulnerabilitiesReportsSuppressionTrivyVulnlogSchema trivy, String until) {
        super();
        this.on = on;
        this.owasp = owasp;
        this.snyk = snyk;
        this.trivy = trivy;
        this.until = until;
    }

    /**
     * Suppress on Releases
     * <p>
     * Releases on which this suppression should be applied.
     * 
     */
    @JsonProperty("on")
    public Object getOn() {
        return on;
    }

    /**
     * Suppress on Releases
     * <p>
     * Releases on which this suppression should be applied.
     * 
     */
    @JsonProperty("on")
    public void setOn(Object on) {
        this.on = on;
    }

    /**
     * Vulnlog Vulnerability Report Suppression OWASP Dependency Check Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("owasp")
    public VulnerabilitiesReportsSuppressionOwaspVulnlogSchema getOwasp() {
        return owasp;
    }

    /**
     * Vulnlog Vulnerability Report Suppression OWASP Dependency Check Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("owasp")
    public void setOwasp(VulnerabilitiesReportsSuppressionOwaspVulnlogSchema owasp) {
        this.owasp = owasp;
    }

    /**
     * Vulnlog Vulnerability Report Suppression Snyk Open Source Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("snyk")
    public VulnerabilitiesReportsSuppressionSnykVulnlogSchema getSnyk() {
        return snyk;
    }

    /**
     * Vulnlog Vulnerability Report Suppression Snyk Open Source Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("snyk")
    public void setSnyk(VulnerabilitiesReportsSuppressionSnykVulnlogSchema snyk) {
        this.snyk = snyk;
    }

    /**
     * Vulnlog Vulnerability Report Suppression Trivy Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("trivy")
    public VulnerabilitiesReportsSuppressionTrivyVulnlogSchema getTrivy() {
        return trivy;
    }

    /**
     * Vulnlog Vulnerability Report Suppression Trivy Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("trivy")
    public void setTrivy(VulnerabilitiesReportsSuppressionTrivyVulnlogSchema trivy) {
        this.trivy = trivy;
    }

    /**
     * Suppress Until
     * <p>
     * Date until this suppression should be active to. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("until")
    public String getUntil() {
        return until;
    }

    /**
     * Suppress Until
     * <p>
     * Date until this suppression should be active to. Format: YYYY-MM-DD
     * 
     */
    @JsonProperty("until")
    public void setUntil(String until) {
        this.until = until;
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
