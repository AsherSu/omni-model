package cn.ashersu.omni.model.service.openai.item;

import cn.ashersu.omni.model.completion.chat.ChatCompletionChunk;
import cn.ashersu.omni.model.completion.chat.ChatCompletionRequest;
import cn.ashersu.omni.model.completion.chat.ChatCompletionResult;
import cn.ashersu.omni.model.service.openai.BaseOpenAIService;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import io.reactivex.Flowable;

public class ChatCompletionService extends BaseOpenAIService {
    public ChatCompletionService(OpenAIConfig config) {
        super(config);
    }

    public ChatCompletionResult createChatCompletion(ChatCompletionRequest request) {
        return execute(getApi().createChatCompletion(request));
    }

    public Flowable<ChatCompletionChunk> streamChatCompletion(ChatCompletionRequest request) {
        request.setStream(true);
        return stream(getApi().createChatCompletionStream(request), ChatCompletionChunk.class);
    }
}
