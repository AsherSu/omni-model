package cn.ashersu.omni.model.service.openai.item;

import cn.ashersu.omni.model.moderation.ModerationRequest;
import cn.ashersu.omni.model.moderation.ModerationResult;
import cn.ashersu.omni.model.service.openai.BaseOpenAIService;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;

/**
 * 提供OpenAI内容审核相关API调用功能
 */
public class ModerationService extends BaseOpenAIService {
    
    public ModerationService(OpenAIConfig config) {
        super(config);
    }
    
    /**
     * 创建内容审核
     * 
     * @param request 内容审核请求
     * @return 审核结果
     */
    public ModerationResult createModeration(ModerationRequest request) {
        return execute(getApi().createModeration(request));
    }
} 