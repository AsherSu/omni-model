package cn.ashersu.omni.model.runs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * @description 
 * @author  vacuity
 * @create  2023-11-16 22:32
 **/

public class ToolCall {
    
    private String id;
    
    private String type;
    
    @JsonProperty("code_interpreter")
    private ToolCallCodeInterpreter codeInterpreter;

    private Map<String, String> retrieval;

    private ToolCallFunction function;
    
    public ToolCall() {
    }
    
    public ToolCall(String id, String type, ToolCallCodeInterpreter codeInterpreter, 
                    Map<String, String> retrieval, ToolCallFunction function) {
        this.id = id;
        this.type = type;
        this.codeInterpreter = codeInterpreter;
        this.retrieval = retrieval;
        this.function = function;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public ToolCallCodeInterpreter getCodeInterpreter() {
        return codeInterpreter;
    }
    
    public void setCodeInterpreter(ToolCallCodeInterpreter codeInterpreter) {
        this.codeInterpreter = codeInterpreter;
    }
    
    public Map<String, String> getRetrieval() {
        return retrieval;
    }
    
    public void setRetrieval(Map<String, String> retrieval) {
        this.retrieval = retrieval;
    }
    
    public ToolCallFunction getFunction() {
        return function;
    }
    
    public void setFunction(ToolCallFunction function) {
        this.function = function;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String id;
        private String type;
        private ToolCallCodeInterpreter codeInterpreter;
        private Map<String, String> retrieval;
        private ToolCallFunction function;
        
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        
        public Builder codeInterpreter(ToolCallCodeInterpreter codeInterpreter) {
            this.codeInterpreter = codeInterpreter;
            return this;
        }
        
        public Builder retrieval(Map<String, String> retrieval) {
            this.retrieval = retrieval;
            return this;
        }
        
        public Builder function(ToolCallFunction function) {
            this.function = function;
            return this;
        }
        
        public ToolCall build() {
            return new ToolCall(id, type, codeInterpreter, retrieval, function);
        }
    }
}
