package cn.ashersu.omni.model.runs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageCreation {
    
    @JsonProperty("message_id")
    private String messageId;
    
    public MessageCreation() {
    }
    
    public MessageCreation(String messageId) {
        this.messageId = messageId;
    }
    
    public String getMessageId() {
        return messageId;
    }
    
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String messageId;
        
        public Builder messageId(String messageId) {
            this.messageId = messageId;
            return this;
        }
        
        public MessageCreation build() {
            return new MessageCreation(messageId);
        }
    }
}
