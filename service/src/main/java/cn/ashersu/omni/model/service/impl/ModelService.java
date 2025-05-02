package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.model.Model;

import java.util.List;

public class ModelService extends BaseOpenAIService {

    public ModelService(OpenAIConfig config) {
        super(config);
    }

    public List<Model> listModels() {
        return execute(api.listModels()).data;
    }

    public Model getModel(String modelId) {
        return execute(api.getModel(modelId));
    }
}
