package cn.ashersu.omni.model.completion;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Log probabilities of different token options
 * Returned if {@link CompletionRequest#logprobs} is greater than zero
 *
 * https://beta.openai.com/docs/api-reference/create-completion
 */
public class LogProbResult {

    /**
     * The tokens chosen by the completion api
     */
    private List<String> tokens;

    /**
     * The log probability of each token in {@link tokens}
     */
    @JsonProperty("token_logprobs")
    private List<Double> tokenLogprobs;

    /**
     * A map for each index in the completion result.
     * The map contains the top {@link CompletionRequest#logprobs} tokens and their probabilities
     */
    @JsonProperty("top_logprobs")
    private List<Map<String, Double>> topLogprobs;

    /**
     * The character offset from the start of the returned text for each of the chosen tokens.
     */
    private List<Integer> textOffset;
    
    public LogProbResult() {
    }
    
    public LogProbResult(List<String> tokens, List<Double> tokenLogprobs, 
                        List<Map<String, Double>> topLogprobs, List<Integer> textOffset) {
        this.tokens = tokens;
        this.tokenLogprobs = tokenLogprobs;
        this.topLogprobs = topLogprobs;
        this.textOffset = textOffset;
    }
    
    public List<String> getTokens() {
        return tokens;
    }
    
    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }
    
    public List<Double> getTokenLogprobs() {
        return tokenLogprobs;
    }
    
    public void setTokenLogprobs(List<Double> tokenLogprobs) {
        this.tokenLogprobs = tokenLogprobs;
    }
    
    public List<Map<String, Double>> getTopLogprobs() {
        return topLogprobs;
    }
    
    public void setTopLogprobs(List<Map<String, Double>> topLogprobs) {
        this.topLogprobs = topLogprobs;
    }
    
    public List<Integer> getTextOffset() {
        return textOffset;
    }
    
    public void setTextOffset(List<Integer> textOffset) {
        this.textOffset = textOffset;
    }
}
