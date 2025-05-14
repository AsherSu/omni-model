package cn.ashersu.omni.model.service;

import cn.ashersu.omni.model.completion.chat.SimpleChatMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import cn.ashersu.omni.model.completion.chat.ChatFunction;
import cn.ashersu.omni.model.completion.chat.ChatFunctionCall;
import cn.ashersu.omni.model.completion.chat.ChatMessageRole;

import java.util.*;

public class FunctionExecutor {

    private ObjectMapper MAPPER = new ObjectMapper();
    private final Map<String, ChatFunction> FUNCTIONS = new HashMap<>();

    public FunctionExecutor(List<ChatFunction> functions) {
        setFunctions(functions);
    }

    public FunctionExecutor(List<ChatFunction> functions, ObjectMapper objectMapper) {
        setFunctions(functions);
        setObjectMapper(objectMapper);
    }

    public Optional<SimpleChatMessage> executeAndConvertToMessageSafely(ChatFunctionCall call) {
        try {
            return Optional.ofNullable(executeAndConvertToMessage(call));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }

    public SimpleChatMessage executeAndConvertToMessageHandlingExceptions(ChatFunctionCall call) {
        try {
            return executeAndConvertToMessage(call);
        } catch (Exception exception) {
            exception.printStackTrace();
            return convertExceptionToMessage(exception);
        }
    }

    public SimpleChatMessage convertExceptionToMessage(Exception exception) {
        String error = exception.getMessage() == null ? exception.toString() : exception.getMessage();
        return new SimpleChatMessage(ChatMessageRole.FUNCTION.value(), "{\"error\": \"" + error + "\"}", "error");
    }

    public SimpleChatMessage executeAndConvertToMessage(ChatFunctionCall call) {
        return new SimpleChatMessage(ChatMessageRole.FUNCTION.value(), executeAndConvertToJson(call).toPrettyString(), call.getName());
    }

    public JsonNode executeAndConvertToJson(ChatFunctionCall call) {
        try {
            Object execution = execute(call);
            if (execution instanceof TextNode) {
                JsonNode objectNode = MAPPER.readTree(((TextNode) execution).asText());
                if (objectNode.isMissingNode())
                    return (JsonNode) execution;
                return objectNode;
            }
            if (execution instanceof ObjectNode) {
                return (JsonNode) execution;
            }
            if (execution instanceof String) {
                JsonNode objectNode = MAPPER.readTree((String) execution);
                if (objectNode.isMissingNode())
                    throw new RuntimeException("Parsing exception");
                return objectNode;
            }
            return MAPPER.readValue(MAPPER.writeValueAsString(execution), JsonNode.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T execute(ChatFunctionCall call) {
        ChatFunction function = FUNCTIONS.get(call.getName());
        Object obj;
        try {
            JsonNode arguments = call.getArguments();
            obj = MAPPER.readValue(arguments instanceof TextNode ? arguments.asText() : arguments.toPrettyString(), function.getParametersClass());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return (T) function.getExecutor().apply(obj);
    }

    public List<ChatFunction> getFunctions() {
        return new ArrayList<>(FUNCTIONS.values());
    }

    public void setFunctions(List<ChatFunction> functions) {
        this.FUNCTIONS.clear();
        functions.forEach(f -> this.FUNCTIONS.put(f.getName(), f));
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.MAPPER = objectMapper;
    }

}
