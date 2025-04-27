package cn.ashersu.omni.model.service.openai;

import cn.ashersu.omni.model.OpenAiResponse;
import cn.ashersu.omni.model.assistants.Assistant;
import cn.ashersu.omni.model.assistants.AssistantRequest;
import cn.ashersu.omni.model.messages.Message;
import cn.ashersu.omni.model.messages.MessageRequest;
import cn.ashersu.omni.model.runs.Run;
import cn.ashersu.omni.model.runs.RunCreateRequest;
import cn.ashersu.omni.model.service.OpenAiService;
import cn.ashersu.omni.model.service.TestConfig;
import cn.ashersu.omni.model.threads.Thread;
import cn.ashersu.omni.model.threads.ThreadRequest;
import cn.ashersu.omni.model.utils.TikTokensUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RunTest {
    String token = TestConfig.getOpenAiApiKey();
    OpenAiService service = new OpenAiService(token);

    @Test
    @Timeout(10)
    void createRetrieveRun() {
        AssistantRequest assistantRequest = AssistantRequest.builder()
                .model(TikTokensUtil.ModelEnum.GPT_4_1106_preview.getName())
                .name("MATH_TUTOR")
                .instructions("You are a personal Math Tutor.")
                .build();
        Assistant assistant = service.createAssistant(assistantRequest);

        ThreadRequest threadRequest = ThreadRequest.builder()
                .build();
        Thread thread = service.createThread(threadRequest);

        MessageRequest messageRequest = MessageRequest.builder()
                .content("Hello")
                .build();

        Message message = service.createMessage(thread.getId(), messageRequest);

        RunCreateRequest runCreateRequest = RunCreateRequest.builder()
                .assistantId(assistant.getId())
                .build();

        Run run = service.createRun(thread.getId(), runCreateRequest);
        assertNotNull(run);

        Run retrievedRun;
        do {
            retrievedRun = service.retrieveRun(thread.getId(), run.getId());
            assertEquals(run.getId(), retrievedRun.getId());
        }
        while (!(retrievedRun.getStatus().equals("completed")) && !(retrievedRun.getStatus().equals("failed")));


        assertNotNull(retrievedRun);

        OpenAiResponse<Message> response = service.listMessages(thread.getId());

        List<Message> messages = response.getData();
        assertEquals(2, messages.size());
        assertEquals("user", messages.get(1).getRole());
        assertEquals("assistant", messages.get(0).getRole());
    }
}
