package cn.ashersu.omni.model.fine_tuning;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object representing an event in the lifecycle of a fine-tuning job
 *
 * https://platform.openai.com/docs/api-reference/fine-tuning/list-events
 */
public class FineTuningEvent {
    /**
     * The type of object returned, should be "fine-tuneing.job.event".
     */
    private String object;

    /**
     * The ID of the fine-tuning event.
     */
    private String id;

    /**
     * The creation time in epoch seconds.
     */
    @JsonProperty("created_at")
    private Long createdAt;

    /**
     * The log level of this message.
     */
    private String level;

    /**
     * The event message.
     */
    private String message;

    /**
     * The type of event, i.e. "message"
     */
    private String type;
    
    public FineTuningEvent() {
    }
    
    public FineTuningEvent(String object, String id, Long createdAt, String level, String message, String type) {
        this.object = object;
        this.id = id;
        this.createdAt = createdAt;
        this.level = level;
        this.message = message;
        this.type = type;
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
    
    public Long getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getLevel() {
        return level;
    }
    
    public void setLevel(String level) {
        this.level = level;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
