package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.ListSearchParameters;
import cn.ashersu.omni.model.OpenAiResponse;
import cn.ashersu.omni.model.runs.CreateThreadAndRunRequest;
import cn.ashersu.omni.model.runs.Run;
import cn.ashersu.omni.model.runs.RunCreateRequest;
import cn.ashersu.omni.model.runs.RunStep;
import cn.ashersu.omni.model.runs.SubmitToolOutputsRequest;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import cn.ashersu.omni.model.service.openai.item.RunService;
import okhttp3.ConnectionPool;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import cn.ashersu.omni.model.service.impl.testutil.JsonMockLoader;

class RunServiceTest {
    private MockWebServer server;
    private RunService service;

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
        service = new RunService(cfg);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testCreateRun_viaHttpMock() throws InterruptedException {
        String mockJson = JsonMockLoader.json("createRun.json");
        server.enqueue(new MockResponse()
                .setBody(mockJson)
                .addHeader("Content-Type", "application/json"));

        RunCreateRequest request = new RunCreateRequest();
        Run run = service.createRun("thread-id", request);
        
        assertNotNull(run);
        assertEquals("run-id", run.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/runs", recorded.getPath());
    }

    @Test
    void testRetrieveRun_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("retrieveRun.json"))
                .addHeader("Content-Type", "application/json"));

        Run run = service.retrieveRun("thread-id", "run-id");
        
        assertNotNull(run);
        assertEquals("run-id", run.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/runs/run-id", recorded.getPath());
    }

    @Test
    void testModifyRun_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("modifyRun.json"))
                .addHeader("Content-Type", "application/json"));

        HashMap<String, String> meta = new HashMap<>();
        meta.put("key", "value");
        Run run = service.modifyRun("thread-id", "run-id", meta);
        
        assertNotNull(run);
        assertEquals("run-id", run.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/runs/run-id", recorded.getPath());
    }

    @Test
    void testListRuns_nullParams_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("listRuns.json"))
                .addHeader("Content-Type", "application/json"));

        OpenAiResponse<Run> response = service.listRuns("thread-id", null);
        
        assertNotNull(response);
        assertNotNull(response.getData());
        assertFalse(response.getData().isEmpty());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/runs", recorded.getPath());
    }

    @Test
    void testListRuns_withParams_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("listRunsWithParams.json"))
                .addHeader("Content-Type", "application/json"));

        ListSearchParameters params = new ListSearchParameters();
        OpenAiResponse<Run> response = service.listRuns("thread-id", params);
        
        assertNotNull(response);
        assertNotNull(response.getData());
        assertFalse(response.getData().isEmpty());

        RecordedRequest recorded = server.takeRequest();
        assertTrue(recorded.getPath().startsWith("/v1/threads/thread-id/runs"));
    }

    @Test
    void testSubmitToolOutputs_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("submitToolOutputs.json"))
                .addHeader("Content-Type", "application/json"));

        SubmitToolOutputsRequest request = new SubmitToolOutputsRequest();
        Run run = service.submitToolOutputs("thread-id", "run-id", request);
        
        assertNotNull(run);
        assertEquals("run-id", run.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/runs/run-id/submit_tool_outputs", recorded.getPath());
    }

    @Test
    void testCancelRun_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("cancelRun.json"))
                .addHeader("Content-Type", "application/json"));

        Run run = service.cancelRun("thread-id", "run-id");
        
        assertNotNull(run);
        assertEquals("run-id", run.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/runs/run-id/cancel", recorded.getPath());
    }

    @Test
    void testCreateThreadAndRun_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("createThreadAndRun.json"))
                .addHeader("Content-Type", "application/json"));

        CreateThreadAndRunRequest request = new CreateThreadAndRunRequest();
        Run run = service.createThreadAndRun(request);
        
        assertNotNull(run);
        assertEquals("run-id", run.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/runs", recorded.getPath());
    }

    @Test
    void testRetrieveRunStep_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("retrieveRunStep.json"))
                .addHeader("Content-Type", "application/json"));

        RunStep step = service.retrieveRunStep("thread-id", "run-id", "step-id");
        
        assertNotNull(step);
        assertEquals("step-id", step.getId());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/runs/run-id/steps/step-id", recorded.getPath());
    }

    @Test
    void testListRunSteps_nullParams_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("listRunSteps.json"))
                .addHeader("Content-Type", "application/json"));

        OpenAiResponse<RunStep> response = service.listRunSteps("thread-id", "run-id", null);
        
        assertNotNull(response);
        assertNotNull(response.getData());
        assertFalse(response.getData().isEmpty());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/threads/thread-id/runs/run-id/steps", recorded.getPath());
    }

    @Test
    void testListRunSteps_withParams_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("listRunStepsWithParams.json"))
                .addHeader("Content-Type", "application/json"));

        ListSearchParameters params = new ListSearchParameters();
        OpenAiResponse<RunStep> response = service.listRunSteps("thread-id", "run-id", params);
        
        assertNotNull(response);
        assertNotNull(response.getData());
        assertFalse(response.getData().isEmpty());

        RecordedRequest recorded = server.takeRequest();
        assertTrue(recorded.getPath().startsWith("/v1/threads/thread-id/runs/run-id/steps"));
    }
} 