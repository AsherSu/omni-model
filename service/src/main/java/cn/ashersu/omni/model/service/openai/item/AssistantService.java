package cn.ashersu.omni.model.service.openai.item;

import cn.ashersu.omni.model.DeleteResult;
import cn.ashersu.omni.model.ListSearchParameters;
import cn.ashersu.omni.model.OpenAiResponse;
import cn.ashersu.omni.model.assistants.*;
import cn.ashersu.omni.model.service.openai.BaseOpenAIService;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

public class AssistantService extends BaseOpenAIService {
    public AssistantService(OpenAIConfig config) {
        super(config);
    }

    public Assistant createAssistant(AssistantRequest request) {
        return execute(getApi().createAssistant(request));
    }

    public Assistant retrieveAssistant(String assistantId) {
        return execute(getApi().retrieveAssistant(assistantId));
    }

    public Assistant modifyAssistant(String assistantId, ModifyAssistantRequest request) {
        return execute(getApi().modifyAssistant(assistantId, request));
    }

    public DeleteResult deleteAssistant(String assistantId) {
        return execute(getApi().deleteAssistant(assistantId));
    }

    public OpenAiResponse<Assistant> listAssistants(ListSearchParameters params) {
        Map<String, Object> queryParameters = getMapper().convertValue(params, new TypeReference<Map<String, Object>>() {
        });
        return execute(getApi().listAssistants(queryParameters));
    }

    public AssistantFile createAssistantFile(String assistantId, AssistantFileRequest fileRequest) {
        return execute(getApi().createAssistantFile(assistantId, fileRequest));
    }

    public AssistantFile retrieveAssistantFile(String assistantId, String fileId) {
        return execute(getApi().retrieveAssistantFile(assistantId, fileId));
    }

    public DeleteResult deleteAssistantFile(String assistantId, String fileId) {
        return execute(getApi().deleteAssistantFile(assistantId, fileId));
    }

    public OpenAiResponse<AssistantFile> listAssistantFiles(String assistantId, ListSearchParameters params) {
        Map<String, Object> queryParameters = getMapper().convertValue(params, new TypeReference<Map<String, Object>>() {
        });
        return execute(getApi().listAssistantFiles(assistantId, queryParameters));
    }
}
