package cn.ashersu.omni.model.moderation;

import java.util.Objects;

/**
 * A request for OpenAi to detect if text violates OpenAi's content policy.
 *
 * https://beta.openai.com/docs/api-reference/moderations/create
 */
public class ModerationRequest {

    /**
     * The input text to classify.
     */
    private String input;

    /**
     * The name of the model to use, defaults to text-moderation-stable.
     */
    private String model;
    
    public ModerationRequest() {
    }
    
    public ModerationRequest(String input, String model) {
        this.input = Objects.requireNonNull(input, "input cannot be null");
        this.model = model;
    }
    
    public String getInput() {
        return input;
    }
    
    public void setInput(String input) {
        this.input = Objects.requireNonNull(input, "input cannot be null");
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String input;
        private String model;
        
        public Builder input(String input) {
            this.input = Objects.requireNonNull(input, "input cannot be null");
            return this;
        }
        
        public Builder model(String model) {
            this.model = model;
            return this;
        }
        
        public ModerationRequest build() {
            return new ModerationRequest(input, model);
        }
    }
}
