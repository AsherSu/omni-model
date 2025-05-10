package cn.ashersu.omni.model.image;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A request for OpenAi to create an image based on a prompt
 * All fields except prompt are optional
 *
 * https://beta.openai.com/docs/api-reference/images/create
 */
public class CreateImageRequest {

    /**
     * A text description of the desired image(s). The maximum length is 1000 characters for dall-e-2 and 4000 characters for dall-e-3.
     */
    private String prompt;

    /**
     * The model to use for image generation. Defaults to "dall-e-2".
     */
    private String model;

    /**
     * The number of images to generate. Must be between 1 and 10. For dall-e-3, only n=1 is supported. Defaults to 1.
     */
    private Integer n;

    /**
     * The quality of the image that will be generated. "hd" creates images with finer details and greater consistency across the image. This param is only supported for dall-e-3. Defaults to "standard".
     */
    private String quality;

    /**
     * The size of the generated images. Must be one of 256x256, 512x512, or 1024x1024 for dall-e-2. Must be one of 1024x1024, 1792x1024, or 1024x1792 for dall-e-3 models. Defaults to 1024x1024.
     */
    private String size;

    /**
     * The format in which the generated images are returned. Must be one of url or b64_json. Defaults to url.
     */
    @JsonProperty("response_format")
    private String responseFormat;

    /**
     * The style of the generated images. Must be one of vivid or natural. Vivid causes the model to lean towards generating hyper-real and dramatic images. Natural causes the model to produce more natural, less hyper-real looking images. This param is only supported for dall-e-3. Defaults to vivid.
     */
    private String style;

    /**
     * A unique identifier representing your end-user, which will help OpenAI to monitor and detect abuse.
     */
    private String user;
    
    public CreateImageRequest() {
    }
    
    public CreateImageRequest(String prompt, String model, Integer n, String quality, String size, 
                             String responseFormat, String style, String user) {
        this.prompt = Objects.requireNonNull(prompt, "prompt cannot be null");
        this.model = model;
        this.n = n;
        this.quality = quality;
        this.size = size;
        this.responseFormat = responseFormat;
        this.style = style;
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
    
    public String getQuality() {
        return quality;
    }
    
    public void setQuality(String quality) {
        this.quality = quality;
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
    
    public String getStyle() {
        return style;
    }
    
    public void setStyle(String style) {
        this.style = style;
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
        private String quality;
        private String size;
        private String responseFormat;
        private String style;
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
        
        public Builder quality(String quality) {
            this.quality = quality;
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
        
        public Builder style(String style) {
            this.style = style;
            return this;
        }
        
        public Builder user(String user) {
            this.user = user;
            return this;
        }
        
        public CreateImageRequest build() {
            return new CreateImageRequest(prompt, model, n, quality, size, responseFormat, style, user);
        }
    }
}
