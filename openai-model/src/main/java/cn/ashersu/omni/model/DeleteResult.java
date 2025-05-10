package cn.ashersu.omni.model;

/**
 * A response when deleting an object
 */
public class DeleteResult {
    /**
     * The id of the object.
     */
    private String id;

    /**
     * The type of object deleted, for example "file" or "model"
     */
    private String object;

    /**
     * True if successfully deleted
     */
    private boolean deleted;
    
    public DeleteResult() {
    }
    
    public DeleteResult(String id, String object, boolean deleted) {
        this.id = id;
        this.object = object;
        this.deleted = deleted;
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
    
    public boolean isDeleted() {
        return deleted;
    }
    
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
