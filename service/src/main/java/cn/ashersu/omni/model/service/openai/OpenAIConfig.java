package cn.ashersu.omni.model.service.openai;

import okhttp3.ConnectionPool;
import okhttp3.Interceptor;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class OpenAIConfig {
    /**
     * OpenAI标准 API地址
     */
    private final String baseUrl;

    /**
     * OpenAI API Token
     */
    private final String token;

    /**
     * okhttp读取响应超时时间
     */
    private final Duration readTimeout;

    /**
     * okHttp线程池
     */
    private final ExecutorService executorService;

    /**
     * TCP连接池
     */
    private final ConnectionPool connectionPool;

    /**
     * 拦截器列表
     */
    private final List<Interceptor> interceptor;

    private OpenAIConfig(Builder builder) {
        this.readTimeout = builder.readTimeout;
        this.executorService = builder.executorService;
        this.connectionPool = builder.connectionPool;
        this.baseUrl = builder.baseUrl;
        this.token = builder.token;
        this.interceptor = builder.interceptor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Duration getReadTimeout() {
        return readTimeout;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public List<Interceptor> getInterceptor() {
        return interceptor;
    }

    public static final class Builder {
        private Duration readTimeout;
        private ExecutorService executorService;
        private ConnectionPool connectionPool;
        private String baseUrl;
        private String token;
        private List<Interceptor> interceptor;

        private Builder() {
        }

        public Builder readTimeout(Duration readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public Builder executorService(ExecutorService executorService) {
            this.executorService = executorService;
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            this.connectionPool = connectionPool;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder interceptor(List<Interceptor> interceptor) {
            this.interceptor = interceptor;
            return this;
        }

        public OpenAIConfig build() {
            return new OpenAIConfig(this);
        }
    }
}
