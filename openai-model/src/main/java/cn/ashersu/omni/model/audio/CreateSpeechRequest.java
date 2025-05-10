package cn.ashersu.omni.model.audio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Request for creating speech from text
 */
public class CreateSpeechRequest {

    /**
     * The name of the model to use.
     */
    private String model;

    /**
     * The text to generate audio for. The maximum length is 4096 characters.
     */
    private String input;

    /**
     * The voice to use when generating the audio.
     */
    private String voice;

    /**
     * The format to audio in. Supported formats are mp3, opus, aac, and flac. Defaults to mp3.
     */
    @JsonProperty("response_format")
    private String responseFormat;

    /**
     * The speed of the generated audio. Select a value from 0.25 to 4.0. Defaults to 1.0.
     */
    private Double speed;
    
    public CreateSpeechRequest() {
    }
    
    public CreateSpeechRequest(String model, String input, String voice, String responseFormat, Double speed) {
        this.model = Objects.requireNonNull(model, "model cannot be null");
        this.input = Objects.requireNonNull(input, "input cannot be null");
        this.voice = Objects.requireNonNull(voice, "voice cannot be null");
        this.responseFormat = responseFormat;
        this.speed = speed;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = Objects.requireNonNull(model, "model cannot be null");
    }
    
    public String getInput() {
        return input;
    }
    
    public void setInput(String input) {
        this.input = Objects.requireNonNull(input, "input cannot be null");
    }
    
    public String getVoice() {
        return voice;
    }
    
    public void setVoice(String voice) {
        this.voice = Objects.requireNonNull(voice, "voice cannot be null");
    }
    
    public String getResponseFormat() {
        return responseFormat;
    }
    
    public void setResponseFormat(String responseFormat) {
        this.responseFormat = responseFormat;
    }
    
    public Double getSpeed() {
        return speed;
    }
    
    public void setSpeed(Double speed) {
        this.speed = speed;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String model;
        private String input;
        private String voice;
        private String responseFormat;
        private Double speed;
        
        public Builder model(String model) {
            this.model = Objects.requireNonNull(model, "model cannot be null");
            return this;
        }
        
        public Builder input(String input) {
            this.input = Objects.requireNonNull(input, "input cannot be null");
            return this;
        }
        
        public Builder voice(String voice) {
            this.voice = Objects.requireNonNull(voice, "voice cannot be null");
            return this;
        }
        
        public Builder responseFormat(String responseFormat) {
            this.responseFormat = responseFormat;
            return this;
        }
        
        public Builder speed(Double speed) {
            this.speed = speed;
            return this;
        }
        
        public CreateSpeechRequest build() {
            return new CreateSpeechRequest(model, input, voice, responseFormat, speed);
        }
    }
}
