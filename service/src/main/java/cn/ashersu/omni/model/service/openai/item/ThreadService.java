package cn.ashersu.omni.model.service.openai.item;

import cn.ashersu.omni.model.DeleteResult;
import cn.ashersu.omni.model.service.openai.BaseOpenAIService;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import cn.ashersu.omni.model.threads.Thread;
import cn.ashersu.omni.model.threads.ThreadRequest;

/**
 * 提供OpenAI线程相关API调用功能
 */
public class ThreadService extends BaseOpenAIService {
    
    public ThreadService(OpenAIConfig config) {
        super(config);
    }
    
    /**
     * 创建线程
     * 
     * @param request 线程创建请求
     * @return 创建的线程
     */
    public Thread createThread(ThreadRequest request) {
        return execute(getApi().createThread(request));
    }
    
    /**
     * 获取线程
     * 
     * @param threadId 线程ID
     * @return 线程
     */
    public Thread retrieveThread(String threadId) {
        return execute(getApi().retrieveThread(threadId));
    }
    
    /**
     * 修改线程
     * 
     * @param threadId 线程ID
     * @param request 修改请求
     * @return 修改后的线程
     */
    public Thread modifyThread(String threadId, ThreadRequest request) {
        return execute(getApi().modifyThread(threadId, request));
    }
    
    /**
     * 删除线程
     * 
     * @param threadId 线程ID
     * @return 删除结果
     */
    public DeleteResult deleteThread(String threadId) {
        return execute(getApi().deleteThread(threadId));
    }
} 