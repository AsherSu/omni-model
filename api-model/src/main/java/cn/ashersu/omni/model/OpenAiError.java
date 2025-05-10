package cn.ashersu.omni.model;

/**
 * Represents the error body when an OpenAI request fails
 */
public class OpenAiError {

    private OpenAiErrorDetails error;
    
    public OpenAiError() {
    }
    
    public OpenAiError(OpenAiErrorDetails error) {
        this.error = error;
    }
    
    public OpenAiErrorDetails getError() {
        return error;
    }
    
    public void setError(OpenAiErrorDetails error) {
        this.error = error;
    }

    public static class OpenAiErrorDetails {
        /**
         * Human-readable error message
         */
        private String message;

        /**
         * OpenAI error type, for example "invalid_request_error"
         * https://platform.openai.com/docs/guides/error-codes/python-library-error-types
         */
        private String type;

        private String param;

        /**
         * OpenAI error code, for example "invalid_api_key"
         */
        private String code;
        
        public OpenAiErrorDetails() {
        }
        
        public OpenAiErrorDetails(String message, String type, String param, String code) {
            this.message = message;
            this.type = type;
            this.param = param;
            this.code = code;
        }
        
        public String getMessage() {
            return message;
        }
        
        public void setMessage(String message) {
            this.message = message;
        }
        
        public String getType() {
            return type;
        }
        
        public void setType(String type) {
            this.type = type;
        }
        
        public String getParam() {
            return param;
        }
        
        public void setParam(String param) {
            this.param = param;
        }
        
        public String getCode() {
            return code;
        }
        
        public void setCode(String code) {
            this.code = code;
        }
    }
}
