package cn.ashersu.omni.model.fine_tuning;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Request to create a fine tuning job
 * https://platform.openai.com/docs/api-reference/fine-tuning/create
 */
public class FineTuningJobRequest {

    /**
     * The ID of an uploaded file that contains training data.
     */
    @JsonProperty("training_file")
    private String trainingFile;

    /**
     * The ID of an uploaded file that contains validation data.
     * Optional.
     */
    @JsonProperty("validation_file")
    private String validationFile;

    /**
     * The name of the model to fine-tune.
     */
    private String model;

    /**
     * The hyperparameters used for the fine-tuning job.
     */
    private Hyperparameters hyperparameters;

    /**
     * A string of up to 40 characters that will be added to your fine-tuned model name.
     */
    private String suffix;
    
    public FineTuningJobRequest() {
    }
    
    public FineTuningJobRequest(String trainingFile, String validationFile, String model, 
                              Hyperparameters hyperparameters, String suffix) {
        this.trainingFile = Objects.requireNonNull(trainingFile, "trainingFile cannot be null");
        this.validationFile = validationFile;
        this.model = Objects.requireNonNull(model, "model cannot be null");
        this.hyperparameters = hyperparameters;
        this.suffix = suffix;
    }
    
    public String getTrainingFile() {
        return trainingFile;
    }
    
    public void setTrainingFile(String trainingFile) {
        this.trainingFile = Objects.requireNonNull(trainingFile, "trainingFile cannot be null");
    }
    
    public String getValidationFile() {
        return validationFile;
    }
    
    public void setValidationFile(String validationFile) {
        this.validationFile = validationFile;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = Objects.requireNonNull(model, "model cannot be null");
    }
    
    public Hyperparameters getHyperparameters() {
        return hyperparameters;
    }
    
    public void setHyperparameters(Hyperparameters hyperparameters) {
        this.hyperparameters = hyperparameters;
    }
    
    public String getSuffix() {
        return suffix;
    }
    
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String trainingFile;
        private String validationFile;
        private String model;
        private Hyperparameters hyperparameters;
        private String suffix;
        
        public Builder trainingFile(String trainingFile) {
            this.trainingFile = Objects.requireNonNull(trainingFile, "trainingFile cannot be null");
            return this;
        }
        
        public Builder validationFile(String validationFile) {
            this.validationFile = validationFile;
            return this;
        }
        
        public Builder model(String model) {
            this.model = Objects.requireNonNull(model, "model cannot be null");
            return this;
        }
        
        public Builder hyperparameters(Hyperparameters hyperparameters) {
            this.hyperparameters = hyperparameters;
            return this;
        }
        
        public Builder suffix(String suffix) {
            this.suffix = suffix;
            return this;
        }
        
        public FineTuningJobRequest build() {
            return new FineTuningJobRequest(trainingFile, validationFile, model, hyperparameters, suffix);
        }
    }
}
