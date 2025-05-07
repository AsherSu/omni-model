package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.completion.chat.ChatCompletionChunk;
import cn.ashersu.omni.model.completion.chat.ChatCompletionRequest;
import cn.ashersu.omni.model.completion.chat.ChatCompletionResult;
import io.reactivex.Flowable;

public class ChatCompletionService extends BaseOpenAIService {
    public ChatCompletionService(OpenAIConfig config) {
        super(config);
    }

    public ChatCompletionResult createChatCompletion(ChatCompletionRequest request) {
        return execute(api.createChatCompletion(request));
    }

    public Flowable<ChatCompletionChunk> streamChatCompletion(ChatCompletionRequest request) {
        request.setStream(true);
        return stream(api.createChatCompletionStream(request), ChatCompletionChunk.class);
    }
}
