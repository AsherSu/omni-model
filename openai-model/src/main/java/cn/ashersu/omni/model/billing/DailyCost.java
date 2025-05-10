package cn.ashersu.omni.model.billing;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * List of amount consumption
 *
 */
public class DailyCost {
    /**
     *
     */
    @JsonProperty("timestamp")
    private long timestamp;
    /**
     * Model consumption amount details
     */
    @JsonProperty("line_items")
    private List<LineItem> lineItems;
    
    public DailyCost() {
    }
    
    public DailyCost(long timestamp, List<LineItem> lineItems) {
        this.timestamp = timestamp;
        this.lineItems = lineItems;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public List<LineItem> getLineItems() {
        return lineItems;
    }
    
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
