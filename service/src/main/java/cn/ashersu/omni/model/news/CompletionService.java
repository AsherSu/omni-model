package cn.ashersu.omni.model.news;

import cn.ashersu.omni.model.completion.CompletionChunk;
import cn.ashersu.omni.model.completion.CompletionRequest;
import cn.ashersu.omni.model.completion.CompletionResult;
import cn.ashersu.omni.model.completion.chat.*;
import cn.ashersu.omni.model.edit.EditRequest;
import cn.ashersu.omni.model.edit.EditResult;
import io.reactivex.Flowable;

public final class CompletionService extends BaseOpenAIService {

    public CompletionService(OpenAIConfig config) {
        super(config);
    }

    public CompletionResult createCompletion(CompletionRequest request) {
        return execute(api.createCompletion(request));
    }

    public Flowable<CompletionChunk> streamCompletion(CompletionRequest request) {
        request.setStream(true);
        return stream(api.createCompletionStream(request), CompletionChunk.class);
    }

    public ChatCompletionResult createChatCompletion(ChatCompletionRequest request) {
        return execute(api.createChatCompletion(request));
    }

    public Flowable<ChatCompletionChunk> streamChatCompletion(ChatCompletionRequest request) {
        request.setStream(true);
        return stream(api.createChatCompletionStream(request), ChatCompletionChunk.class);
    }

    public EditResult createEdit(EditRequest request) {
        return execute(api.createEdit(request));
    }

}

