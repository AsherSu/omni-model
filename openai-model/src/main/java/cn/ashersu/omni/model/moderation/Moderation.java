package cn.ashersu.omni.model.moderation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object containing the moderation data for a single input string
 *
 * https://beta.openai.com/docs/api-reference/moderations/create
 */
public class Moderation {
    /**
     * Set to true if the model classifies the content as violating OpenAI's content policy, false otherwise
     */
    private boolean flagged;

    /**
     * Object containing per-category binary content policy violation flags.
     * For each category, the value is true if the model flags the corresponding category as violated, false otherwise.
     */
    private ModerationCategories categories;

    /**
     * Object containing per-category raw scores output by the model, denoting the model's confidence that the
     * input violates the OpenAI's policy for the category.
     * The value is between 0 and 1, where higher values denote higher confidence.
     * The scores should not be interpreted as probabilities.
     */
    @JsonProperty("category_scores")
    private ModerationCategoryScores categoryScores;
    
    public boolean isFlagged() {
        return flagged;
    }
    
    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }
    
    public ModerationCategories getCategories() {
        return categories;
    }
    
    public void setCategories(ModerationCategories categories) {
        this.categories = categories;
    }
    
    public ModerationCategoryScores getCategoryScores() {
        return categoryScores;
    }
    
    public void setCategoryScores(ModerationCategoryScores categoryScores) {
        this.categoryScores = categoryScores;
    }
}
