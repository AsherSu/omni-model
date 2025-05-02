package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.ListSearchParameters;
import cn.ashersu.omni.model.OpenAiResponse;
import cn.ashersu.omni.model.messages.Message;
import cn.ashersu.omni.model.messages.MessageFile;
import cn.ashersu.omni.model.messages.MessageRequest;
import cn.ashersu.omni.model.messages.ModifyMessageRequest;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

public class MessageService extends BaseOpenAIService {
    public MessageService(OpenAIConfig config) {
        super(config);
    }

    public Message createMessage(String threadId, MessageRequest request) {
        return execute(api.createMessage(threadId, request));
    }

    public Message retrieveMessage(String threadId, String messageId) {
        return execute(api.retrieveMessage(threadId, messageId));
    }

    public Message modifyMessage(String threadId, String messageId, ModifyMessageRequest request) {
        return execute(api.modifyMessage(threadId, messageId, request));
    }

    public OpenAiResponse<Message> listMessages(String threadId) {
        return execute(api.listMessages(threadId));
    }

    public OpenAiResponse<Message> listMessages(String threadId, ListSearchParameters params) {
        Map<String, Object> queryParameters = mapper.convertValue(params, new TypeReference<Map<String, Object>>() {
        });
        return execute(api.listMessages(threadId, queryParameters));
    }

    public MessageFile retrieveMessageFile(String threadId, String messageId, String fileId) {
        return execute(api.retrieveMessageFile(threadId, messageId, fileId));
    }

    public OpenAiResponse<MessageFile> listMessageFiles(String threadId, String messageId) {
        return execute(api.listMessageFiles(threadId, messageId));
    }

    public OpenAiResponse<MessageFile> listMessageFiles(String threadId, String messageId, ListSearchParameters params) {
        Map<String, Object> queryParameters = mapper.convertValue(params, new TypeReference<Map<String, Object>>() {
        });
        return execute(api.listMessageFiles(threadId, messageId, queryParameters));
    }
}
