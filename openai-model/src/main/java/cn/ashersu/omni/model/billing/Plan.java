package cn.ashersu.omni.model.billing;

/**
 *
 *
 */
public class Plan {
    private String title;
    private String id;
    
    public Plan() {
    }
    
    public Plan(String title, String id) {
        this.title = title;
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
}
