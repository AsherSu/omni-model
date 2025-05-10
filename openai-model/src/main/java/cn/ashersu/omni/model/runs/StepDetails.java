package cn.ashersu.omni.model.runs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StepDetails {
    
    private String type;

    @JsonProperty("message_creation")
    private MessageCreation messageCreation;

    @JsonProperty("tool_calls")
    private List<ToolCall> toolCalls;
    
    public StepDetails() {
    }
    
    public StepDetails(String type, MessageCreation messageCreation, List<ToolCall> toolCalls) {
        this.type = type;
        this.messageCreation = messageCreation;
        this.toolCalls = toolCalls;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public MessageCreation getMessageCreation() {
        return messageCreation;
    }
    
    public void setMessageCreation(MessageCreation messageCreation) {
        this.messageCreation = messageCreation;
    }
    
    public List<ToolCall> getToolCalls() {
        return toolCalls;
    }
    
    public void setToolCalls(List<ToolCall> toolCalls) {
        this.toolCalls = toolCalls;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String type;
        private MessageCreation messageCreation;
        private List<ToolCall> toolCalls;
        
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        
        public Builder messageCreation(MessageCreation messageCreation) {
            this.messageCreation = messageCreation;
            return this;
        }
        
        public Builder toolCalls(List<ToolCall> toolCalls) {
            this.toolCalls = toolCalls;
            return this;
        }
        
        public StepDetails build() {
            return new StepDetails(type, messageCreation, toolCalls);
        }
    }
}
