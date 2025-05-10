package cn.ashersu.omni.model.embedding;

import java.util.List;
import java.util.Objects;

/**
 * Creates an embedding vector representing the input text.
 *
 * https://beta.openai.com/docs/api-reference/embeddings/create
 */
public class EmbeddingRequest {

    /**
     * The name of the model to use.
     * Required if using the new v1/embeddings endpoint.
     */
    private String model;

    /**
     * Input text to get embeddings for, encoded as a string or array of tokens.
     * To get embeddings for multiple inputs in a single request, pass an array of strings or array of token arrays.
     * Each input must not exceed 2048 tokens in length.
     * <p>
     * Unless you are embedding code, we suggest replacing newlines (\n) in your input with a single space,
     * as we have observed inferior results when newlines are present.
     */
    private List<String> input;

    /**
     * A unique identifier representing your end-user, which will help OpenAI to monitor and detect abuse.
     */
    private String user;
    
    public EmbeddingRequest() {
    }
    
    public EmbeddingRequest(String model, List<String> input, String user) {
        this.model = model;
        this.input = Objects.requireNonNull(input, "input cannot be null");
        this.user = user;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public List<String> getInput() {
        return input;
    }
    
    public void setInput(List<String> input) {
        this.input = Objects.requireNonNull(input, "input cannot be null");
    }
    
    public String getUser() {
        return user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String model;
        private List<String> input;
        private String user;
        
        public Builder model(String model) {
            this.model = model;
            return this;
        }
        
        public Builder input(List<String> input) {
            this.input = Objects.requireNonNull(input, "input cannot be null");
            return this;
        }
        
        public Builder user(String user) {
            this.user = user;
            return this;
        }
        
        public EmbeddingRequest build() {
            return new EmbeddingRequest(model, input, user);
        }
    }
}
