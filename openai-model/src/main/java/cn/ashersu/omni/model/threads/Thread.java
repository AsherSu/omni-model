package cn.ashersu.omni.model.threads;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Represents a Thread with an assistant
 * <p>
 * https://platform.openai.com/docs/api-reference/threads/object
 */
public class Thread {
    /**
     * The identifier, which can be referenced in API endpoints.
     */
    private String id;

    /**
     * The object type, which is always thread.
     */
    private String object;

    /**
     * The Unix timestamp (in seconds) for when the thread was created.
     */
    @JsonProperty("created_at")
    private int createdAt;

    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long, and values can be a maximum of 512 characters long.
     */
    private Map<String, String> metadata;
    
    public Thread() {
    }
    
    public Thread(String id, String object, int createdAt, Map<String, String> metadata) {
        this.id = id;
        this.object = object;
        this.createdAt = createdAt;
        this.metadata = metadata;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getObject() {
        return object;
    }
    
    public void setObject(String object) {
        this.object = object;
    }
    
    public int getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }
    
    public Map<String, String> getMetadata() {
        return metadata;
    }
    
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
