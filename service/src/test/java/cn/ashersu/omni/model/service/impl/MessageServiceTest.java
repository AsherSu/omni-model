package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.ListSearchParameters;
import cn.ashersu.omni.model.messages.Message;
import cn.ashersu.omni.model.messages.MessageFile;
import cn.ashersu.omni.model.messages.MessageRequest;
import cn.ashersu.omni.model.messages.ModifyMessageRequest;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import cn.ashersu.omni.model.service.openai.item.MessageService;
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

class MessageServiceTest {
    private MockWebServer server;
    private MessageService service;

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
        service = new MessageService(cfg);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testCreateMessage_viaHttpMock() throws InterruptedException {
        String mockJson = JsonMockLoader.json("createMessage.json");
        server.enqueue(new MockResponse()
                .setBody(mockJson)
                .addHeader("Content-Type", "application/json"));

        Message msg = service.createMessage("thread-id", new MessageRequest());
        assertNotNull(msg);
        assertEquals("mock-message-id", msg.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/messages", recorded.getPath());
        assertTrue(recorded.getBody().readUtf8().contains("\"thread_id\""));
    }

    @Test
    void testRetrieveMessage_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("retrieveMessage.json"))
                .addHeader("Content-Type", "application/json"));

        Message msg = service.retrieveMessage("thread-id", "message-id");
        assertNotNull(msg);
        assertEquals("message-id", msg.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/messages/message-id", recorded.getPath());
    }

    @Test
    void testModifyMessage_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("modifyMessage.json"))
                .addHeader("Content-Type", "application/json"));

        Message msg = service.modifyMessage("thread-id", "message-id", new ModifyMessageRequest());
        assertNotNull(msg);
        assertEquals("message-id", msg.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/messages/message-id", recorded.getPath());
    }

    @Test
    void testListMessages_noParams_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("listMessages.json"))
                .addHeader("Content-Type", "application/json"));

        assertNotNull(service.listMessages("thread-id"));
        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/messages", recorded.getPath());
    }

    @Test
    void testListMessages_withParams_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("listMessagesWithParams.json"))
                .addHeader("Content-Type", "application/json"));

        assertNotNull(service.listMessages("thread-id", new ListSearchParameters()));
        RecordedRequest recorded = server.takeRequest();
        assertTrue(recorded.getPath().startsWith("/v1/threads/thread-id/messages"));
    }

    @Test
    void testRetrieveMessageFile_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("retrieveMessageFile.json"))
                .addHeader("Content-Type", "application/json"));

        MessageFile file = service.retrieveMessageFile("thread-id", "message-id", "file-id");
        assertNotNull(file);
        assertEquals("file-id", file.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/messages/message-id/files/file-id", recorded.getPath());
    }

    @Test
    void testListMessageFiles_noParams_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("listMessageFiles.json"))
                .addHeader("Content-Type", "application/json"));

        assertNotNull(service.listMessageFiles("thread-id", "message-id"));
        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/messages/message-id/files", recorded.getPath());
    }

    @Test
    void testListMessageFiles_withParams_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("listMessageFilesWithParams.json"))
                .addHeader("Content-Type", "application/json"));

        assertNotNull(service.listMessageFiles("thread-id", "message-id", new ListSearchParameters()));
        RecordedRequest recorded = server.takeRequest();
        assertTrue(recorded.getPath().startsWith("/v1/threads/thread-id/messages/message-id/files"));
    }
} 