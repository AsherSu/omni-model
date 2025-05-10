package cn.ashersu.omni.model.finetune;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * A request for OpenAi to create a fine-tuned model
 * All fields except trainingFile are nullable.
 *
 * https://beta.openai.com/docs/api-reference/fine-tunes/create
 */
@Deprecated
public class FineTuneRequest {

    /**
     * The ID of an uploaded file that contains training data.
     */
    @JsonProperty("training_file")
    private String trainingFile;

    /**
     * The ID of an uploaded file that contains validation data.
     */
    @JsonProperty("validation_file")
    private String validationFile;

    /**
     * The name of the base model to fine-tune. You can select one of "ada", "babbage", "curie", or "davinci".
     * To learn more about these models, see the Engines documentation.
     */
    private String model;

    /**
     * The number of epochs to train the model for. An epoch refers to one full cycle through the training dataset.
     */
    @JsonProperty("n_epochs")
    private Integer nEpochs;

    /**
     * The batch size to use for training.
     * The batch size is the number of training examples used to train a single forward and backward pass.
     *
     * By default, the batch size will be dynamically configured to be ~0.2% of the number of examples in the training
     * set, capped at 256 - in general, we've found that larger batch sizes tend to work better for larger datasets.
     */
    @JsonProperty("batch_size")
    private Integer batchSize;

    /**
     * The learning rate multiplier to use for training.
     * The fine-tuning learning rate is the original learning rate used for pretraining multiplied by this value.
     *
     * By default, the learning rate multiplier is the 0.05, 0.1, or 0.2 depending on final batch_size
     * (larger learning rates tend to perform better with larger batch sizes).
     * We recommend experimenting with values in the range 0.02 to 0.2 to see what produces the best results.
     */
    @JsonProperty("learning_rate_multiplier")
    private Double learningRateMultiplier;

    /**
     * The weight to use for loss on the prompt tokens.
     * This controls how much the model tries to learn to generate the prompt
     * (as compared to the completion which always has a weight of 1.0),
     * and can add a stabilizing effect to training when completions are short.
     *
     * If prompts are extremely long (relative to completions), it may make sense to reduce this weight so as to
     * avoid over-prioritizing learning the prompt.
     */
    @JsonProperty("prompt_loss_weight")
    private Double promptLossWeight;

    /**
     * If set, we calculate classification-specific metrics such as accuracy and F-1 score using the validation set
     * at the end of every epoch. These metrics can be viewed in the results file.
     *
     * In order to compute classification metrics, you must provide a validation_file.
     * Additionally, you must specify {@link FineTuneRequest#classificationNClasses} for multiclass
     * classification or {@link FineTuneRequest#classificationPositiveClass} for binary classification.
     */
    @JsonProperty("compute_classification_metrics")
    private Boolean computeClassificationMetrics;

    /**
     * The number of classes in a classification task.
     *
     * This parameter is required for multiclass classification.
     */
    @JsonProperty("classification_n_classes")
    private Integer classificationNClasses;

    /**
     * The positive class in binary classification.
     *
     * This parameter is needed to generate precision, recall, and F1 metrics when doing binary classification.
     */
    @JsonProperty("classification_positive_class")
    private String classificationPositiveClass;

    /**
     * If this is provided, we calculate F-beta scores at the specified beta values.
     * The F-beta score is a generalization of F-1 score. This is only used for binary classification.
     *
     * With a beta of 1 (i.e. the F-1 score), precision and recall are given the same weight.
     * A larger beta score puts more weight on recall and less on precision.
     * A smaller beta score puts more weight on precision and less on recall.
     */
    @JsonProperty("classification_betas")
    private List<Double> classificationBetas;

    /**
     * A string of up to 40 characters that will be added to your fine-tuned model name.
     */
    private String suffix;
    
    public FineTuneRequest() {
    }
    
    public FineTuneRequest(String trainingFile, String validationFile, String model, Integer nEpochs, 
                           Integer batchSize, Double learningRateMultiplier, Double promptLossWeight, 
                           Boolean computeClassificationMetrics, Integer classificationNClasses, 
                           String classificationPositiveClass, List<Double> classificationBetas, String suffix) {
        this.trainingFile = Objects.requireNonNull(trainingFile, "trainingFile cannot be null");
        this.validationFile = validationFile;
        this.model = model;
        this.nEpochs = nEpochs;
        this.batchSize = batchSize;
        this.learningRateMultiplier = learningRateMultiplier;
        this.promptLossWeight = promptLossWeight;
        this.computeClassificationMetrics = computeClassificationMetrics;
        this.classificationNClasses = classificationNClasses;
        this.classificationPositiveClass = classificationPositiveClass;
        this.classificationBetas = classificationBetas;
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
        this.model = model;
    }
    
    public Integer getNEpochs() {
        return nEpochs;
    }
    
    public void setNEpochs(Integer nEpochs) {
        this.nEpochs = nEpochs;
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
    
    public Double getPromptLossWeight() {
        return promptLossWeight;
    }
    
    public void setPromptLossWeight(Double promptLossWeight) {
        this.promptLossWeight = promptLossWeight;
    }
    
    public Boolean getComputeClassificationMetrics() {
        return computeClassificationMetrics;
    }
    
    public void setComputeClassificationMetrics(Boolean computeClassificationMetrics) {
        this.computeClassificationMetrics = computeClassificationMetrics;
    }
    
    public Integer getClassificationNClasses() {
        return classificationNClasses;
    }
    
    public void setClassificationNClasses(Integer classificationNClasses) {
        this.classificationNClasses = classificationNClasses;
    }
    
    public String getClassificationPositiveClass() {
        return classificationPositiveClass;
    }
    
    public void setClassificationPositiveClass(String classificationPositiveClass) {
        this.classificationPositiveClass = classificationPositiveClass;
    }
    
    public List<Double> getClassificationBetas() {
        return classificationBetas;
    }
    
    public void setClassificationBetas(List<Double> classificationBetas) {
        this.classificationBetas = classificationBetas;
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
        private Integer nEpochs;
        private Integer batchSize;
        private Double learningRateMultiplier;
        private Double promptLossWeight;
        private Boolean computeClassificationMetrics;
        private Integer classificationNClasses;
        private String classificationPositiveClass;
        private List<Double> classificationBetas;
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
            this.model = model;
            return this;
        }
        
        public Builder nEpochs(Integer nEpochs) {
            this.nEpochs = nEpochs;
            return this;
        }
        
        public Builder batchSize(Integer batchSize) {
            this.batchSize = batchSize;
            return this;
        }
        
        public Builder learningRateMultiplier(Double learningRateMultiplier) {
            this.learningRateMultiplier = learningRateMultiplier;
            return this;
        }
        
        public Builder promptLossWeight(Double promptLossWeight) {
            this.promptLossWeight = promptLossWeight;
            return this;
        }
        
        public Builder computeClassificationMetrics(Boolean computeClassificationMetrics) {
            this.computeClassificationMetrics = computeClassificationMetrics;
            return this;
        }
        
        public Builder classificationNClasses(Integer classificationNClasses) {
            this.classificationNClasses = classificationNClasses;
            return this;
        }
        
        public Builder classificationPositiveClass(String classificationPositiveClass) {
            this.classificationPositiveClass = classificationPositiveClass;
            return this;
        }
        
        public Builder classificationBetas(List<Double> classificationBetas) {
            this.classificationBetas = classificationBetas;
            return this;
        }
        
        public Builder suffix(String suffix) {
            this.suffix = suffix;
            return this;
        }
        
        public FineTuneRequest build() {
            return new FineTuneRequest(trainingFile, validationFile, model, nEpochs, batchSize, 
                                      learningRateMultiplier, promptLossWeight, computeClassificationMetrics, 
                                      classificationNClasses, classificationPositiveClass, 
                                      classificationBetas, suffix);
        }
    }
}
