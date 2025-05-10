package cn.ashersu.omni.model.fine_tuning;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Hyperparameters for a fine-tuning job
 * https://platform.openai.com/docs/api-reference/fine-tuning/object#hyperparameters
 */
public class Hyperparameters {

    /**
     * The number of epochs to train the model for.
     * An epoch refers to one full cycle through the training dataset.
     * "Auto" decides the optimal number of epochs based on the size of the dataset.
     * If setting the number manually, we support any number between 1 and 50 epochs.
     */
    @JsonProperty("n_epochs")
    private Integer nEpochs;
    
    public Hyperparameters() {
    }
    
    public Hyperparameters(Integer nEpochs) {
        this.nEpochs = nEpochs;
    }
    
    public Integer getNEpochs() {
        return nEpochs;
    }
    
    public void setNEpochs(Integer nEpochs) {
        this.nEpochs = nEpochs;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private Integer nEpochs;
        
        public Builder nEpochs(Integer nEpochs) {
            this.nEpochs = nEpochs;
            return this;
        }
        
        public Hyperparameters build() {
            return new Hyperparameters(nEpochs);
        }
    }
}
