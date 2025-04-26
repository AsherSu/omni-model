# OmniModel Client模块

此模块提供了与各种大模型服务交互的客户端实现，封装了底层的API调用细节，提供更友好的接口。

## 主要功能

- 提供统一的客户端接口
- 封装HTTP请求和响应处理
- 支持同步调用和异步调用（基于RxJava）
- 自动处理错误和重试逻辑

## 使用方法

### Maven依赖

```xml
<dependency>
    <groupId>com.horoscope</groupId>
    <artifactId>omnimodel-client</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### 基本用法

```java
import com.horoscope.omnimodel.client.OpenAiClient;
import com.horoscope.omnimodel.config.ModelConfig;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;

// 创建客户端配置
ModelConfig config = ModelConfig.builder()
    .provider("openai")
    .name("gpt-3.5-turbo")
    .apiKey("your-api-key")
    .build();

// 创建OpenAI客户端
OpenAiClient client = new OpenAiClient(config);

// 创建请求
CompletionRequest request = CompletionRequest.builder()
    .prompt("Hello, world!")
    .maxTokens(100)
    .build();

// 同步调用
CompletionResult result = client.createCompletion(request);
System.out.println(result.getChoices().get(0).getText());

// 异步调用
client.createCompletionAsync(request)
    .subscribe(
        response -> System.out.println(response.getChoices().get(0).getText()),
        error -> System.err.println("Error: " + error.getMessage())
    );
```

## 包结构说明

- `com.horoscope.omnimodel.client`: 客户端接口和实现类
- `com.theokanning.openai.client`: 原始OpenAI客户端实现

## 依赖说明

- Retrofit2: 用于HTTP API调用
- RxJava2: 用于异步操作
- OkHttp: 底层HTTP客户端
- Jackson: JSON序列化与反序列化 