package cn.ashersu.omni.model.finetune;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object representing an event in the lifecycle of a fine-tuning job
 *
 * https://beta.openai.com/docs/api-reference/fine-tunes
 */
@Deprecated
public class FineTuneEvent {
    /**
     * The type of object returned, should be "fine-tune-event".
     */
    private String object;

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
    
    public FineTuneEvent() {
    }
    
    public FineTuneEvent(String object, Long createdAt, String level, String message) {
        this.object = object;
        this.createdAt = createdAt;
        this.level = level;
        this.message = message;
    }
    
    public String getObject() {
        return object;
    }
    
    public void setObject(String object) {
        this.object = object;
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
}
