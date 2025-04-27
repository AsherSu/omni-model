package cn.ashersu.omni.model.mixin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import cn.ashersu.omni.model.serializer.ChatFunctionParametersSerializer;

public abstract class ChatFunctionMixIn {

    @JsonSerialize(using = ChatFunctionParametersSerializer.class)
    abstract Class<?> getParametersClass();

}
