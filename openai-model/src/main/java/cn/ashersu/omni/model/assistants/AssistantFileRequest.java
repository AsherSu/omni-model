package cn.ashersu.omni.model.assistants;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssistantFileRequest {

    @JsonProperty("file_id")
    private String fileId;
    
    public AssistantFileRequest() {
    }
    
    public AssistantFileRequest(String fileId) {
        this.fileId = fileId;
    }
    
    public String getFileId() {
        return fileId;
    }
    
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String fileId;
        
        public Builder fileId(String fileId) {
            this.fileId = fileId;
            return this;
        }
        
        public AssistantFileRequest build() {
            return new AssistantFileRequest(fileId);
        }
    }
}
