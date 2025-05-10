package cn.ashersu.omni.model.billing;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Return value of balance inquiry interface
 *
 */
public class CreditGrantsResponse implements Serializable {
    private String object;
    /**
     * Total amount: US dollars
     */
    @JsonProperty("total_granted")
    private BigDecimal totalGranted;
    /**
     * Total usage amount: US dollars
     */
    @JsonProperty("total_used")
    private BigDecimal totalUsed;
    /**
     * Total remaining amount: US dollars
     */
    @JsonProperty("total_available")
    private BigDecimal totalAvailable;
    /**
     * Balance details
     */
    private Grants grants;
    
    public CreditGrantsResponse() {
    }
    
    public CreditGrantsResponse(String object, BigDecimal totalGranted, BigDecimal totalUsed, 
                               BigDecimal totalAvailable, Grants grants) {
        this.object = object;
        this.totalGranted = totalGranted;
        this.totalUsed = totalUsed;
        this.totalAvailable = totalAvailable;
        this.grants = grants;
    }
    
    public String getObject() {
        return object;
    }
    
    public void setObject(String object) {
        this.object = object;
    }
    
    public BigDecimal getTotalGranted() {
        return totalGranted;
    }
    
    public void setTotalGranted(BigDecimal totalGranted) {
        this.totalGranted = totalGranted;
    }
    
    public BigDecimal getTotalUsed() {
        return totalUsed;
    }
    
    public void setTotalUsed(BigDecimal totalUsed) {
        this.totalUsed = totalUsed;
    }
    
    public BigDecimal getTotalAvailable() {
        return totalAvailable;
    }
    
    public void setTotalAvailable(BigDecimal totalAvailable) {
        this.totalAvailable = totalAvailable;
    }
    
    public Grants getGrants() {
        return grants;
    }
    
    public void setGrants(Grants grants) {
        this.grants = grants;
    }
}
