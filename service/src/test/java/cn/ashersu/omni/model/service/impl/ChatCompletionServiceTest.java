package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.completion.chat.ChatCompletionRequest;
import cn.ashersu.omni.model.completion.chat.ChatCompletionResult;
import cn.ashersu.omni.model.completion.chat.ChatMessage;
import cn.ashersu.omni.model.service.impl.testutil.JsonMockLoader;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import cn.ashersu.omni.model.service.openai.item.ChatCompletionService;
import okhttp3.ConnectionPool;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChatCompletionServiceTest {
    private MockWebServer server;
    private ChatCompletionService service;

    @BeforeEach
    void setUp() throws Exception {
        server = new MockWebServer();
        server.start();

        // enqueue mock response
        String mockJson = JsonMockLoader.json("chatCompletion.json");
        server.enqueue(new MockResponse()
                .setBody(mockJson)
                .addHeader("Content-Type", "application/json"));

        OpenAIConfig cfg = OpenAIConfig.builder()
                .baseUrl(server.url("/v1/").toString())
                .connectionPool(new ConnectionPool())
                .readTimeout(Duration.ofSeconds(1))
                .token("token")
                .build();
        service = new ChatCompletionService(cfg);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testCreateChatCompletion_viaHttpMock() throws InterruptedException {
        ChatCompletionRequest req = ChatCompletionRequest.builder()
                .model("test-model")
                .messages(Collections.singletonList(new ChatMessage("user", "Hello")))
                .build();
        ChatCompletionResult res = service.createChatCompletion(req);

        assertNotNull(res);
        assertEquals("Hello from mock!", res.getChoices().get(0).getMessage().getContent());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/chat/completions", recorded.getPath());
        assertTrue(recorded.getBody().readUtf8().contains("\"model\":\"test-model\""));
    }
} 