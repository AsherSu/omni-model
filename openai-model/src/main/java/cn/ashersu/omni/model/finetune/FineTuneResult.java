package cn.ashersu.omni.model.finetune;

import com.fasterxml.jackson.annotation.JsonProperty;
import cn.ashersu.omni.model.file.File;

import java.util.List;

/**
 * An object describing a fine-tuned model. Returned by multiple fine-tune requests.
 *
 * https://beta.openai.com/docs/api-reference/fine-tunes
 */
@Deprecated
public class FineTuneResult {
    /**
     * The ID of the fine-tuning job.
     */
    private String id;

    /**
     * The type of object returned, should be "fine-tune".
     */
    private String object;

    /**
     * The name of the base model.
     */
    private String model;

    /**
     * The creation time in epoch seconds.
     */
    @JsonProperty("created_at")
    private Long createdAt;

    /**
     * List of events in this job's lifecycle. Null when getting a list of fine-tune jobs.
     */
    private List<FineTuneEvent> events;

    /**
     * The ID of the fine-tuned model, null if tuning job is not finished.
     * This is the id used to call the model.
     */
    @JsonProperty("fine_tuned_model")
    private String fineTunedModel;

    /**
     * The specified hyper-parameters for the tuning job.
     */
    private HyperParameters hyperparams;

    /**
     * The ID of the organization this model belongs to.
     */
    @JsonProperty("organization_id")
    private String organizationId;

    /**
     * Result files for this fine-tune job.
     */
    @JsonProperty("result_files")
    private List<File> resultFiles;

    /**
     * The status os the fine-tune job. "pending", "succeeded", or "cancelled"
     */
    private String status;

    /**
     * Training files for this fine-tune job.
     */
    @JsonProperty("training_files")
    private List<File> trainingFiles;

    /**
     * The last update time in epoch seconds.
     */
    @JsonProperty("updated_at")
    private Long updatedAt;

    /**
     * Validation files for this fine-tune job.
     */
    @JsonProperty("validation_files")
    private List<File> validationFiles;
    
    public FineTuneResult() {
    }
    
    public FineTuneResult(String id, String object, String model, Long createdAt, List<FineTuneEvent> events, 
                          String fineTunedModel, HyperParameters hyperparams, String organizationId, 
                          List<File> resultFiles, String status, List<File> trainingFiles, 
                          Long updatedAt, List<File> validationFiles) {
        this.id = id;
        this.object = object;
        this.model = model;
        this.createdAt = createdAt;
        this.events = events;
        this.fineTunedModel = fineTunedModel;
        this.hyperparams = hyperparams;
        this.organizationId = organizationId;
        this.resultFiles = resultFiles;
        this.status = status;
        this.trainingFiles = trainingFiles;
        this.updatedAt = updatedAt;
        this.validationFiles = validationFiles;
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
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public Long getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
    
    public List<FineTuneEvent> getEvents() {
        return events;
    }
    
    public void setEvents(List<FineTuneEvent> events) {
        this.events = events;
    }
    
    public String getFineTunedModel() {
        return fineTunedModel;
    }
    
    public void setFineTunedModel(String fineTunedModel) {
        this.fineTunedModel = fineTunedModel;
    }
    
    public HyperParameters getHyperparams() {
        return hyperparams;
    }
    
    public void setHyperparams(HyperParameters hyperparams) {
        this.hyperparams = hyperparams;
    }
    
    public String getOrganizationId() {
        return organizationId;
    }
    
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
    
    public List<File> getResultFiles() {
        return resultFiles;
    }
    
    public void setResultFiles(List<File> resultFiles) {
        this.resultFiles = resultFiles;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<File> getTrainingFiles() {
        return trainingFiles;
    }
    
    public void setTrainingFiles(List<File> trainingFiles) {
        this.trainingFiles = trainingFiles;
    }
    
    public Long getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public List<File> getValidationFiles() {
        return validationFiles;
    }
    
    public void setValidationFiles(List<File> validationFiles) {
        this.validationFiles = validationFiles;
    }
}
