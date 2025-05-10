package cn.ashersu.omni.model.assistants;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Assistant {

    /**
     * The identifier, which can be referenced in API endpoints.
     */
    private String id;

    /**
     * The object type which is always 'assistant'
     */
    private String object;

    /**
     * The Unix timestamp(in seconds) for when the assistant was created
     */
    @JsonProperty("created_at")
    private Integer createdAt;

    /**
     * The name of the assistant. The maximum length is 256
     */
    private String name;

    /**
     * The description of the assistant.
     */
    private String description;

    /**
     * ID of the model to use
     */
    private String model;

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
    
    public Assistant() {
    }
    
    public Assistant(String id, String object, Integer createdAt, String name, String description, 
                     String model, String instructions, List<Tool> tools, List<String> fileIds, 
                     Map<String, String> metadata) {
        this.id = id;
        this.object = object;
        this.createdAt = createdAt;
        this.name = name;
        this.description = description;
        this.model = Objects.requireNonNull(model, "model cannot be null");
        this.instructions = instructions;
        this.tools = tools;
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
    
    public Integer getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
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
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = Objects.requireNonNull(model, "model cannot be null");
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
        private String id;
        private String object;
        private Integer createdAt;
        private String name;
        private String description;
        private String model;
        private String instructions;
        private List<Tool> tools;
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
        
        public Builder createdAt(Integer createdAt) {
            this.createdAt = createdAt;
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
        
        public Builder model(String model) {
            this.model = Objects.requireNonNull(model, "model cannot be null");
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
        
        public Assistant build() {
            return new Assistant(id, object, createdAt, name, description, model, 
                      instructions, tools, fileIds, metadata);
        }
    }
}
