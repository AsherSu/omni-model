package cn.ashersu.omni.model.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A list of files attached to a Message
 * <p>
 * https://platform.openai.com/docs/api-reference/messages/file-object
 */
public class MessageFile {
    /**
     * The identifier, which can be referenced in API endpoints.
     */
    private String id;

    /**
     * The object type, which is always thread.message.file.
     */
    private String object;

    /**
     * The Unix timestamp (in seconds) for when the message file was created.
     */
    @JsonProperty("created_at")
    private int createdAt;

    /**
     * The ID of the message that the File is attached to.
     */
    @JsonProperty("message_id")
    private String messageId;
    
    public MessageFile() {
    }
    
    public MessageFile(String id, String object, int createdAt, String messageId) {
        this.id = id;
        this.object = object;
        this.createdAt = createdAt;
        this.messageId = messageId;
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
    
    public String getMessageId() {
        return messageId;
    }
    
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
