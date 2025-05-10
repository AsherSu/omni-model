package cn.ashersu.omni.model.billing;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 *
 *
 */
public class Datum {
    private String object;
    private String id;
    /**
     * Gift amount: US dollars
     */
    @JsonProperty("grant_amount")
    private BigDecimal grantAmount;
    /**
     * Usage amount: US dollars
     */
    @JsonProperty("used_amount")
    private BigDecimal usedAmount;
    /**
     * Effective timestamp
     */
    @JsonProperty("effective_at")
    private Long effectiveAt;
    /**
     * Expiration timestamp
     */
    @JsonProperty("expires_at")
    private Long expiresAt;
    
    public Datum() {
    }
    
    public Datum(String object, String id, BigDecimal grantAmount, BigDecimal usedAmount, 
                Long effectiveAt, Long expiresAt) {
        this.object = object;
        this.id = id;
        this.grantAmount = grantAmount;
        this.usedAmount = usedAmount;
        this.effectiveAt = effectiveAt;
        this.expiresAt = expiresAt;
    }
    
    public String getObject() {
        return object;
    }
    
    public void setObject(String object) {
        this.object = object;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public BigDecimal getGrantAmount() {
        return grantAmount;
    }
    
    public void setGrantAmount(BigDecimal grantAmount) {
        this.grantAmount = grantAmount;
    }
    
    public BigDecimal getUsedAmount() {
        return usedAmount;
    }
    
    public void setUsedAmount(BigDecimal usedAmount) {
        this.usedAmount = usedAmount;
    }
    
    public Long getEffectiveAt() {
        return effectiveAt;
    }
    
    public void setEffectiveAt(Long effectiveAt) {
        this.effectiveAt = effectiveAt;
    }
    
    public Long getExpiresAt() {
        return expiresAt;
    }
    
    public void setExpiresAt(Long expiresAt) {
        this.expiresAt = expiresAt;
    }
}
