package cn.ashersu.omni.model.edit;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Given a prompt and an instruction, OpenAi will return an edited version of the prompt
 *
 * https://beta.openai.com/docs/api-reference/edits/create
 */
public class EditRequest {

    /**
     * The name of the model to use.
     * Required if using the new v1/edits endpoint.
     */
    private String model;

    /**
     * The input text to use as a starting point for the edit.
     */
    private String input;

    /**
     * The instruction that tells the model how to edit the prompt.
     * For example, "Fix the spelling mistakes"
     */
    private String instruction;

    /**
     * How many edits to generate for the input and instruction.
     */
    private Integer n;

    /**
     * What sampling temperature to use. Higher values means the model will take more risks.
     * Try 0.9 for more creative applications, and 0 (argmax sampling) for ones with a well-defined answer.
     *
     * We generally recommend altering this or {@link EditRequest#topP} but not both.
     */
    private Double temperature;

    /**
     * An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of
     * the tokens with top_p probability mass.So 0.1 means only the tokens comprising the top 10% probability mass are
     * considered.
     *
     * We generally recommend altering this or {@link EditRequest#temperature} but not both.
     */
    @JsonProperty("top_p")
    private Double topP;
    
    public EditRequest() {
    }
    
    public EditRequest(String model, String input, String instruction, Integer n, Double temperature, Double topP) {
        this.model = model;
        this.input = input;
        this.instruction = Objects.requireNonNull(instruction, "instruction cannot be null");
        this.n = n;
        this.temperature = temperature;
        this.topP = topP;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getInput() {
        return input;
    }
    
    public void setInput(String input) {
        this.input = input;
    }
    
    public String getInstruction() {
        return instruction;
    }
    
    public void setInstruction(String instruction) {
        this.instruction = Objects.requireNonNull(instruction, "instruction cannot be null");
    }
    
    public Integer getN() {
        return n;
    }
    
    public void setN(Integer n) {
        this.n = n;
    }
    
    public Double getTemperature() {
        return temperature;
    }
    
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
    
    public Double getTopP() {
        return topP;
    }
    
    public void setTopP(Double topP) {
        this.topP = topP;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String model;
        private String input;
        private String instruction;
        private Integer n;
        private Double temperature;
        private Double topP;
        
        public Builder model(String model) {
            this.model = model;
            return this;
        }
        
        public Builder input(String input) {
            this.input = input;
            return this;
        }
        
        public Builder instruction(String instruction) {
            this.instruction = Objects.requireNonNull(instruction, "instruction cannot be null");
            return this;
        }
        
        public Builder n(Integer n) {
            this.n = n;
            return this;
        }
        
        public Builder temperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }
        
        public Builder topP(Double topP) {
            this.topP = topP;
            return this;
        }
        
        public EditRequest build() {
            return new EditRequest(model, input, instruction, n, temperature, topP);
        }
    }
}
