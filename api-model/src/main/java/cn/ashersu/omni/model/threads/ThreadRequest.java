package cn.ashersu.omni.model.threads;

import cn.ashersu.omni.model.messages.MessageRequest;

import java.util.List;
import java.util.Map;

/**
 * Creates a thread
 * <p>
 * https://platform.openai.com/docs/api-reference/threads/createThread
 */
public class ThreadRequest {
    /**
     * A list of messages to start the thread with. Optional.
     */
    private List<MessageRequest> messages;

    /**
     * Set of 16 key-value pairs that can be attached to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * Keys can be a maximum of 64 characters long, and values can be a maximum of 512 characters long.
     */
    private Map<String, String> metadata;
    
    public ThreadRequest() {
    }
    
    public ThreadRequest(List<MessageRequest> messages, Map<String, String> metadata) {
        this.messages = messages;
        this.metadata = metadata;
    }
    
    public List<MessageRequest> getMessages() {
        return messages;
    }
    
    public void setMessages(List<MessageRequest> messages) {
        this.messages = messages;
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
        private List<MessageRequest> messages;
        private Map<String, String> metadata;
        
        public Builder messages(List<MessageRequest> messages) {
            this.messages = messages;
            return this;
        }
        
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }
        
        public ThreadRequest build() {
            return new ThreadRequest(messages, metadata);
        }
    }
}
