
# Omni-Model

## 项目介绍

Omni-Model是一个Java客户端库，提供对OpenAI API的全面封装，支持所有OpenAI功能，包括文本补全、聊天、图像生成、嵌入、音频处理、微调等。

## 特性

- 支持所有OpenAI API功能
- 链式调用风格，易于使用
- 支持同步和异步操作
- 完善的类型支持
- 支持流式响应

## 引入方式

### Maven

```xml
<dependency>
    <groupId>cn.ashersu.omni.model</groupId>
    <artifactId>omni-model-all</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'cn.ashersu.omni:omni-model:1.0.0'
```

## 快速开始

### 基本配置

```java
import cn.ashersu.omni.model.news.OpenAI;
import cn.ashersu.omni.model.news.OpenAIConfig;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class QuickStart {
    public static void main(String[] args) {
        // 创建基础配置
        OpenAIConfig config = new OpenAIConfig();
        config.setToken("your-api-key");
        config.setBaseUrl("https://api.openai.com/v1/");
        config.setReadTimeout(Duration.ofSeconds(30));
        config.setMaxIdleConnection(5);
        config.setConnectTimeout(5000);
        
        // 为各服务创建配置映射
        Map<Class, OpenAIConfig> configMap = new HashMap<>();
        configMap.put(CompletionService.class, config);
        // 可以为不同服务设置不同配置
        
        // 创建OpenAI客户端
        OpenAI openAI = new OpenAI(configMap);
    }
}
```

## 使用示例

### 文本补全

```java
import cn.ashersu.omni.model.completion.chat.ChatCompletionRequest;
import cn.ashersu.omni.model.completion.chat.ChatCompletionResult;
import cn.ashersu.omni.model.completion.chat.ChatMessage;
import cn.ashersu.omni.model.completion.chat.ChatMessageRole;

// 创建聊天请求
ChatCompletionRequest request = ChatCompletionRequest.builder()
    .model("gpt-3.5-turbo")
    .addMessage(new ChatMessage(ChatMessageRole.USER.value(), "你好，请介绍一下自己！"))
    .temperature(0.7)
    .build();

// 执行请求
ChatCompletionResult result = openAI.completions().createChatCompletion(request);
System.out.println(result.getChoices().get(0).getMessage().getContent());
```

### 图像生成

```java
import cn.ashersu.omni.model.image.CreateImageRequest;
import cn.ashersu.omni.model.image.ImageResult;

// 创建图像生成请求
CreateImageRequest request = CreateImageRequest.builder()
    .prompt("一只可爱的猫咪在阳光下休息")
    .n(1)
    .size("1024x1024")
    .build();

// 执行请求
ImageResult result = openAI.images().createImage(request);
System.out.println("生成的图像URL: " + result.getData().get(0).getUrl());
```

### 嵌入生成

```java
import cn.ashersu.omni.model.embedding.EmbeddingRequest;
import cn.ashersu.omni.model.embedding.EmbeddingResult;

// 创建嵌入请求
EmbeddingRequest request = EmbeddingRequest.builder()
    .model("text-embedding-ada-002")
    .input("文本嵌入示例")
    .build();

// 执行请求
EmbeddingResult result = openAI.embeddings().createEmbeddings(request);
System.out.println("嵌入向量维度: " + result.getData().get(0).getEmbedding().size());
```

### 音频转录

```java
import cn.ashersu.omni.model.audio.CreateTranscriptionRequest;
import cn.ashersu.omni.model.audio.TranscriptionResult;

// 创建转录请求
CreateTranscriptionRequest request = CreateTranscriptionRequest.builder()
    .model("whisper-1")
    .language("zh")
    .build();

// 执行请求
TranscriptionResult result = openAI.audio().createTranscription(request, "path/to/audio.mp3");
System.out.println("转录文本: " + result.getText());
```

### 内容审核

```java
import cn.ashersu.omni.model.moderation.ModerationRequest;
import cn.ashersu.omni.model.moderation.ModerationResult;

// 创建审核请求
ModerationRequest request = ModerationRequest.builder()
    .input("需要审核的文本内容")
    .model("text-moderation-latest")
    .build();

// 执行请求
ModerationResult result = openAI.moderation().createModeration(request);
System.out.println("是否违规: " + result.getResults().get(0).isFlagged());
```

### 流式响应处理

```java
import cn.ashersu.omni.model.completion.chat.ChatCompletionChunk;
import io.reactivex.Flowable;

// 创建流式聊天请求
ChatCompletionRequest request = ChatCompletionRequest.builder()
    .model("gpt-3.5-turbo")
    .addMessage(new ChatMessage(ChatMessageRole.USER.value(), "写一首诗"))
    .stream(true)
    .build();

// 获取流式响应
Flowable<ChatCompletionChunk> flowable = openAI.completions().streamChatCompletion(request);

// 处理流式响应 - 方式1：直接订阅
flowable.subscribe(chunk -> {
    String content = chunk.getChoices().get(0).getMessage().getContent();
    if (content != null) {
        System.out.print(content);
    }
});

// 处理流式响应 - 方式2：使用累积器
flowable
    .map(chunk -> openAI.completions().mapStreamToAccumulator(chunk))
    .subscribe(accumulator -> {
        // 获取当前片段
        System.out.print(accumulator.getChunk());
        // 或获取累积的完整消息
        System.out.println(accumulator.getAccumulatedMessage());
    });
```

## 更多示例

### 助手API

```java
// 创建助手
AssistantCreateRequest createRequest = AssistantCreateRequest.builder()
    .model("gpt-4")
    .name("数学助手")
    .instructions("你是一位擅长解决数学问题的助手")
    .build();
Assistant assistant = openAI.assistant().createAssistant(createRequest);

// 获取助手
Assistant retrievedAssistant = openAI.assistant().retrieveAssistant(assistant.getId());
```

### 文件操作

```java
// 上传文件
File uploadedFile = openAI.files().uploadFile(
    new java.io.File("path/to/your/file.txt"), 
    "fine-tune"
);

// 获取文件列表
List<File> files = openAI.files().listFiles();
```

## 高级配置

您可以为每种服务类型配置不同的参数：

```java
// 创建不同的配置
OpenAIConfig defaultConfig = new OpenAIConfig();
defaultConfig.setToken("your-api-key");
defaultConfig.setBaseUrl("https://api.openai.com/v1/");

OpenAIConfig completionConfig = new OpenAIConfig();
completionConfig.setToken("your-api-key");
completionConfig.setReadTimeout(Duration.ofSeconds(60)); // 为补全设置更长的超时时间

Map<Class, OpenAIConfig> configMap = new HashMap<>();
configMap.put(CompletionService.class, completionConfig);
configMap.put(AssistantService.class, defaultConfig);
// 为其他服务添加配置...

OpenAI openAI = new OpenAI(configMap);
```

## 错误处理

```java
try {
    ChatCompletionResult result = openAI.completions().createChatCompletion(request);
    // 处理结果
} catch (OpenAiHttpException e) {
    System.err.println("OpenAI API错误: " + e.getError().getMessage());
    System.err.println("错误类型: " + e.getError().getType());
    System.err.println("HTTP状态码: " + e.getStatusCode());
} catch (Exception e) {
    System.err.println("发生其他错误: " + e.getMessage());
}
```

## 许可证

MIT License
