package cn.ashersu.omni.model.finetune;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Fine-tuning job hyperparameters
 *
 * https://beta.openai.com/docs/api-reference/fine-tunes
 */
@Deprecated
public class HyperParameters {

    /**
     * The batch size to use for training.
     */
    @JsonProperty("batch_size")
    private Integer batchSize;

    /**
     * The learning rate multiplier to use for training.
     */
    @JsonProperty("learning_rate_multiplier")
    private Double learningRateMultiplier;

    /**
     * The number of epochs to train the model for.
     */
    @JsonProperty("n_epochs")
    private Integer nEpochs;

    /**
     * The weight to use for loss on the prompt tokens.
     */
    @JsonProperty("prompt_loss_weight")
    private Double promptLossWeight;
    
    public HyperParameters() {
    }
    
    public HyperParameters(Integer batchSize, Double learningRateMultiplier, Integer nEpochs, Double promptLossWeight) {
        this.batchSize = batchSize;
        this.learningRateMultiplier = learningRateMultiplier;
        this.nEpochs = nEpochs;
        this.promptLossWeight = promptLossWeight;
    }
    
    public Integer getBatchSize() {
        return batchSize;
    }
    
    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }
    
    public Double getLearningRateMultiplier() {
        return learningRateMultiplier;
    }
    
    public void setLearningRateMultiplier(Double learningRateMultiplier) {
        this.learningRateMultiplier = learningRateMultiplier;
    }
    
    public Integer getNEpochs() {
        return nEpochs;
    }
    
    public void setNEpochs(Integer nEpochs) {
        this.nEpochs = nEpochs;
    }
    
    public Double getPromptLossWeight() {
        return promptLossWeight;
    }
    
    public void setPromptLossWeight(Double promptLossWeight) {
        this.promptLossWeight = promptLossWeight;
    }
}
