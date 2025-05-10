package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.DeleteResult;
import cn.ashersu.omni.model.ListSearchParameters;
import cn.ashersu.omni.model.assistants.Assistant;
import cn.ashersu.omni.model.assistants.AssistantFile;
import cn.ashersu.omni.model.assistants.AssistantFileRequest;
import cn.ashersu.omni.model.assistants.AssistantRequest;
import cn.ashersu.omni.model.assistants.ModifyAssistantRequest;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import cn.ashersu.omni.model.service.openai.item.AssistantService;
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

class AssistantServiceTest {
    private MockWebServer server;
    private AssistantService service;

    @BeforeEach
    void setUp() throws Exception {
        server = new MockWebServer();
        server.start();
        OpenAIConfig cfg = OpenAIConfig.builder()
                .baseUrl(server.url("/v1/").toString())
                
                .connectionPool(new ConnectionPool())
                
                .readTimeout(Duration.ofSeconds(1))
                .token("token")
                .build();
        service = new AssistantService(cfg);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testCreateAssistant_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("createAssistant.json"))
                .addHeader("Content-Type", "application/json"));
        Assistant a = service.createAssistant(new AssistantRequest());
        assertNotNull(a);
        assertEquals("assistant-id", a.getId());
        RecordedRequest r = server.takeRequest();
        assertEquals("/v1/assistants", r.getPath());
    }

    @Test
    void testRetrieveAssistant_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("retrieveAssistant.json"))
                .addHeader("Content-Type", "application/json"));
        Assistant a = service.retrieveAssistant("assistant-id");
        assertNotNull(a);
        assertEquals("assistant-id", a.getId());
        RecordedRequest r = server.takeRequest();
        assertEquals("/v1/assistants/assistant-id", r.getPath());
    }

    @Test
    void testModifyAssistant_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("modifyAssistant.json"))
                .addHeader("Content-Type", "application/json"));
        Assistant a = service.modifyAssistant("assistant-id", new ModifyAssistantRequest());
        assertNotNull(a);
        assertEquals("assistant-id", a.getId());
        RecordedRequest r = server.takeRequest();
        assertEquals("/v1/assistants/assistant-id", r.getPath());
    }

    @Test
    void testDeleteAssistant_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("deleteAssistant.json"))
                .addHeader("Content-Type", "application/json"));
        DeleteResult dr = service.deleteAssistant("assistant-id");
        assertNotNull(dr);
        assertTrue(dr.isDeleted());
        RecordedRequest r = server.takeRequest();
        assertEquals("/v1/assistants/assistant-id", r.getPath());
    }

    @Test
    void testListAssistants_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("listAssistants.json"))
                .addHeader("Content-Type", "application/json"));
        assertNotNull(service.listAssistants(new ListSearchParameters()));
        RecordedRequest r = server.takeRequest();
        assertEquals("/v1/assistants", r.getPath());
    }

    @Test
    void testCreateAssistantFile_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("createAssistantFile.json"))
                .addHeader("Content-Type", "application/json"));
        AssistantFile f = service.createAssistantFile("assistant-id", new AssistantFileRequest());
        assertNotNull(f);
        assertEquals("file-id", f.getId());
        RecordedRequest r = server.takeRequest();
        assertEquals("/v1/assistants/assistant-id/files", r.getPath());
    }

    @Test
    void testRetrieveAssistantFile_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("retrieveAssistantFile.json"))
                .addHeader("Content-Type", "application/json"));
        AssistantFile f = service.retrieveAssistantFile("assistant-id", "file-id");
        assertNotNull(f);
        assertEquals("file-id", f.getId());
        RecordedRequest r = server.takeRequest();
        assertEquals("/v1/assistants/assistant-id/files/file-id", r.getPath());
    }

    @Test
    void testDeleteAssistantFile_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("deleteAssistantFile.json"))
                .addHeader("Content-Type", "application/json"));
        DeleteResult dr = service.deleteAssistantFile("assistant-id", "file-id");
        assertNotNull(dr);
        assertTrue(dr.isDeleted());
        RecordedRequest r = server.takeRequest();
        assertEquals("/v1/assistants/assistant-id/files/file-id", r.getPath());
    }

    @Test
    void testListAssistantFiles_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("listAssistantFiles.json"))
                .addHeader("Content-Type", "application/json"));
        assertNotNull(service.listAssistantFiles("assistant-id", new ListSearchParameters()));
        RecordedRequest r = server.takeRequest();
        assertEquals("/v1/assistants/assistant-id/files", r.getPath());
    }
} 