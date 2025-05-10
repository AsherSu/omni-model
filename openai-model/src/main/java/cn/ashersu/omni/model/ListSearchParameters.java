package cn.ashersu.omni.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common options when getting a list of objects
 */
public class ListSearchParameters {
    /**
     * A limit on the number of objects to be returned.
     * Limit can range between 1 and 100, and the default is 20
     */
    private Integer limit;

    /**
     * Sort order by the 'created_at' timestamp of the objects.
     * 'asc' for ascending order and 'desc' for descending order.
     */
    private Order order;

    /**
     * A cursor for use in pagination. after is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include after=obj_foo in order to fetch the next page of the list
     */
    private String after;

    /**
     * A cursor for use in pagination. before is an object ID that defines your place in the list.
     * For instance, if you make a list request and receive 100 objects, ending with obj_foo,
     * your subsequent call can include before=obj_foo in order to fetch the previous page of the list.
     */
    private String before;
    
    public ListSearchParameters() {
    }
    
    public ListSearchParameters(Integer limit, Order order, String after, String before) {
        this.limit = limit;
        this.order = order;
        this.after = after;
        this.before = before;
    }
    
    public Integer getLimit() {
        return limit;
    }
    
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public String getAfter() {
        return after;
    }
    
    public void setAfter(String after) {
        this.after = after;
    }
    
    public String getBefore() {
        return before;
    }
    
    public void setBefore(String before) {
        this.before = before;
    }
    
    public static Builder builder() {
        return new Builder();
    }

    public enum Order {
        @JsonProperty("asc")
        ASCENDING,

        @JsonProperty("desc")
        DESCENDING
    }
    
    public static class Builder {
        private Integer limit;
        private Order order;
        private String after;
        private String before;
        
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }
        
        public Builder order(Order order) {
            this.order = order;
            return this;
        }
        
        public Builder after(String after) {
            this.after = after;
            return this;
        }
        
        public Builder before(String before) {
            this.before = before;
            return this;
        }
        
        public ListSearchParameters build() {
            return new ListSearchParameters(limit, order, after, before);
        }
    }
}
