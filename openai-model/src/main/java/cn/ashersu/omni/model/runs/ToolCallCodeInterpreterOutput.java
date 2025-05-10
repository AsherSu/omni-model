package cn.ashersu.omni.model.runs;

/**
 * @description 
 * @author  vacuity
 * @create  2023-11-16 22:34
 **/

public class ToolCallCodeInterpreterOutput {
    
    private String type;
    
    private String logs;
    
    private RunImage image;
    
    public ToolCallCodeInterpreterOutput() {
    }
    
    public ToolCallCodeInterpreterOutput(String type, String logs, RunImage image) {
        this.type = type;
        this.logs = logs;
        this.image = image;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getLogs() {
        return logs;
    }
    
    public void setLogs(String logs) {
        this.logs = logs;
    }
    
    public RunImage getImage() {
        return image;
    }
    
    public void setImage(RunImage image) {
        this.image = image;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String type;
        private String logs;
        private RunImage image;
        
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        
        public Builder logs(String logs) {
            this.logs = logs;
            return this;
        }
        
        public Builder image(RunImage image) {
            this.image = image;
            return this;
        }
        
        public ToolCallCodeInterpreterOutput build() {
            return new ToolCallCodeInterpreterOutput(type, logs, image);
        }
    }
}
