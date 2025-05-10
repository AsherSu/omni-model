package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.embedding.EmbeddingRequest;
import cn.ashersu.omni.model.embedding.EmbeddingResult;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import cn.ashersu.omni.model.service.openai.item.EmbeddingService;
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

class EmbeddingServiceTest {
    private MockWebServer server;
    private EmbeddingService service;

    @BeforeEach
    void setUp() throws Exception {
        server = new MockWebServer();
        server.start();

        String mockJson = JsonMockLoader.json("createEmbeddings.json");
        server.enqueue(new MockResponse()
                .setBody(mockJson)
                .addHeader("Content-Type", "application/json"));

        OpenAIConfig cfg = OpenAIConfig.builder()
                .baseUrl(server.url("/v1/").toString())
                
                .connectionPool(new ConnectionPool())
                
                .readTimeout(Duration.ofSeconds(1))
                .token("token")
                .build();
        service = new EmbeddingService(cfg);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testCreateEmbeddings_viaHttpMock() throws InterruptedException {
        EmbeddingRequest req = new EmbeddingRequest();
        EmbeddingResult res = service.createEmbeddings(req);

        assertNotNull(res);
        assertNotNull(res.getData());
        assertTrue(res.getData().size() > 0);

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/embeddings", recorded.getPath());
        assertTrue(recorded.getBody().readUtf8().contains("\"model\""));
    }
} 