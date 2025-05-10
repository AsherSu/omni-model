package cn.ashersu.omni.model.runs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @description 
 * @author  vacuity
 * @create  2023-11-16 22:45
 **/

public class SubmitToolOutputs {
    
    @JsonProperty("tool_calls")
    private List<ToolCall> toolCalls;
    
    public SubmitToolOutputs() {
    }
    
    public SubmitToolOutputs(List<ToolCall> toolCalls) {
        this.toolCalls = toolCalls;
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
        private List<ToolCall> toolCalls;
        
        public Builder toolCalls(List<ToolCall> toolCalls) {
            this.toolCalls = toolCalls;
            return this;
        }
        
        public SubmitToolOutputs build() {
            return new SubmitToolOutputs(toolCalls);
        }
    }
}
