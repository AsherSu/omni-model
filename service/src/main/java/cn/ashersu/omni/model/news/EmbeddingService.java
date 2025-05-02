package cn.ashersu.omni.model.news;

import cn.ashersu.omni.model.embedding.EmbeddingRequest;
import cn.ashersu.omni.model.embedding.EmbeddingResult;

/**
 * 提供OpenAI嵌入(Embeddings)相关API调用功能
 */
public class EmbeddingService extends BaseOpenAIService {
    
    public EmbeddingService(OpenAIConfig config) {
        super(config);
    }
    
    /**
     * 创建文本嵌入
     * 
     * @param request 嵌入请求
     * @return 嵌入结果
     */
    public EmbeddingResult createEmbeddings(EmbeddingRequest request) {
        return execute(api.createEmbeddings(request));
    }
} 