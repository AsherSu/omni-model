package cn.ashersu.omni.model.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model permissions
 * I couldn't find documentation for the specific permissions, and I've elected to leave them undocumented rather than
 * write something incorrect.
 *
 * https://beta.openai.com/docs/api-reference/models
 */
public class Permission {
    /**
     * An identifier for this model permission
     */
    private String id;

    /**
     * The type of object returned, should be "model_permission"
     */
    private String object;

    /**
     * The creation time in epoch seconds.
     */
    private long created;

    @JsonProperty("allow_create_engine")
    private boolean allowCreateEngine;

    @JsonProperty("allow_sampling")
    private boolean allowSampling;

    @JsonProperty("allow_log_probs")
    private boolean allowLogProbs;

    @JsonProperty("allow_search_indices")
    private boolean allowSearchIndices;

    @JsonProperty("allow_view")
    private boolean allowView;

    @JsonProperty("allow_fine_tuning")
    private boolean allowFineTuning;

    private String organization;

    private String group;

    @JsonProperty("is_blocking")
    private boolean isBlocking;
    
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
    
    public long getCreated() {
        return created;
    }
    
    public void setCreated(long created) {
        this.created = created;
    }
    
    public boolean isAllowCreateEngine() {
        return allowCreateEngine;
    }
    
    public void setAllowCreateEngine(boolean allowCreateEngine) {
        this.allowCreateEngine = allowCreateEngine;
    }
    
    public boolean isAllowSampling() {
        return allowSampling;
    }
    
    public void setAllowSampling(boolean allowSampling) {
        this.allowSampling = allowSampling;
    }
    
    public boolean isAllowLogProbs() {
        return allowLogProbs;
    }
    
    public void setAllowLogProbs(boolean allowLogProbs) {
        this.allowLogProbs = allowLogProbs;
    }
    
    public boolean isAllowSearchIndices() {
        return allowSearchIndices;
    }
    
    public void setAllowSearchIndices(boolean allowSearchIndices) {
        this.allowSearchIndices = allowSearchIndices;
    }
    
    public boolean isAllowView() {
        return allowView;
    }
    
    public void setAllowView(boolean allowView) {
        this.allowView = allowView;
    }
    
    public boolean isAllowFineTuning() {
        return allowFineTuning;
    }
    
    public void setAllowFineTuning(boolean allowFineTuning) {
        this.allowFineTuning = allowFineTuning;
    }
    
    public String getOrganization() {
        return organization;
    }
    
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    
    public String getGroup() {
        return group;
    }
    
    public void setGroup(String group) {
        this.group = group;
    }
    
    public boolean isBlocking() {
        return isBlocking;
    }
    
    public void setBlocking(boolean blocking) {
        this.isBlocking = blocking;
    }
}
