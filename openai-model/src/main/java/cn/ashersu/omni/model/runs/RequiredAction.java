package cn.ashersu.omni.model.runs;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @description 
 * @author  vacuity
 * @create  2023-11-16 22:44
 **/

public class RequiredAction {
    
    private String type;

    @JsonProperty("submit_tool_outputs")
    private SubmitToolOutputs submitToolOutputs;
    
    public RequiredAction() {
    }
    
    public RequiredAction(String type, SubmitToolOutputs submitToolOutputs) {
        this.type = type;
        this.submitToolOutputs = submitToolOutputs;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public SubmitToolOutputs getSubmitToolOutputs() {
        return submitToolOutputs;
    }
    
    public void setSubmitToolOutputs(SubmitToolOutputs submitToolOutputs) {
        this.submitToolOutputs = submitToolOutputs;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String type;
        private SubmitToolOutputs submitToolOutputs;
        
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        
        public Builder submitToolOutputs(SubmitToolOutputs submitToolOutputs) {
            this.submitToolOutputs = submitToolOutputs;
            return this;
        }
        
        public RequiredAction build() {
            return new RequiredAction(type, submitToolOutputs);
        }
    }
}
