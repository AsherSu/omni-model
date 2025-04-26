package com.omnimodel.billing;

import lombok.Data;

import java.math.BigDecimal;

/**
 * List of amount consumption
 *
 */
@Data
public class LineItem {
    /**
     * model name
     */
    private String name;
    /**
     * Expenditure amount
     */
    private BigDecimal cost;
}
