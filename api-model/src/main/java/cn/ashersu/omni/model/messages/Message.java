package cn.ashersu.omni.model.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;


/**
 * Represents a Message within a thread.
 * <p>
 * https://platform.openai.com/docs/api-reference/messages/object
 */
public class Message {
    /**
     * The identifier, which can be referenced in API endpoints.
     */
    private String id;

    /**
     * The object type, which is always thread.message.
     */
    private String object;

    /**
     * The Unix timestamp (in seconds) for when the message was created.
     */
    @JsonProperty("created_at")
    private int createdAt;

    /**
     * The thread ID that this message belongs to.
     */
    @JsonProperty("thread_id")
    private String threadId;

    /**
     * The entity that produced the message. One of user or assistant.
     */
    private String role;

    /**
     * The content of the message in an array of text and/or images.
     */
    private List<MessageContent> content;

    /**
     * If applicable, the ID of the assistant that authored this message.
     */
    @JsonProperty("assistant_id")
    private String assistantId;

    /**
     * If applicable, the ID of the run associated with the authoring of this message.
     */
    @JsonProperty("run_id")
    private String runId;

    /**
     * A list of file IDs that the assistant should use.
     * Useful for tools like retrieval and code_interpreter that can access files.
     * A maximum of 10 files can be attached to a message.
     */
    @JsonProperty("file_ids")
    private List<String> fileIds;

    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long, and values can be a maximum of 512 characters long.
     */
    private Map<String, String> metadata;
    
    public Message() {
    }
    
    public Message(String id, String object, int createdAt, String threadId, String role, 
                   List<MessageContent> content, String assistantId, String runId, 
                   List<String> fileIds, Map<String, String> metadata) {
        this.id = id;
        this.object = object;
        this.createdAt = createdAt;
        this.threadId = threadId;
        this.role = role;
        this.content = content;
        this.assistantId = assistantId;
        this.runId = runId;
        this.fileIds = fileIds;
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
    
    public String getThreadId() {
        return threadId;
    }
    
    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public List<MessageContent> getContent() {
        return content;
    }
    
    public void setContent(List<MessageContent> content) {
        this.content = content;
    }
    
    public String getAssistantId() {
        return assistantId;
    }
    
    public void setAssistantId(String assistantId) {
        this.assistantId = assistantId;
    }
    
    public String getRunId() {
        return runId;
    }
    
    public void setRunId(String runId) {
        this.runId = runId;
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
        private String id;
        private String object;
        private int createdAt;
        private String threadId;
        private String role;
        private List<MessageContent> content;
        private String assistantId;
        private String runId;
        private List<String> fileIds;
        private Map<String, String> metadata;
        
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        
        public Builder object(String object) {
            this.object = object;
            return this;
        }
        
        public Builder createdAt(int createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        
        public Builder threadId(String threadId) {
            this.threadId = threadId;
            return this;
        }
        
        public Builder role(String role) {
            this.role = role;
            return this;
        }
        
        public Builder content(List<MessageContent> content) {
            this.content = content;
            return this;
        }
        
        public Builder assistantId(String assistantId) {
            this.assistantId = assistantId;
            return this;
        }
        
        public Builder runId(String runId) {
            this.runId = runId;
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
        
        public Message build() {
            return new Message(id, object, createdAt, threadId, role, content,
                    assistantId, runId, fileIds, metadata);
        }
    }
}