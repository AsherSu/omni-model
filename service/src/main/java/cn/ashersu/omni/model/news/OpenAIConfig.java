package cn.ashersu.omni.model.news;

import lombok.Builder;
import lombok.Data;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Data
@Builder
public final class OpenAIConfig {
//    private final Duration connectTimeout;
    private final Duration readTimeout;
//    private final ExecutorService executor;   // 线程池
    private final ConnectionPool connectionPool;
    private final String baseUrl;
    private final String token;
//    private final List<Interceptor> interceptor;
}