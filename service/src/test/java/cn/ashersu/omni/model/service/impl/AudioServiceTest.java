package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.audio.CreateTranscriptionRequest;
import cn.ashersu.omni.model.audio.TranscriptionResult;
import cn.ashersu.omni.model.audio.CreateTranslationRequest;
import cn.ashersu.omni.model.audio.TranslationResult;
import cn.ashersu.omni.model.audio.CreateSpeechRequest;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import cn.ashersu.omni.model.service.openai.item.AudioService;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.ConnectionPool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import cn.ashersu.omni.model.service.impl.testutil.JsonMockLoader;

class AudioServiceTest {
    private MockWebServer server;
    private AudioService service;

    @BeforeEach
    void setUp() throws Exception {
        server = new MockWebServer();
        server.start();
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testCreateTranscription_viaHttpMock() throws InterruptedException {
        String mockJson = JsonMockLoader.json("createTranscription.json");
        server.enqueue(new MockResponse()
                .setBody(mockJson)
                .addHeader("Content-Type", "application/json"));

        OpenAIConfig cfg = OpenAIConfig.builder()
                .baseUrl(server.url("/v1/").toString())
                
                .connectionPool(new ConnectionPool())
                
                .readTimeout(Duration.ofSeconds(1))
                .token("token")
                .build();
        service = new AudioService(cfg);

        TranscriptionResult res = service.createTranscription(new CreateTranscriptionRequest(), "dummy.mp3");
        assertNotNull(res);
        // 根据 mock JSON 验证字段
        assertEquals("mock-transcription", res.getText());

        RecordedRequest request = server.takeRequest();
        assertEquals("/v1/audio/transcriptions", request.getPath());
    }

    @Test
    void testCreateTranslation_viaHttpMock() throws InterruptedException {
        String mockJson = JsonMockLoader.json("createTranslation.json");
        server.enqueue(new MockResponse()
                .setBody(mockJson)
                .addHeader("Content-Type", "application/json"));

        OpenAIConfig cfg = OpenAIConfig.builder()
                .baseUrl(server.url("/v1/").toString())
                
                .connectionPool(new ConnectionPool())
                
                .readTimeout(Duration.ofSeconds(1))
                .token("token")
                .build();
        service = new AudioService(cfg);

        TranslationResult res = service.createTranslation(new CreateTranslationRequest(), "dummy.mp3");
        assertNotNull(res);
        assertEquals("mock-translation", res.getText());

        RecordedRequest request = server.takeRequest();
        assertEquals("/v1/audio/translations", request.getPath());
    }

    @Test
    void testCreateSpeech_viaHttpMock() throws InterruptedException {
        String mockJson = JsonMockLoader.json("createSpeech.json");
        server.enqueue(new MockResponse()
                .setBody(mockJson)
                .addHeader("Content-Type", "application/json"));

        OpenAIConfig cfg = OpenAIConfig.builder()
                .baseUrl(server.url("/v1/").toString())
                
                .connectionPool(new ConnectionPool())
                
                .readTimeout(Duration.ofSeconds(1))
                .token("token")
                .build();
        service = new AudioService(cfg);

        okhttp3.ResponseBody res = service.createSpeech(new CreateSpeechRequest());
        assertNotNull(res);

        RecordedRequest request = server.takeRequest();
        assertEquals("/v1/audio/speech", request.getPath());
    }
} 