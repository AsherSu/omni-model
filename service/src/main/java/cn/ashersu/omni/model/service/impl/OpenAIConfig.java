package cn.ashersu.omni.model.service.impl;

import lombok.Builder;
import lombok.Data;
import okhttp3.ConnectionPool;

import java.time.Duration;

@Data
@Builder
public final class OpenAIConfig {
    private final Integer maxIdleConnection;
    private final Integer connectTimeout;
    private final Duration readTimeout;
//    private final ExecutorService executor;   // 线程池
    private final ConnectionPool connectionPool;
    private final String baseUrl;
    private final String token;
//    private final List<Interceptor> interceptor;
}