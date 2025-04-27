package cn.ashersu.omni.model.service.openai;

import cn.ashersu.omni.model.moderation.Moderation;
import cn.ashersu.omni.model.moderation.ModerationRequest;
import cn.ashersu.omni.model.service.OpenAiService;
import cn.ashersu.omni.model.service.TestConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ModerationTest {

    String token = TestConfig.getOpenAiApiKey();
    OpenAiService service = new OpenAiService(token);

    @Test
    void createModeration() {
        ModerationRequest moderationRequest = ModerationRequest.builder()
                .input("I want to kill him")
                .model("text-moderation-latest")
                .build();

        Moderation moderationScore = service.createModeration(moderationRequest).getResults().get(0);

        assertTrue(moderationScore.isFlagged());
    }
}
