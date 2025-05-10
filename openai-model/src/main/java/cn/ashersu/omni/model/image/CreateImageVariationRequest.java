package cn.ashersu.omni.model.image;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A request for OpenAi to create a variation of an image
 * All fields are optional
 *
 * https://beta.openai.com/docs/api-reference/images/create-variation
 */
public class CreateImageVariationRequest {

    /**
     * The number of images to generate. Must be between 1 and 10. Defaults to 1.
     */
    private Integer n;

    /**
     * The model to use for image generation. Only dall-e-2 is supported at this time. Defaults to dall-e-2.
     */
    private String model;

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
    
    public CreateImageVariationRequest() {
    }
    
    public CreateImageVariationRequest(Integer n, String model, String size, String responseFormat, String user) {
        this.n = n;
        this.model = model;
        this.size = size;
        this.responseFormat = responseFormat;
        this.user = user;
    }
    
    public Integer getN() {
        return n;
    }
    
    public void setN(Integer n) {
        this.n = n;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
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
        private Integer n;
        private String model;
        private String size;
        private String responseFormat;
        private String user;
        
        public Builder n(Integer n) {
            this.n = n;
            return this;
        }
        
        public Builder model(String model) {
            this.model = model;
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
        
        public CreateImageVariationRequest build() {
            return new CreateImageVariationRequest(n, model, size, responseFormat, user);
        }
    }
}
