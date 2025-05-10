package cn.ashersu.omni.model.fine_tuning;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Fine-tuning job
 * https://platform.openai.com/docs/api-reference/fine-tuning/object
 */
public class FineTuningJob {
    /**
     * The object identifier, which can be referenced in the API endpoints.
     */
    private String id;

    /**
     * The object type, which is always "fine_tuning.job".
     */
    private String object;

    /**
     * The unix timestamp for when the fine-tuning job was created.
     */
    @JsonProperty("created_at")
    private Long createdAt;

    /**
     * The unix timestamp for when the fine-tuning job was finished.
     */
    @JsonProperty("finished_at")
    private Long finishedAt;

    /**
     * The base model that is being fine-tuned.
     */
    private String model;

    /**
     * The name of the fine-tuned model that is being created.
     * Can be null if no fine-tuned model is created yet.
     */
    @JsonProperty("fine_tuned_model")
    private String fineTunedModel;

    /**
     * The organization that owns the fine-tuning job.
     */
    @JsonProperty("organization_id")
    private String organizationId;

    /**
     * The current status of the fine-tuning job.
     * Can be either created, pending, running, succeeded, failed, or cancelled.
     */
    private String status;

    /**
     * The hyperparameters used for the fine-tuning job.
     * See the fine-tuning guide for more details.
     */
    private Hyperparameters hyperparameters;

    /**
     * The file ID used for training.
     */
    @JsonProperty("training_file")
    private String trainingFile;

    /**
     * The file ID used for validation.
     * Can be null if validation is not used.
     */
    @JsonProperty("validation_file")
    private String validationFile;

    /**
     * The compiled results files for the fine-tuning job.
     */
    @JsonProperty("result_files")
    private List<String> resultFiles;

    /**
     * The total number of billable tokens processed by this fine-tuning job.
     */
    @JsonProperty("trained_tokens")
    private Integer trainedTokens;
    
    public FineTuningJob() {
    }
    
    public FineTuningJob(String id, String object, Long createdAt, Long finishedAt, String model, 
                       String fineTunedModel, String organizationId, String status, Hyperparameters hyperparameters, 
                       String trainingFile, String validationFile, List<String> resultFiles, Integer trainedTokens) {
        this.id = id;
        this.object = object;
        this.createdAt = createdAt;
        this.finishedAt = finishedAt;
        this.model = model;
        this.fineTunedModel = fineTunedModel;
        this.organizationId = organizationId;
        this.status = status;
        this.hyperparameters = hyperparameters;
        this.trainingFile = trainingFile;
        this.validationFile = validationFile;
        this.resultFiles = resultFiles;
        this.trainedTokens = trainedTokens;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getObject() {
        return object;
    }
    
    public void setObject(String object) {
        this.object = object;
    }
    
    public Long getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
    
    public Long getFinishedAt() {
        return finishedAt;
    }
    
    public void setFinishedAt(Long finishedAt) {
        this.finishedAt = finishedAt;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getFineTunedModel() {
        return fineTunedModel;
    }
    
    public void setFineTunedModel(String fineTunedModel) {
        this.fineTunedModel = fineTunedModel;
    }
    
    public String getOrganizationId() {
        return organizationId;
    }
    
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Hyperparameters getHyperparameters() {
        return hyperparameters;
    }
    
    public void setHyperparameters(Hyperparameters hyperparameters) {
        this.hyperparameters = hyperparameters;
    }
    
    public String getTrainingFile() {
        return trainingFile;
    }
    
    public void setTrainingFile(String trainingFile) {
        this.trainingFile = trainingFile;
    }
    
    public String getValidationFile() {
        return validationFile;
    }
    
    public void setValidationFile(String validationFile) {
        this.validationFile = validationFile;
    }
    
    public List<String> getResultFiles() {
        return resultFiles;
    }
    
    public void setResultFiles(List<String> resultFiles) {
        this.resultFiles = resultFiles;
    }
    
    public Integer getTrainedTokens() {
        return trainedTokens;
    }
    
    public void setTrainedTokens(Integer trainedTokens) {
        this.trainedTokens = trainedTokens;
    }
}