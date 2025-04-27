package cn.ashersu.omni.model.service.openai;

import cn.ashersu.omni.model.OpenAiHttpException;
import cn.ashersu.omni.model.edit.EditRequest;
import cn.ashersu.omni.model.edit.EditResult;
import cn.ashersu.omni.model.service.OpenAiService;
import cn.ashersu.omni.model.service.TestConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EditTest {

    String token = TestConfig.getOpenAiApiKey();
    OpenAiService service = new OpenAiService(token);

    @Test
    void edit() throws OpenAiHttpException {
        EditRequest request = EditRequest.builder()
                .model("text-davinci-edit-001")
                .input("What day of the wek is it?")
                .instruction("Fix the spelling mistakes")
                .build();

        EditResult result = service.createEdit(request);
        assertNotNull(result.getChoices().get(0).getText());
    }
}
