package cn.ashersu.omni.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * A wrapper class to fit the OpenAI engine and search endpoints
 */
public class OpenAiResponse<T> {
    /**
     * A list containing the actual results
     */
    private List<T> data;

    /**
     * The type of object returned, should be "list"
     */
    private String object;

    /**
     * The first id included
     */
    @JsonProperty("first_id")
    private String firstId;

    /**
     * The last id included
     */
    @JsonProperty("last_id")
    private String lastId;

    /**
     * True if there are objects after lastId
     */
    @JsonProperty("has_more")
    private boolean hasMore;
    
    public List<T> getData() {
        return data;
    }
    
    public void setData(List<T> data) {
        this.data = data;
    }
    
    public String getObject() {
        return object;
    }
    
    public void setObject(String object) {
        this.object = object;
    }
    
    public String getFirstId() {
        return firstId;
    }
    
    public void setFirstId(String firstId) {
        this.firstId = firstId;
    }
    
    public String getLastId() {
        return lastId;
    }
    
    public void setLastId(String lastId) {
        this.lastId = lastId;
    }
    
    public boolean isHasMore() {
        return hasMore;
    }
    
    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
