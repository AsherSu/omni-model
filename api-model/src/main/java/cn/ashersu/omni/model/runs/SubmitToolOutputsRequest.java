package cn.ashersu.omni.model.runs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @description 
 * @author  vacuity
 * @create  2023-11-16 22:45
 **/

public class SubmitToolOutputsRequest {
    
    @JsonProperty("tool_outputs")
    private List<SubmitToolOutputRequestItem> toolOutputs;
    
    public SubmitToolOutputsRequest() {
    }
    
    public SubmitToolOutputsRequest(List<SubmitToolOutputRequestItem> toolOutputs) {
        this.toolOutputs = toolOutputs;
    }
    
    public List<SubmitToolOutputRequestItem> getToolOutputs() {
        return toolOutputs;
    }
    
    public void setToolOutputs(List<SubmitToolOutputRequestItem> toolOutputs) {
        this.toolOutputs = toolOutputs;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private List<SubmitToolOutputRequestItem> toolOutputs;
        
        public Builder toolOutputs(List<SubmitToolOutputRequestItem> toolOutputs) {
            this.toolOutputs = toolOutputs;
            return this;
        }
        
        public SubmitToolOutputsRequest build() {
            return new SubmitToolOutputsRequest(toolOutputs);
        }
    }
}
