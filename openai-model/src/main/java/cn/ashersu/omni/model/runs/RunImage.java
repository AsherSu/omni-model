package cn.ashersu.omni.model.runs;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @description 
 * @author  vacuity
 * @create  2023-11-16 22:33
 **/

public class RunImage {

    @JsonProperty("file_id")
    private String fileId;
    
    public RunImage() {
    }
    
    public RunImage(String fileId) {
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
        
        public RunImage build() {
            return new RunImage(fileId);
        }
    }
}
