package cn.ashersu.omni.model.service.impl;

import cn.ashersu.omni.model.billing.Subscription;
import cn.ashersu.omni.model.billing.BillingUsage;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import cn.ashersu.omni.model.service.openai.item.BillingService;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.ConnectionPool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import cn.ashersu.omni.model.service.impl.testutil.JsonMockLoader;

class BillingServiceTest {
    private MockWebServer server;
    private BillingService service;

    @BeforeEach
    void setUp() throws Exception {
        server = new MockWebServer();
        server.start();

        // mock subscription
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("subscription.json"))
                .addHeader("Content-Type", "application/json"));

        OpenAIConfig cfg = OpenAIConfig.builder()
                .baseUrl(server.url("/v1/").toString())
                
                .connectionPool(new ConnectionPool())
                
                .readTimeout(Duration.ofSeconds(1))
                .token("token")
                .build();
        service = new BillingService(cfg);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    void testSubscription_viaHttpMock() throws InterruptedException {
        Subscription sub = service.subscription();
        assertNotNull(sub);
        assertEquals("subscription", sub.getObject());

        RecordedRequest recorded = server.takeRequest();
        assertEquals("/v1/dashboard/billing/subscription", recorded.getPath());
    }

    @Test
    void testBillingUsage_viaHttpMock() throws InterruptedException {
        server.enqueue(new MockResponse()
                .setBody(JsonMockLoader.json("billingUsage.json"))
                .addHeader("Content-Type", "application/json"));

        LocalDate start = LocalDate.now();
        LocalDate end = start.plusDays(1);
        BillingUsage usage = service.billingUsage(start, end);
        assertNotNull(usage);
        assertTrue(usage.getTotalUsage().compareTo(java.math.BigDecimal.ZERO) >= 0);

        RecordedRequest recorded = server.takeRequest();
        assertTrue(recorded.getPath().startsWith("/v1/dashboard/billing/usage"));
    }
} 