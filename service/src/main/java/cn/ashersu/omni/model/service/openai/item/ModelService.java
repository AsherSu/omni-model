package cn.ashersu.omni.model.service.openai.item;

import cn.ashersu.omni.model.model.Model;
import cn.ashersu.omni.model.service.openai.BaseOpenAIService;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;

import java.util.List;

public class ModelService extends BaseOpenAIService {

    public ModelService(OpenAIConfig config) {
        super(config);
    }

    public List<Model> listModels() {
        return execute(getApi().listModels()).getData();
    }

    public Model getModel(String modelId) {
        return execute(getApi().getModel(modelId));
    }
}
