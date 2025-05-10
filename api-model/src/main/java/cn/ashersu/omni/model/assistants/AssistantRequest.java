package cn.ashersu.omni.model.assistants;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AssistantRequest {

    /**
     * ID of the model to use
     */
    private String model;

    /**
     * The name of the assistant. The maximum length is 256
     */
    private String name;

    /**
     * The description of the assistant.
     */
    private String description;

    /**
     * The system instructions that the assistant uses.
     */
    private String instructions;

    /**
     * A list of tools enabled on the assistant.
     */
    private List<Tool> tools;

    /**
     * A list of file IDs attached to this assistant.
     */
    @JsonProperty("file_ids")
    private List<String> fileIds;

    /**
     * Set of 16 key-value pairs that can be attached to an object.
     */
    private Map<String, String> metadata;
    
    public AssistantRequest() {
    }
    
    public AssistantRequest(String model, String name, String description, String instructions, 
                           List<Tool> tools, List<String> fileIds, Map<String, String> metadata) {
        this.model = Objects.requireNonNull(model, "model cannot be null");
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.tools = tools;
        this.fileIds = fileIds;
        this.metadata = metadata;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = Objects.requireNonNull(model, "model cannot be null");
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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
        private String model;
        private String name;
        private String description;
        private String instructions;
        private List<Tool> tools;
        private List<String> fileIds;
        private Map<String, String> metadata;
        
        public Builder model(String model) {
            this.model = Objects.requireNonNull(model, "model cannot be null");
            return this;
        }
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public Builder description(String description) {
            this.description = description;
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
        
        public Builder fileIds(List<String> fileIds) {
            this.fileIds = fileIds;
            return this;
        }
        
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }
        
        public AssistantRequest build() {
            return new AssistantRequest(model, name, description, instructions, tools, fileIds, metadata);
        }
    }
}
