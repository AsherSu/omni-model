# OmniModel Service模块

此模块提供了与各种大模型服务交互的高级服务接口，添加了更多功能和抽象层，使用户能够轻松地使用各种大语言模型服务。

## 主要功能

- 提供统一的服务接口
- 支持流式输出和回调处理
- 自动处理函数调用和参数解析
- 提供消息累积器和辅助工具类

## 使用方法

### Maven依赖

```xml
<dependency>
    <groupId>com.horoscope</groupId>
    <artifactId>omnimodel-service</artifactId>
    <version>0.0.1</version>
</dependency>
```

### 基本用法

```java
import com.horoscope.service.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;

// 创建OpenAI服务（使用API密钥）
OpenAiService service = new OpenAiService("your-api-key");

// 创建请求
CompletionRequest request = CompletionRequest.builder()
    .model("gpt-3.5-turbo-instruct")
    .prompt("用中文解释什么是人工智能？")
    .maxTokens(100)
    .build();

// 发送请求
CompletionResult result = service.createCompletion(request);
System.out.println(result.getChoices().get(0).getText());

// 使用完成后关闭服务
service.shutdown();
```

### 流式输出示例

```java
import com.horoscope.service.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

// 创建OpenAI服务
OpenAiService service = new OpenAiService("your-api-key");

// 创建请求
CompletionRequest request = CompletionRequest.builder()
    .model("gpt-3.5-turbo-instruct")
    .prompt("写一首关于春天的诗")
    .maxTokens(200)
    .build();

// 流式输出
service.streamCompletion(request)
    .doOnNext(response -> System.out.print(response.getChoices().get(0).getText()))
    .doOnComplete(() -> System.out.println("\n=== 生成完成 ==="))
    .blockingSubscribe();

// 使用完成后关闭服务
service.shutdown();
```

### 函数调用示例

```java
import com.horoscope.service.OpenAiService;
import com.horoscope.service.FunctionExecutor;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;

// 创建函数执行器
FunctionExecutor functionExecutor = new FunctionExecutor(Arrays.asList(
    // 添加函数定义...
));

// 创建OpenAI服务
OpenAiService service = new OpenAiService("your-api-key");

// 创建请求
ChatCompletionRequest request = ChatCompletionRequest.builder()
    .model("gpt-3.5-turbo")
    .messages(Arrays.asList(new ChatMessage(ChatMessageRole.USER.value(), "今天北京的天气怎么样？")))
    .functions(functionExecutor.getFunctions())
    .build();

// 处理函数调用
service.createChatCompletion(request)
    .doOnNext(response -> {
        // 处理函数调用...
    })
    .blockingSubscribe();

// 使用完成后关闭服务
service.shutdown();
```

## 包结构说明

- `com.horoscope.service`: 服务接口和实现类
- `com.theokanning.openai.service`: 原始OpenAI服务实现

## 依赖说明

本模块依赖于client模块，并添加了以下额外依赖：
- Jackson JSON Schema: 用于生成和解析JSON Schema
- Retrofit Mock: 用于服务测试 