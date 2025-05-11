package cn.ashersu.omni.model.service.sse;

import cn.ashersu.omni.model.completion.chat.ChatCompletionChunk;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Simple Server Sent Event representation
 */
public class SSE {
    private static final String DONE_DATA = "[DONE]";

    private static final String STOP_DATA = "stop";

    private final String data;

    private final ChatCompletionChunk chatCompletionChunk;

    public SSE(String data){
        ObjectMapper objectMapper = new ObjectMapper();
        this.data = data;
        try {
            this.chatCompletionChunk = objectMapper.readValue(data, ChatCompletionChunk.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getData(){
        return this.data;
    }

    public byte[] toBytes(){
        return String.format("data: %s\n\n", this.data).getBytes();
    }

    public boolean isDone(){
        return DONE_DATA.equalsIgnoreCase(this.data)
                || STOP_DATA.equals(chatCompletionChunk.getChoices().get(0).getFinishReason());
    }
}