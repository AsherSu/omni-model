package cn.ashersu.omni.model.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Creates a Message
 * <p>
 * https://platform.openai.com/docs/api-reference/messages/createMessage
 */
public class MessageRequest {
    /**
     * The role of the entity that is creating the message.
     * Currently only "user" is supported.
     */
    private String role = "user";

    /**
     * The content of the message.
     */
    private String content;

    /**
     * A list of File IDs that the message should use.
     * Defaults to an empty list.
     * There can be a maximum of 10 files attached to a message.
     * Useful for tools like retrieval and code_interpreter that can access and use files.
     */
    @JsonProperty("file_ids")
    private List<String> fileIds;

    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long, and values can be a maximum of 512 characters long.
     */
    private Map<String, String> metadata;
    
    public MessageRequest() {
        this.role = "user";
    }
    
    public MessageRequest(String role, String content, List<String> fileIds, Map<String, String> metadata) {
        this.role = role != null ? role : "user";
        this.content = Objects.requireNonNull(content, "content cannot be null");
        this.fileIds = fileIds;
        this.metadata = metadata;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role != null ? role : "user";
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = Objects.requireNonNull(content, "content cannot be null");
    }
    
    public List<String> getFileIds() {
        return fileIds;
    }
    
    public void setFileIds(List<String> fileIds) {
        this.fileIds = fileIds;
    }
    
    public Map<String, String> getMetadata() {
        return metadata;
    }
    
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String role = "user";
        private String content;
        private List<String> fileIds;
        private Map<String, String> metadata;
        
        public Builder role(String role) {
            this.role = role != null ? role : "user";
            return this;
        }
        
        public Builder content(String content) {
            this.content = Objects.requireNonNull(content, "content cannot be null");
            return this;
        }
        
        public Builder fileIds(List<String> fileIds) {
            this.fileIds = fileIds;
            return this;
        }
        
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }
        
        public MessageRequest build() {
            return new MessageRequest(role, content, fileIds, metadata);
        }
    }
}
