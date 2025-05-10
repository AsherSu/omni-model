package cn.ashersu.omni.model.jackson.mixin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import cn.ashersu.omni.model.jackson.serializer.ChatFunctionParametersSerializer;

public abstract class ChatFunctionMixIn {

    @JsonSerialize(using = ChatFunctionParametersSerializer.class)
    abstract Class<?> getParametersClass();

}
