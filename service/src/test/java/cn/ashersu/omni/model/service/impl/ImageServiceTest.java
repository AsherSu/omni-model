package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.image.CreateImageRequest;
import cn.ashersu.omni.model.image.ImageResult;
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

class ImageServiceTest {
    private MockWebServer server;
    private ImageService service;

    @BeforeEach
    void setUp() throws Exception {
        server = new MockWebServer();
        server.start();

        String mockJson = JsonMockLoader.json("createImage.json");
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
        service = new ImageService(cfg);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testCreateImage_viaHttpMock() throws InterruptedException {
        CreateImageRequest req = new CreateImageRequest();
        ImageResult res = service.createImage(req);

        assertNotNull(res);
        // 根据 mock JSON 验证字段
        assertEquals("http://mock.url/image.png", res.getData().get(0).getUrl());

        RecordedRequest request = server.takeRequest();
        assertEquals("/v1/images/generations", request.getPath());
        assertTrue(request.getBody().readUtf8().contains("\"prompt\""));
    }
} 