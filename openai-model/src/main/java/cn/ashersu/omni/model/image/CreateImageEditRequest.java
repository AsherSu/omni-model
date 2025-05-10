package cn.ashersu.omni.model.image;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A request for OpenAi to edit an image based on a prompt
 * All fields except prompt are optional
 *
 * https://beta.openai.com/docs/api-reference/images/create-edit
 */
public class CreateImageEditRequest {

    /**
     * A text description of the desired image(s). The maximum length in 1000 characters.
     */
    private String prompt;

    /**
     * The model to use for image generation. Only dall-e-2 is supported at this time. Defaults to dall-e-2.
     */
    private String model;

    /**
     * The number of images to generate. Must be between 1 and 10. Defaults to 1.
     */
    private Integer n;

    /**
     * The size of the generated images. Must be one of "256x256", "512x512", or "1024x1024". Defaults to "1024x1024".
     */
    private String size;

    /**
     * The format in which the generated images are returned. Must be one of url or b64_json. Defaults to url.
     */
    @JsonProperty("response_format")
    private String responseFormat;

    /**
     * A unique identifier representing your end-user, which will help OpenAI to monitor and detect abuse.
     */
    private String user;
    
    public CreateImageEditRequest() {
    }
    
    public CreateImageEditRequest(String prompt, String model, Integer n, String size, String responseFormat, String user) {
        this.prompt = Objects.requireNonNull(prompt, "prompt cannot be null");
        this.model = model;
        this.n = n;
        this.size = size;
        this.responseFormat = responseFormat;
        this.user = user;
    }
    
    public String getPrompt() {
        return prompt;
    }
    
    public void setPrompt(String prompt) {
        this.prompt = Objects.requireNonNull(prompt, "prompt cannot be null");
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public Integer getN() {
        return n;
    }
    
    public void setN(Integer n) {
        this.n = n;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public String getResponseFormat() {
        return responseFormat;
    }
    
    public void setResponseFormat(String responseFormat) {
        this.responseFormat = responseFormat;
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
        private String prompt;
        private String model;
        private Integer n;
        private String size;
        private String responseFormat;
        private String user;
        
        public Builder prompt(String prompt) {
            this.prompt = Objects.requireNonNull(prompt, "prompt cannot be null");
            return this;
        }
        
        public Builder model(String model) {
            this.model = model;
            return this;
        }
        
        public Builder n(Integer n) {
            this.n = n;
            return this;
        }
        
        public Builder size(String size) {
            this.size = size;
            return this;
        }
        
        public Builder responseFormat(String responseFormat) {
            this.responseFormat = responseFormat;
            return this;
        }
        
        public Builder user(String user) {
            this.user = user;
            return this;
        }
        
        public CreateImageEditRequest build() {
            return new CreateImageEditRequest(prompt, model, n, size, responseFormat, user);
        }
    }
}
