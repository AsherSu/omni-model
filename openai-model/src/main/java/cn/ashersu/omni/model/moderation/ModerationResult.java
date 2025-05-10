package cn.ashersu.omni.model.moderation;

import java.util.List;

/**
 * An object containing a response from the moderation api
 *
 * https://beta.openai.com/docs/api-reference/moderations/create
 */
public class ModerationResult {
    /**
     * A unique id assigned to this moderation.
     */
    private String id;

    /**
     * The model used.
     */
    private String model;

    /**
     * A list of moderation scores.
     */
    private List<Moderation> results;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public List<Moderation> getResults() {
        return results;
    }
    
    public void setResults(List<Moderation> results) {
        this.results = results;
    }
}
