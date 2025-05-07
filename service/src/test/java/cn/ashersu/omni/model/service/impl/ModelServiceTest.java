package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.model.Model;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.ConnectionPool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import cn.ashersu.omni.model.service.impl.testutil.JsonMockLoader;

class ModelServiceTest {
    private MockWebServer server;
    private ModelService service;

    @BeforeEach
    void setUp() throws Exception {
        server = new MockWebServer();
        server.start();

        String mockJson = JsonMockLoader.json("listModels.json");
        server.enqueue(new MockResponse()
                .setBody(mockJson)
                .addHeader("Content-Type", "application/json"));

        OpenAIConfig cfg = OpenAIConfig.builder()
                .baseUrl(server.url("/v1/").toString())
                .connectTimeout(1)
                .connectionPool(new ConnectionPool())
                .maxIdleConnection(1)
                .readTimeout(Duration.ofSeconds(1))
                .token("token")
                .build();
        service = new ModelService(cfg);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testListModels_viaHttpMock() throws InterruptedException {
        List<Model> list = service.listModels();
        assertNotNull(list);
        assertTrue(list.size() > 0);

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/models", recorded.getPath());
    }

    @Test
    void testGetModel_viaHttpMock() throws InterruptedException {
        String mockJson = JsonMockLoader.json("getModel.json");
        server.enqueue(new MockResponse()
                .setBody(mockJson)
                .addHeader("Content-Type", "application/json"));

        Model model = service.getModel("model-id");
        assertNotNull(model);
        assertEquals("model-id", model.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/models/model-id", recorded.getPath());
    }
} 