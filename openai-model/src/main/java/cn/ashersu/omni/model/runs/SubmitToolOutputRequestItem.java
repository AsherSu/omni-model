package cn.ashersu.omni.model.runs;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @description 
 * @author  vacuity
 * @create  2023-11-16 22:45
 **/

public class SubmitToolOutputRequestItem {

    @JsonProperty("tool_call_id")
    private String toolCallId;
    
    private String output;
    
    public SubmitToolOutputRequestItem() {
    }
    
    public SubmitToolOutputRequestItem(String toolCallId, String output) {
        this.toolCallId = toolCallId;
        this.output = output;
    }
    
    public String getToolCallId() {
        return toolCallId;
    }
    
    public void setToolCallId(String toolCallId) {
        this.toolCallId = toolCallId;
    }
    
    public String getOutput() {
        return output;
    }
    
    public void setOutput(String output) {
        this.output = output;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String toolCallId;
        private String output;
        
        public Builder toolCallId(String toolCallId) {
            this.toolCallId = toolCallId;
            return this;
        }
        
        public Builder output(String output) {
            this.output = output;
            return this;
        }
        
        public SubmitToolOutputRequestItem build() {
            return new SubmitToolOutputRequestItem(toolCallId, output);
        }
    }
}
