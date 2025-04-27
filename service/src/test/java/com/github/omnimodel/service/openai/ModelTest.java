package cn.ashersu.omni.model.service.openai;

import cn.ashersu.omni.model.model.Model;
import cn.ashersu.omni.model.service.AliService;
import cn.ashersu.omni.model.service.OpenAiService;
import cn.ashersu.omni.model.service.TestConfig;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class ModelTest {

    String token = TestConfig.getOpenAiApiKey();
    OpenAiService service = new OpenAiService(token);
    AliService aliService = new AliService(token);

    @Test
    void listModels() {
        List<Model> models = aliService.listModels();

        assertFalse(models.isEmpty());
    }

    @Test
    void getModel() {
        Model model = service.getModel("babbage-002");

        assertEquals("babbage-002", model.id);
        assertEquals("system", model.ownedBy);
    }
}
