package cn.ashersu.omni.model.file;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A file uploaded to OpenAi
 *
 * https://beta.openai.com/docs/api-reference/files
 */
public class File {

    /**
     * The unique id of this file.
     */
    private String id;

    /**
     * The type of object returned, should be "file".
     */
    private String object;

    /**
     * File size in bytes.
     */
    private Long bytes;

    /**
     * The creation time in epoch seconds.
     */
    @JsonProperty("created_at")
    private Long createdAt;

    /**
     * The name of the file.
     */
    private String filename;

    /**
     * Description of the file's purpose.
     */
    private String purpose;

    /**
     * The current status of the file, which can be either uploaded, processed, pending, error, deleting or deleted.
     */
    private String status;

    /**
     * Additional details about the status of the file.
     * If the file is in the error state, this will include a message describing the error.
     */
    @JsonProperty("status_details")
    private String statusDetails;
    
    public File() {
    }
    
    public File(String id, String object, Long bytes, Long createdAt, String filename, 
              String purpose, String status, String statusDetails) {
        this.id = id;
        this.object = object;
        this.bytes = bytes;
        this.createdAt = createdAt;
        this.filename = filename;
        this.purpose = purpose;
        this.status = status;
        this.statusDetails = statusDetails;
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
    
    public Long getBytes() {
        return bytes;
    }
    
    public void setBytes(Long bytes) {
        this.bytes = bytes;
    }
    
    public Long getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getFilename() {
        return filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public String getPurpose() {
        return purpose;
    }
    
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatusDetails() {
        return statusDetails;
    }
    
    public void setStatusDetails(String statusDetails) {
        this.statusDetails = statusDetails;
    }
}
