package cn.ashersu.omni.model.assistants;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AssistantToolsEnum {

    @JsonProperty("code_interpreter")
    CODE_INTERPRETER,

    @JsonProperty("function")
    FUNCTION,

    @JsonProperty("retrieval")
    RETRIEVAL
}
