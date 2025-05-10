package cn.ashersu.omni.model.audio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A request for OpenAi to create English translation based on an audio file
 * All fields except model are optional
 *
 * https://platform.openai.com/docs/api-reference/audio/create
 */
public class CreateTranslationRequest {

    /**
     * The name of the model to use.
     */
    private String model;

    /**
     * An optional text to guide the model's style or continue a previous audio segment. The prompt should be in English.
     */
    private String prompt;

    /**
     * The format of the translated output, in one of these options: json or verbose_json
     */
    @JsonProperty("response_format")
    private String responseFormat;

    /**
     * The sampling temperature, between 0 and 1.
     * Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic.
     * If set to 0, the model will use log probability to automatically increase the temperature until certain thresholds are hit.
     */
    private Double temperature;
    
    public CreateTranslationRequest() {
    }
    
    public CreateTranslationRequest(String model, String prompt, String responseFormat, Double temperature) {
        this.model = Objects.requireNonNull(model, "model cannot be null");
        this.prompt = prompt;
        this.responseFormat = responseFormat;
        this.temperature = temperature;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = Objects.requireNonNull(model, "model cannot be null");
    }
    
    public String getPrompt() {
        return prompt;
    }
    
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    
    public String getResponseFormat() {
        return responseFormat;
    }
    
    public void setResponseFormat(String responseFormat) {
        this.responseFormat = responseFormat;
    }
    
    public Double getTemperature() {
        return temperature;
    }
    
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String model;
        private String prompt;
        private String responseFormat;
        private Double temperature;
        
        public Builder model(String model) {
            this.model = Objects.requireNonNull(model, "model cannot be null");
            return this;
        }
        
        public Builder prompt(String prompt) {
            this.prompt = prompt;
            return this;
        }
        
        public Builder responseFormat(String responseFormat) {
            this.responseFormat = responseFormat;
            return this;
        }
        
        public Builder temperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }
        
        public CreateTranslationRequest build() {
            return new CreateTranslationRequest(model, prompt, responseFormat, temperature);
        }
    }
}
