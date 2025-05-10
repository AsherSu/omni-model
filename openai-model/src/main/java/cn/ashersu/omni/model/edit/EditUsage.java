package cn.ashersu.omni.model.edit;

import cn.ashersu.omni.model.Usage;

/**
 * An object containing the API usage for an edit request
 *
 * Deprecated, use {@link Usage} instead
 *
 * https://beta.openai.com/docs/api-reference/edits/create
 */
@Deprecated
public class EditUsage {

    /**
     * The number of prompt tokens consumed.
     */
    private String promptTokens;

    /**
     * The number of completion tokens consumed.
     */
    private String completionTokens;

    /**
     * The number of total tokens consumed.
     */
    private String totalTokens;
    
    public EditUsage() {
    }
    
    public EditUsage(String promptTokens, String completionTokens, String totalTokens) {
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
    }
    
    public String getPromptTokens() {
        return promptTokens;
    }
    
    public void setPromptTokens(String promptTokens) {
        this.promptTokens = promptTokens;
    }
    
    public String getCompletionTokens() {
        return completionTokens;
    }
    
    public void setCompletionTokens(String completionTokens) {
        this.completionTokens = completionTokens;
    }
    
    public String getTotalTokens() {
        return totalTokens;
    }
    
    public void setTotalTokens(String totalTokens) {
        this.totalTokens = totalTokens;
    }
}
