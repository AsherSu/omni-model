package cn.ashersu.omni.model.completion;

import java.util.List;

/**
 * Object containing a response chunk from the completions streaming api.
 *
 * https://beta.openai.com/docs/api-reference/completions/create
 */
public class CompletionChunk {
    /**
     * A unique id assigned to this completion.
     */
    private String id;

    /**https://beta.openai.com/docs/api-reference/create-completion
     * The type of object returned, should be "text_completion"
     */
    private String object;

    /**
     * The creation time in epoch seconds.
     */
    private long created;

    /**
     * The model used.
     */
    private String model;

    /**
     * A list of generated completions.
     */
    private List<CompletionChoice> choices;
    
    public CompletionChunk() {
    }
    
    public CompletionChunk(String id, String object, long created, String model, List<CompletionChoice> choices) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
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
    
    public long getCreated() {
        return created;
    }
    
    public void setCreated(long created) {
        this.created = created;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public List<CompletionChoice> getChoices() {
        return choices;
    }
    
    public void setChoices(List<CompletionChoice> choices) {
        this.choices = choices;
    }
}
