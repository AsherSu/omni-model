package cn.ashersu.omni.model.assistants;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssistantFile {

    /**
     * The identifier of the Assistant File
     */
    private String id;

    /**
     * The object type, which is always assistant.file.
     */
    private String object;

    /**
     * The Unix timestamp (in seconds) for when the assistant file was created.
     */
    @JsonProperty("created_at")
    private String createdAt;

    /**
     * The assistant ID that the file is attached to
     */
    @JsonProperty("assistant_id")
    private String assistantId;
    
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
    
    public String getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getAssistantId() {
        return assistantId;
    }
    
    public void setAssistantId(String assistantId) {
        this.assistantId = assistantId;
    }
}
