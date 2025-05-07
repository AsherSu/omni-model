package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.fine_tuning.FineTuningJob;
import cn.ashersu.omni.model.fine_tuning.FineTuningJobRequest;
import okhttp3.ConnectionPool;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import cn.ashersu.omni.model.service.impl.testutil.JsonMockLoader;

class FineTuningServiceTest {
    private MockWebServer server;
    private FineTuningService service;

    @BeforeEach
    void setUp() throws Exception {
        server = new MockWebServer();
        server.start();

        // mock createFineTuningJob
        String createJson = JsonMockLoader.json("createFineTuningJob.json");
        server.enqueue(new MockResponse()
                .setBody(createJson)
                .addHeader("Content-Type", "application/json"));

        OpenAIConfig cfg = OpenAIConfig.builder()
                .baseUrl(server.url("/v1/").toString())
                .connectTimeout(1)
                .connectionPool(new ConnectionPool())
                .maxIdleConnection(1)
                .readTimeout(Duration.ofSeconds(1))
                .token("token")
                .build();
        service = new FineTuningService(cfg);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testCreateFineTuningJob_viaHttpMock() throws InterruptedException {
        FineTuningJobRequest req = new FineTuningJobRequest();
        FineTuningJob job = service.createFineTuningJob(req);

        assertNotNull(job);
        // 根据 mock JSON 验证字段
        assertEquals("mock-job-id", job.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/fine_tuning/jobs", recorded.getPath());
        assertTrue(recorded.getBody().readUtf8().contains("\"training_file\""));
    }

    @Test
    void testListFineTuningJobs_viaHttpMock() throws InterruptedException {
        String listJson = JsonMockLoader.json("listFineTuningJobs.json");
        server.enqueue(new MockResponse()
                .setBody(listJson)
                .addHeader("Content-Type", "application/json"));

        List<FineTuningJob> list = service.listFineTuningJobs();
        assertNotNull(list);
        assertTrue(list.size() > 0);

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/fine_tuning/jobs", recorded.getPath());
    }
} 