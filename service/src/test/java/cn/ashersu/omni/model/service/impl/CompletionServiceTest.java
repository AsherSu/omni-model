package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.completion.CompletionRequest;
import cn.ashersu.omni.model.completion.CompletionResult;
import cn.ashersu.omni.model.completion.CompletionChunk;
import cn.ashersu.omni.model.edit.EditRequest;
import cn.ashersu.omni.model.edit.EditResult;
import cn.ashersu.omni.model.completion.chat.ChatCompletionChunk;
import cn.ashersu.omni.model.service.ChatMessageAccumulator;
import io.reactivex.Flowable;
import okhttp3.ConnectionPool;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import cn.ashersu.omni.model.service.impl.testutil.JsonMockLoader;

class CompletionServiceTest {
    private MockWebServer server;
    private CompletionService service;

    @BeforeEach
    void setUp() throws Exception {
        server = new MockWebServer();
        server.start();
        OpenAIConfig cfg = OpenAIConfig.builder()
                .baseUrl(server.url("/v1/").toString())
                .connectTimeout(1)
                .connectionPool(new ConnectionPool())
                .maxIdleConnection(1)
                .readTimeout(Duration.ofSeconds(1))
                .token("token")
                .build();
        service = new CompletionService(cfg);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testCreateCompletion_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("createCompletion.json"))
                .addHeader("Content-Type", "application/json"));
        CompletionRequest req = new CompletionRequest();
        CompletionResult res = service.createCompletion(req);
        assertNotNull(res);
        assertEquals("cmpl-abc", res.getId());
        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/chat/completions", recorded.getPath());
    }

    @Test
    void testCreateEdit_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("createEdit.json"))
                .addHeader("Content-Type", "application/json"));
        EditRequest req = new EditRequest();
        EditResult res = service.createEdit(req);
        assertNotNull(res);
        assertNotNull(res.getChoices());
        assertFalse(res.getChoices().isEmpty());
        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/edits", recorded.getPath());
    }

    @Test
    void testMapStreamToAccumulator_empty() {
        Flowable<ChatMessageAccumulator> result = new CompletionService(
                OpenAIConfig.builder().baseUrl("").connectTimeout(1)
                        .connectionPool(new ConnectionPool())
                        .maxIdleConnection(1)
                        .readTimeout(Duration.ofSeconds(1))
                        .token("token").build()
        ).mapStreamToAccumulator(Flowable.empty());
        assertNotNull(result);
    }
} 