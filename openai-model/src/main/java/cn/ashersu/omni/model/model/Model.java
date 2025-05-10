package cn.ashersu.omni.model.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * GPT model details
 *
 * https://beta.openai.com/docs/api-reference/models
 */
public class Model {
    /**
     * An identifier for this model, used to specify the model when making completions, etc
     */
    private String id;

    /**
     * The type of object returned, should be "model"
     */
    private String object;

    /**
     * The owner of the model, typically "openai"
     */
    @JsonProperty("owned_by")
    private String ownedBy;

    /**
     * List of permissions for this model. No longer returned by OpenAI
     */
    @Deprecated
    private List<Permission> permission;

    /**
     * The root model that this and its parent (if applicable) are based on
     */
    private String root;

    /**
     * The parent model that this is based on
     */
    private String parent;
    
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
    
    public String getOwnedBy() {
        return ownedBy;
    }
    
    public void setOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
    }
    
    public List<Permission> getPermission() {
        return permission;
    }
    
    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }
    
    public String getRoot() {
        return root;
    }
    
    public void setRoot(String root) {
        this.root = root;
    }
    
    public String getParent() {
        return parent;
    }
    
    public void setParent(String parent) {
        this.parent = parent;
    }
}
