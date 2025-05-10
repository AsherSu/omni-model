package cn.ashersu.omni.model.runs;

import cn.ashersu.omni.model.assistants.Tool;

import java.util.List;
import java.util.Map;

public class RunCreateRequest {
    private String assistantId;

    // Optional
    private String model;
    
    private String instructions;
    
    private List<Tool> tools;
    
    private Map<String, String> metadata;
    
    public RunCreateRequest() {
    }
    
    public RunCreateRequest(String assistantId, String model, String instructions, List<Tool> tools, Map<String, String> metadata) {
        this.assistantId = assistantId;
        this.model = model;
        this.instructions = instructions;
        this.tools = tools;
        this.metadata = metadata;
    }
    
    public String getAssistantId() {
        return assistantId;
    }
    
    public void setAssistantId(String assistantId) {
        this.assistantId = assistantId;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getInstructions() {
        return instructions;
    }
    
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    
    public List<Tool> getTools() {
        return tools;
    }
    
    public void setTools(List<Tool> tools) {
        this.tools = tools;
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
        private String assistantId;
        private String model;
        private String instructions;
        private List<Tool> tools;
        private Map<String, String> metadata;
        
        public Builder assistantId(String assistantId) {
            this.assistantId = assistantId;
            return this;
        }
        
        public Builder model(String model) {
            this.model = model;
            return this;
        }
        
        public Builder instructions(String instructions) {
            this.instructions = instructions;
            return this;
        }
        
        public Builder tools(List<Tool> tools) {
            this.tools = tools;
            return this;
        }
        
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }
        
        public RunCreateRequest build() {
            return new RunCreateRequest(assistantId, model, instructions, tools, metadata);
        }
    }
}
