package cn.ashersu.omni.model.news;

import cn.ashersu.omni.model.DeleteResult;
import cn.ashersu.omni.model.completion.CompletionRequest;
import cn.ashersu.omni.model.completion.CompletionResult;
import cn.ashersu.omni.model.fine_tuning.FineTuningEvent;
import cn.ashersu.omni.model.fine_tuning.FineTuningJob;
import cn.ashersu.omni.model.fine_tuning.FineTuningJobRequest;

import java.util.List;

public class FineTuningService extends BaseOpenAIService {
    public FineTuningService(OpenAIConfig config) {
        super(config);
    }

    public FineTuningJob createFineTuningJob(FineTuningJobRequest request) {
        return execute(api.createFineTuningJob(request));
    }

    public List<FineTuningJob> listFineTuningJobs() {
        return execute(api.listFineTuningJobs()).data;
    }

    public FineTuningJob retrieveFineTuningJob(String fineTuningJobId) {
        return execute(api.retrieveFineTuningJob(fineTuningJobId));
    }

    public FineTuningJob cancelFineTuningJob(String fineTuningJobId) {
        return execute(api.cancelFineTuningJob(fineTuningJobId));
    }

    public List<FineTuningEvent> listFineTuningJobEvents(String fineTuningJobId) {
        return execute(api.listFineTuningJobEvents(fineTuningJobId)).data;
    }

    public CompletionResult createFineTuneCompletion(CompletionRequest request) {
        return execute(api.createFineTuneCompletion(request));
    }

    public DeleteResult deleteFineTune(String fineTuneId) {
        return execute(api.deleteFineTune(fineTuneId));
    }

}
