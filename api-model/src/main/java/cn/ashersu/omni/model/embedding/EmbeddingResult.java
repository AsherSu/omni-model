package cn.ashersu.omni.model.embedding;

import cn.ashersu.omni.model.Usage;

import java.util.List;

/**
 * An object containing a response from the answer api
 *
 * https://beta.openai.com/docs/api-reference/embeddings/create
 */
public class EmbeddingResult {

    /**
     * The GPTmodel used for generating embeddings
     */
    private String model;

    /**
     * The type of object returned, should be "list"
     */
    private String object;

    /**
     * A list of the calculated embeddings
     */
    private List<Embedding> data;

    /**
     * The API usage for this request
     */
    private Usage usage;
    
    public EmbeddingResult() {
    }
    
    public EmbeddingResult(String model, String object, List<Embedding> data, Usage usage) {
        this.model = model;
        this.object = object;
        this.data = data;
        this.usage = usage;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getObject() {
        return object;
    }
    
    public void setObject(String object) {
        this.object = object;
    }
    
    public List<Embedding> getData() {
        return data;
    }
    
    public void setData(List<Embedding> data) {
        this.data = data;
    }
    
    public Usage getUsage() {
        return usage;
    }
    
    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}
