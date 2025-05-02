package cn.ashersu.omni.model.news;

import cn.ashersu.omni.model.ListSearchParameters;
import cn.ashersu.omni.model.OpenAiResponse;
import cn.ashersu.omni.model.runs.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 提供OpenAI运行相关API调用功能
 */
public class RunService extends BaseOpenAIService {
    
    public RunService(OpenAIConfig config) {
        super(config);
    }
    
    /**
     * 创建运行
     * 
     * @param threadId 线程ID
     * @param runCreateRequest 运行创建请求
     * @return 创建的运行
     */
    public Run createRun(String threadId, RunCreateRequest runCreateRequest) {
        return execute(api.createRun(threadId, runCreateRequest));
    }
    
    /**
     * 获取运行
     * 
     * @param threadId 线程ID
     * @param runId 运行ID
     * @return 运行
     */
    public Run retrieveRun(String threadId, String runId) {
        return execute(api.retrieveRun(threadId, runId));
    }
    
    /**
     * 修改运行
     * 
     * @param threadId 线程ID
     * @param runId 运行ID
     * @param metadata 元数据
     * @return 修改后的运行
     */
    public Run modifyRun(String threadId, String runId, Map<String, String> metadata) {
        return execute(api.modifyRun(threadId, runId, metadata));
    }
    
    /**
     * 列出运行
     * 
     * @param threadId 线程ID
     * @param listSearchParameters 搜索参数
     * @return 运行列表
     */
    public OpenAiResponse<Run> listRuns(String threadId, ListSearchParameters listSearchParameters) {
        Map<String, String> search = new HashMap<>();
        if (listSearchParameters != null) {
            ObjectMapper mapper = defaultObjectMapper();
            search = mapper.convertValue(listSearchParameters, Map.class);
        }
        return execute(api.listRuns(threadId, search));
    }
    
    /**
     * 提交工具输出
     * 
     * @param threadId 线程ID
     * @param runId 运行ID
     * @param submitToolOutputsRequest 工具输出提交请求
     * @return 更新后的运行
     */
    public Run submitToolOutputs(String threadId, String runId, SubmitToolOutputsRequest submitToolOutputsRequest) {
        return execute(api.submitToolOutputs(threadId, runId, submitToolOutputsRequest));
    }
    
    /**
     * 取消运行
     * 
     * @param threadId 线程ID
     * @param runId 运行ID
     * @return 取消后的运行
     */
    public Run cancelRun(String threadId, String runId) {
        return execute(api.cancelRun(threadId, runId));
    }
    
    /**
     * 创建线程和运行
     * 
     * @param createThreadAndRunRequest 创建线程和运行请求
     * @return 运行
     */
    public Run createThreadAndRun(CreateThreadAndRunRequest createThreadAndRunRequest) {
        return execute(api.createThreadAndRun(createThreadAndRunRequest));
    }
    
    /**
     * 获取运行步骤
     * 
     * @param threadId 线程ID
     * @param runId 运行ID
     * @param stepId 步骤ID
     * @return 运行步骤
     */
    public RunStep retrieveRunStep(String threadId, String runId, String stepId) {
        return execute(api.retrieveRunStep(threadId, runId, stepId));
    }
    
    /**
     * 列出运行步骤
     * 
     * @param threadId 线程ID
     * @param runId 运行ID
     * @param listSearchParameters 搜索参数
     * @return 运行步骤列表
     */
    public OpenAiResponse<RunStep> listRunSteps(String threadId, String runId, ListSearchParameters listSearchParameters) {
        Map<String, String> search = new HashMap<>();
        if (listSearchParameters != null) {
            ObjectMapper mapper = defaultObjectMapper();
            search = mapper.convertValue(listSearchParameters, Map.class);
        }
        return execute(api.listRunSteps(threadId, runId, search));
    }
} 