package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.threads.Thread;
import cn.ashersu.omni.model.threads.ThreadRequest;
import okhttp3.ConnectionPool;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import cn.ashersu.omni.model.DeleteResult;
import cn.ashersu.omni.model.service.impl.testutil.JsonMockLoader;

class ThreadServiceTest {
    private MockWebServer server;
    private ThreadService service;

    @BeforeEach
    void setUp() throws Exception {
        server = new MockWebServer();
        server.start();

        // mock createThread
        String createJson = JsonMockLoader.json("createThread.json");
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
        service = new ThreadService(cfg);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testCreateThread_viaHttpMock() throws InterruptedException {
        ThreadRequest req = new ThreadRequest();
        Thread thread = service.createThread(req);

        assertNotNull(thread);
        assertEquals("mock-thread-id", thread.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads", recorded.getPath());
    }

    @Test
    void testRetrieveThread_viaHttpMock() throws InterruptedException {
        String retrieveJson = JsonMockLoader.json("retrieveThread.json");
        server.enqueue(new MockResponse()
                .setBody(retrieveJson)
                .addHeader("Content-Type", "application/json"));

        Thread thread = service.retrieveThread("thread-id");
        assertNotNull(thread);
        assertEquals("thread-id", thread.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id", recorded.getPath());
    }

    @Test
    void testModifyThread_viaHttpMock() throws InterruptedException {
        String modifyJson = JsonMockLoader.json("modifyThread.json");
        server.enqueue(new MockResponse()
                .setBody(modifyJson)
                .addHeader("Content-Type", "application/json"));

        ThreadRequest req = new ThreadRequest();
        Thread thread = service.modifyThread("thread-id", req);
        assertNotNull(thread);
        assertEquals("thread-id", thread.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id", recorded.getPath());
    }

    @Test
    void testDeleteThread_viaHttpMock() throws InterruptedException {
        String deleteJson = JsonMockLoader.json("deleteThread.json");
        server.enqueue(new MockResponse()
                .setBody(deleteJson)
                .addHeader("Content-Type", "application/json"));

        DeleteResult result = service.deleteThread("thread-id");
        assertNotNull(result);
        assertTrue(result.isDeleted());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id", recorded.getPath());
    }
} 