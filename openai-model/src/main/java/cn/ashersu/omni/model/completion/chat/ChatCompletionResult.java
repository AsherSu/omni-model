package cn.ashersu.omni.model.completion.chat;
import cn.ashersu.omni.model.Usage;

import java.util.List;

/**
 * Object containing a response from the chat completions api.
 */
public class ChatCompletionResult {

    /**
     * Unique id assigned to this chat completion.
     */
    private String id;

    /**
     * The type of object returned, should be "chat.completion"
     */
    private String object;

    /**
     * The creation time in epoch seconds.
     */
    private long created;
    
    /**
     * The GPT model used.
     */
    private String model;

    /**
     * A list of all generated completions.
     */
    private List<ChatCompletionChoice> choices;

    /**
     * The API usage for this request.
     */
    private Usage usage;
    
    public ChatCompletionResult() {
    }
    
    public ChatCompletionResult(String id, String object, long created, String model, 
                              List<ChatCompletionChoice> choices, Usage usage) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
        this.usage = usage;
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
    
    public List<ChatCompletionChoice> getChoices() {
        return choices;
    }
    
    public void setChoices(List<ChatCompletionChoice> choices) {
        this.choices = choices;
    }
    
    public Usage getUsage() {
        return usage;
    }
    
    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
