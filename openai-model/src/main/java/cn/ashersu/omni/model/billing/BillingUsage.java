package cn.ashersu.omni.model.billing;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * Amount consumption information
 *
 */
public class BillingUsage {

    @JsonProperty("object")
    private String object;
    /**
     * Account expenditure details
     */
    @JsonProperty("daily_costs")
    private List<DailyCost> dailyCosts;
    /**
     * Total usage amount: cents
     */
    @JsonProperty("total_usage")
    private BigDecimal totalUsage;
    
    public BillingUsage() {
    }
    
    public BillingUsage(String object, List<DailyCost> dailyCosts, BigDecimal totalUsage) {
        this.object = object;
        this.dailyCosts = dailyCosts;
        this.totalUsage = totalUsage;
    }
    
    public String getObject() {
        return object;
    }
    
    public void setObject(String object) {
        this.object = object;
    }
    
    public List<DailyCost> getDailyCosts() {
        return dailyCosts;
    }
    
    public void setDailyCosts(List<DailyCost> dailyCosts) {
        this.dailyCosts = dailyCosts;
    }
    
    public BigDecimal getTotalUsage() {
        return totalUsage;
    }
    
    public void setTotalUsage(BigDecimal totalUsage) {
        this.totalUsage = totalUsage;
    }
}
