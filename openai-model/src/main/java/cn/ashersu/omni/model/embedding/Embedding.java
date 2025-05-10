package cn.ashersu.omni.model.embedding;

import java.util.List;

/**
 * Represents an embedding returned by the embedding api
 *
 * https://beta.openai.com/docs/api-reference/classifications/create
 */
public class Embedding {

    /**
     * The type of object returned, should be "embedding"
     */
    private String object;

    /**
     * The embedding vector
     */
    private List<Double> embedding;

    /**
     * The position of this embedding in the list
     */
    private Integer index;
    
    public Embedding() {
    }
    
    public Embedding(String object, List<Double> embedding, Integer index) {
        this.object = object;
        this.embedding = embedding;
        this.index = index;
    }
    
    public String getObject() {
        return object;
    }
    
    public void setObject(String object) {
        this.object = object;
    }
    
    public List<Double> getEmbedding() {
        return embedding;
    }
    
    public void setEmbedding(List<Double> embedding) {
        this.embedding = embedding;
    }
    
    public Integer getIndex() {
        return index;
    }
    
    public void setIndex(Integer index) {
        this.index = index;
    }
}
