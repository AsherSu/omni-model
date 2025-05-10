package cn.ashersu.omni.model.service.openai.item;

import cn.ashersu.omni.model.DeleteResult;
import cn.ashersu.omni.model.completion.CompletionRequest;
import cn.ashersu.omni.model.completion.CompletionResult;
import cn.ashersu.omni.model.fine_tuning.FineTuningEvent;
import cn.ashersu.omni.model.fine_tuning.FineTuningJob;
import cn.ashersu.omni.model.fine_tuning.FineTuningJobRequest;
import cn.ashersu.omni.model.service.openai.BaseOpenAIService;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;

import java.util.List;

public class FineTuningService extends BaseOpenAIService {
    public FineTuningService(OpenAIConfig config) {
        super(config);
    }

    public FineTuningJob createFineTuningJob(FineTuningJobRequest request) {
        return execute(getApi().createFineTuningJob(request));
    }

    public List<FineTuningJob> listFineTuningJobs() {
        return execute(getApi().listFineTuningJobs()).getData();
    }

    public FineTuningJob retrieveFineTuningJob(String fineTuningJobId) {
        return execute(getApi().retrieveFineTuningJob(fineTuningJobId));
    }

    public FineTuningJob cancelFineTuningJob(String fineTuningJobId) {
        return execute(getApi().cancelFineTuningJob(fineTuningJobId));
    }

    public List<FineTuningEvent> listFineTuningJobEvents(String fineTuningJobId) {
        return execute(getApi().listFineTuningJobEvents(fineTuningJobId)).getData();
    }

    public CompletionResult createFineTuneCompletion(CompletionRequest request) {
        return execute(getApi().createFineTuneCompletion(request));
    }

    public DeleteResult deleteFineTune(String fineTuneId) {
        return execute(getApi().deleteFineTune(fineTuneId));
    }

}
