# OmniModel API模块

此模块提供了与各种大模型服务的API集成，支持不同的大模型提供商接口调用。

## 主要功能

- 提供统一的API接口定义
- 支持多种大模型服务提供商
- 处理API请求的序列化和反序列化
- 错误处理和异常处理

## 使用方法

### Maven依赖

```xml
<dependency>
    <groupId>com.horoscope</groupId>
    <artifactId>omnimodel-api</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### 基本用法

```java
import com.horoscope.omnimodel.api.ModelApiFactory;
import com.horoscope.omnimodel.api.OpenAiApi;
import com.horoscope.omnimodel.config.ModelConfig;
import completion.com.omnimodel.CompletionRequest;

// 创建API配置
ModelConfig config = ModelConfig.builder()
        .provider("openai")
        .name("gpt-3.5-turbo")
        .apiKey("your-api-key")
        .build();

// 获取OpenAI API实例
OpenAiApi api = ModelApiFactory.createOpenAiApi(config);

// 创建请求
CompletionRequest request = CompletionRequest.builder()
        .prompt("Hello, world!")
        .maxTokens(100)
        .build();

// 发送请求
api.

createCompletion(request).

execute();
```

## 包结构说明

- `com.theokanning.openai`: 原始OpenAI相关API定义
- `com.horoscope.omnimodel.api`: 扩展的API工厂和接口定义

## 依赖说明

- Retrofit2: 用于HTTP API调用
- OkHttp: 底层HTTP客户端
- Jackson: JSON序列化与反序列化 