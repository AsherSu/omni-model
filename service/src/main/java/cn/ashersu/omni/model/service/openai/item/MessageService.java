package cn.ashersu.omni.model.service.openai.item;

import cn.ashersu.omni.model.ListSearchParameters;
import cn.ashersu.omni.model.OpenAiResponse;
import cn.ashersu.omni.model.messages.Message;
import cn.ashersu.omni.model.messages.MessageFile;
import cn.ashersu.omni.model.messages.MessageRequest;
import cn.ashersu.omni.model.messages.ModifyMessageRequest;
import cn.ashersu.omni.model.service.openai.BaseOpenAIService;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

public class MessageService extends BaseOpenAIService {
    public MessageService(OpenAIConfig config) {
        super(config);
    }

    public Message createMessage(String threadId, MessageRequest request) {
        return execute(getApi().createMessage(threadId, request));
    }

    public Message retrieveMessage(String threadId, String messageId) {
        return execute(getApi().retrieveMessage(threadId, messageId));
    }

    public Message modifyMessage(String threadId, String messageId, ModifyMessageRequest request) {
        return execute(getApi().modifyMessage(threadId, messageId, request));
    }

    public OpenAiResponse<Message> listMessages(String threadId) {
        return execute(getApi().listMessages(threadId));
    }

    public OpenAiResponse<Message> listMessages(String threadId, ListSearchParameters params) {
        Map<String, Object> queryParameters = getMapper().convertValue(params, new TypeReference<Map<String, Object>>() {
        });
        return execute(getApi().listMessages(threadId, queryParameters));
    }

    public MessageFile retrieveMessageFile(String threadId, String messageId, String fileId) {
        return execute(getApi().retrieveMessageFile(threadId, messageId, fileId));
    }

    public OpenAiResponse<MessageFile> listMessageFiles(String threadId, String messageId) {
        return execute(getApi().listMessageFiles(threadId, messageId));
    }

    public OpenAiResponse<MessageFile> listMessageFiles(String threadId, String messageId, ListSearchParameters params) {
        Map<String, Object> queryParameters = getMapper().convertValue(params, new TypeReference<Map<String, Object>>() {
        });
        return execute(getApi().listMessageFiles(threadId, messageId, queryParameters));
    }
}
