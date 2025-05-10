package cn.ashersu.omni.model.runs;

import cn.ashersu.omni.model.assistants.Tool;
import cn.ashersu.omni.model.threads.ThreadRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * @description 
 * @author  vacuity
 * @create  2023-11-16 23:08
 **/

public class CreateThreadAndRunRequest {
    
    @JsonProperty("assistant_id")
    private String assistantId;
    
    private ThreadRequest thread;

    private String model;
    
    private String instructions;

    private List<Tool> tools;

    private Map<String, String> metadata;
    
    public CreateThreadAndRunRequest() {
    }
    
    public CreateThreadAndRunRequest(String assistantId, ThreadRequest thread, String model, 
                                    String instructions, List<Tool> tools, Map<String, String> metadata) {
        this.assistantId = assistantId;
        this.thread = thread;
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
    
    public ThreadRequest getThread() {
        return thread;
    }
    
    public void setThread(ThreadRequest thread) {
        this.thread = thread;
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
        private ThreadRequest thread;
        private String model;
        private String instructions;
        private List<Tool> tools;
        private Map<String, String> metadata;
        
        public Builder assistantId(String assistantId) {
            this.assistantId = assistantId;
            return this;
        }
        
        public Builder thread(ThreadRequest thread) {
            this.thread = thread;
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
        
        public CreateThreadAndRunRequest build() {
            return new CreateThreadAndRunRequest(assistantId, thread, model, instructions, tools, metadata);
        }
    }
}
