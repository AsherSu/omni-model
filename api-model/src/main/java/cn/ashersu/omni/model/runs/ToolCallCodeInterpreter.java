package cn.ashersu.omni.model.runs;

import java.util.List;

/**
 * @description 
 * @author  vacuity
 * @create  2023-11-16 22:34
 **/

public class ToolCallCodeInterpreter {
    
    private String input;
    
    private List<ToolCallCodeInterpreterOutput> outputs;
    
    public ToolCallCodeInterpreter() {
    }
    
    public ToolCallCodeInterpreter(String input, List<ToolCallCodeInterpreterOutput> outputs) {
        this.input = input;
        this.outputs = outputs;
    }
    
    public String getInput() {
        return input;
    }
    
    public void setInput(String input) {
        this.input = input;
    }
    
    public List<ToolCallCodeInterpreterOutput> getOutputs() {
        return outputs;
    }
    
    public void setOutputs(List<ToolCallCodeInterpreterOutput> outputs) {
        this.outputs = outputs;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String input;
        private List<ToolCallCodeInterpreterOutput> outputs;
        
        public Builder input(String input) {
            this.input = input;
            return this;
        }
        
        public Builder outputs(List<ToolCallCodeInterpreterOutput> outputs) {
            this.outputs = outputs;
            return this;
        }
        
        public ToolCallCodeInterpreter build() {
            return new ToolCallCodeInterpreter(input, outputs);
        }
    }
}
