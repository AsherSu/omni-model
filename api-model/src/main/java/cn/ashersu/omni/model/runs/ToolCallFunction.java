package cn.ashersu.omni.model.runs;

/**
 * @description 
 * @author  vacuity
 * @create  2023-11-16 22:38
 **/

public class ToolCallFunction {
    
    private String name;
    
    private String arguments;
    
    private String output;
    
    public ToolCallFunction() {
    }
    
    public ToolCallFunction(String name, String arguments, String output) {
        this.name = name;
        this.arguments = arguments;
        this.output = output;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getArguments() {
        return arguments;
    }
    
    public void setArguments(String arguments) {
        this.arguments = arguments;
    }
    
    public String getOutput() {
        return output;
    }
    
    public void setOutput(String output) {
        this.output = output;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String name;
        private String arguments;
        private String output;
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public Builder arguments(String arguments) {
            this.arguments = arguments;
            return this;
        }
        
        public Builder output(String output) {
            this.output = output;
            return this;
        }
        
        public ToolCallFunction build() {
            return new ToolCallFunction(name, arguments, output);
        }
    }
}
