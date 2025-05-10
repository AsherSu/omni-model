package cn.ashersu.omni.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The OpenAI resources used by a request
 */
public class Usage {
    /**
     * The number of prompt tokens used.
     */
    @JsonProperty("prompt_tokens")
    private long promptTokens;

    /**
     * The number of completion tokens used.
     */
    @JsonProperty("completion_tokens")
    private long completionTokens;

    /**
     * The number of total tokens used
     */
    @JsonProperty("total_tokens")
    private long totalTokens;
    
    public long getPromptTokens() {
        return promptTokens;
    }
    
    public void setPromptTokens(long promptTokens) {
        this.promptTokens = promptTokens;
    }
    
    public long getCompletionTokens() {
        return completionTokens;
    }
    
    public void setCompletionTokens(long completionTokens) {
        this.completionTokens = completionTokens;
    }
    
    public long getTotalTokens() {
        return totalTokens;
    }
    
    public void setTotalTokens(long totalTokens) {
        this.totalTokens = totalTokens;
    }
}
