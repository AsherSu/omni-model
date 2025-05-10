package cn.ashersu.omni.model.billing;

import java.math.BigDecimal;

/**
 * List of amount consumption
 *
 */
public class LineItem {
    /**
     * model name
     */
    private String name;
    /**
     * Expenditure amount
     */
    private BigDecimal cost;
    
    public LineItem() {
    }
    
    public LineItem(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public BigDecimal getCost() {
        return cost;
    }
    
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
