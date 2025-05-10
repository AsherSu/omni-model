package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.file.File;
import cn.ashersu.omni.model.service.impl.testutil.JsonMockLoader;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import cn.ashersu.omni.model.service.openai.item.FileService;
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

class FileServiceTest {
    private MockWebServer server;
    private FileService service;

    @BeforeEach
    void setUp() throws Exception {
        server = new MockWebServer();
        server.start();

        // mock listFiles
        String listJson = JsonMockLoader.json("listFiles.json");
        server.enqueue(new MockResponse()
                .setBody(listJson)
                .addHeader("Content-Type", "application/json"));

        OpenAIConfig cfg = OpenAIConfig.builder()
                .baseUrl(server.url("/v1/").toString())
                
                .connectionPool(new ConnectionPool())
                
                .readTimeout(Duration.ofSeconds(1))
                .token("token")
                .build();
        service = new FileService(cfg);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testListFiles_viaHttpMock() throws InterruptedException {
        List<File> files = service.listFiles();
        assertNotNull(files);
        assertEquals("file-1", files.get(0).getId());

        RecordedRequest request = server.takeRequest();
        assertEquals("/v1/files", request.getPath());
    }
} 