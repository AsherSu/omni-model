package cn.ashersu.omni.model.runs;

import cn.ashersu.omni.model.common.LastError;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RunStep {

    private String id;

    private String object;

    @JsonProperty("created_at")
    private Integer createdAt;
    
    @JsonProperty("assistant_id")
    private String assistantId;

    @JsonProperty("thread_id")
    private String threadId;

    @JsonProperty("run_id")
    private String runId;

    private String type;
    
    private String status;

    @JsonProperty("step_details")
    private StepDetails stepDetails;

    @JsonProperty("last_error")
    private LastError lastError;

    @JsonProperty("expired_at")
    private Integer expiredAt;
    
    @JsonProperty("cancelled_at")
    private Integer cancelledAt;

    @JsonProperty("failed_at")
    private Integer failedAt;
    
    @JsonProperty("completed_at")
    private Integer completedAt;
    
    private Map<String, String> metadata;
    
    public RunStep() {
    }
    
    public RunStep(String id, String object, Integer createdAt, String assistantId, String threadId, 
                  String runId, String type, String status, StepDetails stepDetails, LastError lastError, 
                  Integer expiredAt, Integer cancelledAt, Integer failedAt, Integer completedAt, 
                  Map<String, String> metadata) {
        this.id = id;
        this.object = object;
        this.createdAt = createdAt;
        this.assistantId = assistantId;
        this.threadId = threadId;
        this.runId = runId;
        this.type = type;
        this.status = status;
        this.stepDetails = stepDetails;
        this.lastError = lastError;
        this.expiredAt = expiredAt;
        this.cancelledAt = cancelledAt;
        this.failedAt = failedAt;
        this.completedAt = completedAt;
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
    
    public String getAssistantId() {
        return assistantId;
    }
    
    public void setAssistantId(String assistantId) {
        this.assistantId = assistantId;
    }
    
    public String getThreadId() {
        return threadId;
    }
    
    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }
    
    public String getRunId() {
        return runId;
    }
    
    public void setRunId(String runId) {
        this.runId = runId;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public StepDetails getStepDetails() {
        return stepDetails;
    }
    
    public void setStepDetails(StepDetails stepDetails) {
        this.stepDetails = stepDetails;
    }
    
    public LastError getLastError() {
        return lastError;
    }
    
    public void setLastError(LastError lastError) {
        this.lastError = lastError;
    }
    
    public Integer getExpiredAt() {
        return expiredAt;
    }
    
    public void setExpiredAt(Integer expiredAt) {
        this.expiredAt = expiredAt;
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
        private String assistantId;
        private String threadId;
        private String runId;
        private String type;
        private String status;
        private StepDetails stepDetails;
        private LastError lastError;
        private Integer expiredAt;
        private Integer cancelledAt;
        private Integer failedAt;
        private Integer completedAt;
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
        
        public Builder assistantId(String assistantId) {
            this.assistantId = assistantId;
            return this;
        }
        
        public Builder threadId(String threadId) {
            this.threadId = threadId;
            return this;
        }
        
        public Builder runId(String runId) {
            this.runId = runId;
            return this;
        }
        
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        
        public Builder stepDetails(StepDetails stepDetails) {
            this.stepDetails = stepDetails;
            return this;
        }
        
        public Builder lastError(LastError lastError) {
            this.lastError = lastError;
            return this;
        }
        
        public Builder expiredAt(Integer expiredAt) {
            this.expiredAt = expiredAt;
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
        
        public Builder metadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }
        
        public RunStep build() {
            return new RunStep(id, object, createdAt, assistantId, threadId, runId, type, status, 
                             stepDetails, lastError, expiredAt, cancelledAt, failedAt, completedAt, metadata);
        }
    }
}
