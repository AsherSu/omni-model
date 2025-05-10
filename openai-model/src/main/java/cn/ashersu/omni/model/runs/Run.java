package cn.ashersu.omni.model.runs;

import cn.ashersu.omni.model.assistants.Tool;
import cn.ashersu.omni.model.common.LastError;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class Run {

    private String id;

    private String object;

    @JsonProperty("created_at")
    private Integer createdAt;

    @JsonProperty("thread_id")
    private String threadId;

    @JsonProperty("assistant_id")
    private String assistantId;

    private String status;

    @JsonProperty("required_action")
    private RequiredAction requiredAction;

    @JsonProperty("last_error")
    private LastError lastError;

    @JsonProperty("expires_at")
    private Integer expiresAt;

    @JsonProperty("started_at")
    private Integer startedAt;
    
    @JsonProperty("cancelled_at")
    private Integer cancelledAt;

    @JsonProperty("failed_at")
    private Integer failedAt;
    
    @JsonProperty("completed_at")
    private Integer completedAt;

    private String model;

    private String instructions;

    private List<Tool> tools;
    
    @JsonProperty("file_ids")
    private List<String> fileIds;

    private Map<String, String> metadata;
    
    public Run() {
    }
    
    public Run(String id, String object, Integer createdAt, String threadId, String assistantId, 
               String status, RequiredAction requiredAction, LastError lastError, Integer expiresAt, 
               Integer startedAt, Integer cancelledAt, Integer failedAt, Integer completedAt, 
               String model, String instructions, List<Tool> tools, List<String> fileIds, 
               Map<String, String> metadata) {
        this.id = id;
        this.object = object;
        this.createdAt = createdAt;
        this.threadId = threadId;
        this.assistantId = assistantId;
        this.status = status;
        this.requiredAction = requiredAction;
        this.lastError = lastError;
        this.expiresAt = expiresAt;
        this.startedAt = startedAt;
        this.cancelledAt = cancelledAt;
        this.failedAt = failedAt;
        this.completedAt = completedAt;
        this.model = model;
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
    
    public String getThreadId() {
        return threadId;
    }
    
    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }
    
    public String getAssistantId() {
        return assistantId;
    }
    
    public void setAssistantId(String assistantId) {
        this.assistantId = assistantId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public RequiredAction getRequiredAction() {
        return requiredAction;
    }
    
    public void setRequiredAction(RequiredAction requiredAction) {
        this.requiredAction = requiredAction;
    }
    
    public LastError getLastError() {
        return lastError;
    }
    
    public void setLastError(LastError lastError) {
        this.lastError = lastError;
    }
    
    public Integer getExpiresAt() {
        return expiresAt;
    }
    
    public void setExpiresAt(Integer expiresAt) {
        this.expiresAt = expiresAt;
    }
    
    public Integer getStartedAt() {
        return startedAt;
    }
    
    public void setStartedAt(Integer startedAt) {
        this.startedAt = startedAt;
    }
    
    public Integer getCancelledAt() {
        return cancelledAt;
    }
    
    public void setCancelledAt(Integer cancelledAt) {
        this.cancelledAt = cancelledAt;
    }
    
    public Integer getFailedAt() {
        return failedAt;
    }
    
    public void setFailedAt(Integer failedAt) {
        this.failedAt = failedAt;
    }
    
    public Integer getCompletedAt() {
        return completedAt;
    }
    
    public void setCompletedAt(Integer completedAt) {
        this.completedAt = completedAt;
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
        private String threadId;
        private String assistantId;
        private String status;
        private RequiredAction requiredAction;
        private LastError lastError;
        private Integer expiresAt;
        private Integer startedAt;
        private Integer cancelledAt;
        private Integer failedAt;
        private Integer completedAt;
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
        
        public Builder threadId(String threadId) {
            this.threadId = threadId;
            return this;
        }
        
        public Builder assistantId(String assistantId) {
            this.assistantId = assistantId;
            return this;
        }
        
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        
        public Builder requiredAction(RequiredAction requiredAction) {
            this.requiredAction = requiredAction;
            return this;
        }
        
        public Builder lastError(LastError lastError) {
            this.lastError = lastError;
            return this;
        }
        
        public Builder expiresAt(Integer expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }
        
        public Builder startedAt(Integer startedAt) {
            this.startedAt = startedAt;
            return this;
        }
        
        public Builder cancelledAt(Integer cancelledAt) {
            this.cancelledAt = cancelledAt;
            return this;
        }
        
        public Builder failedAt(Integer failedAt) {
            this.failedAt = failedAt;
            return this;
        }
        
        public Builder completedAt(Integer completedAt) {
            this.completedAt = completedAt;
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
        
        public Builder fileIds(List<String> fileIds) {
            this.fileIds = fileIds;
            return this;
        }
        
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }
        
        public Run build() {
            return new Run(id, object, createdAt, threadId, assistantId, status, requiredAction, 
                          lastError, expiresAt, startedAt, cancelledAt, failedAt, completedAt, 
                          model, instructions, tools, fileIds, metadata);
        }
    }
}
