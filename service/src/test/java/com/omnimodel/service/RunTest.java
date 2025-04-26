package com.omnimodel.service;

import com.omnimodel.OpenAiResponse;
import com.omnimodel.assistants.Assistant;
import com.omnimodel.assistants.AssistantRequest;
import com.omnimodel.messages.Message;
import com.omnimodel.messages.MessageRequest;
import com.omnimodel.runs.Run;
import com.omnimodel.runs.RunCreateRequest;
import com.omnimodel.threads.Thread;
import com.omnimodel.threads.ThreadRequest;
import com.omnimodel.utils.TikTokensUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RunTest {
    String token = TestConfig.getApiKey();
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
