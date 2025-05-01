package cn.ashersu.omni.model.news;

import cn.ashersu.omni.model.OpenAiError;
import cn.ashersu.omni.model.OpenAiHttpException;
import cn.ashersu.omni.model.client.OpenAiApi;
import cn.ashersu.omni.model.completion.chat.ChatCompletionRequest;
import cn.ashersu.omni.model.completion.chat.ChatFunction;
import cn.ashersu.omni.model.completion.chat.ChatFunctionCall;
import cn.ashersu.omni.model.interceptor.AuthenticationInterceptor;
import cn.ashersu.omni.model.mixin.ChatCompletionRequestMixIn;
import cn.ashersu.omni.model.mixin.ChatFunctionCallMixIn;
import cn.ashersu.omni.model.mixin.ChatFunctionMixIn;
import cn.ashersu.omni.model.service.ResponseBodyCallback;
import cn.ashersu.omni.model.service.SSE;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Single;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class BaseOpenAIService {

    private Duration connectTimeout;
    private Duration readTimeout;
    public ExecutorService executorService;   // 线程池
    private ConnectionPool connectionPool;
    private String baseUrl;
    private String token;

    // private List<Interceptor> interceptor;

    public final ObjectMapper mapper = defaultObjectMapper();

    // Retrofit接口定义
    public final OpenAiApi api;

    // private final OkHttpClient http;

    public BaseOpenAIService(OpenAIConfig config) {
        init(config);
        ObjectMapper mapper = defaultObjectMapper();
        OkHttpClient client = defaultClient(token, readTimeout);
        Retrofit retrofit = defaultRetrofit(client, mapper);

        this.api = retrofit.create(OpenAiApi.class);
    }

    public void init(OpenAIConfig config) {
//        this.connectTimeout = config.getConnectTimeout();
        this.readTimeout = config.getReadTimeout();
//        this.executorService = config.getExecutor();
        this.connectionPool = config.getConnectionPool();
        this.baseUrl = config.getBaseUrl();
        this.token = config.getToken();
    }

    /**
     * Calls the Open AI api and returns a Flowable of SSE for streaming
     * omitting the last message.
     *
     * @param apiCall The api call
     */
    public Flowable<SSE> stream(Call<ResponseBody> apiCall) {
        return stream(apiCall, false);
    }

    /**
     * Calls the Open AI api and returns a Flowable of SSE for streaming.
     *
     * @param apiCall  The api call
     * @param emitDone If true the last message ([DONE]) is emitted
     */
    public Flowable<SSE> stream(Call<ResponseBody> apiCall, boolean emitDone) {
        return Flowable.create(emitter -> apiCall.enqueue(new ResponseBodyCallback(emitter, emitDone)), BackpressureStrategy.BUFFER);
    }

    /**
     * Calls the Open AI api and returns a Flowable of type T for streaming
     * omitting the last message.
     *
     * @param apiCall The api call
     * @param cl      Class of type T to return
     */
    public <T> Flowable<T> stream(Call<ResponseBody> apiCall, Class<T> cl) {
        return stream(apiCall).map(sse -> mapper.readValue(sse.getData(), cl));
    }


    public ObjectMapper defaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.addMixIn(ChatFunction.class, ChatFunctionMixIn.class);
        mapper.addMixIn(ChatCompletionRequest.class, ChatCompletionRequestMixIn.class);
        mapper.addMixIn(ChatFunctionCall.class, ChatFunctionCallMixIn.class);
        return mapper;
    }

    public OkHttpClient defaultClient(String token, Duration timeout) {
        // 添加日志拦截器，打印HTTP请求和响应
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(System.out::println);
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
//                .addInterceptor(loggingInterceptor)
                .addInterceptor(new AuthenticationInterceptor(token))
                .connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS))
                .readTimeout(timeout.toMillis(), TimeUnit.MILLISECONDS)
                .build();
    }

    public Retrofit defaultRetrofit(OkHttpClient client, ObjectMapper mapper) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public <T> T execute(Single<T> apiCall) {
        try {
            return apiCall.blockingGet();
        } catch (HttpException e) {
            try {
                if (e.response() == null || e.response().errorBody() == null) {
                    throw e;
                }
                String errorBody = e.response().errorBody().string();

                OpenAiError error = mapper.readValue(errorBody, OpenAiError.class);
                throw new OpenAiHttpException(error, e, e.code());
            } catch (IOException ex) {
                // couldn't parse OpenAI error
                throw e;
            }
        }
    }
}
