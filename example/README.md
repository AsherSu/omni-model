# OmniModel 示例模块

此模块提供了OmniModel SDK的使用示例和演示代码，帮助开发者快速了解如何使用OmniModel与各种大模型服务进行交互。

## 目录结构

```
example/
├── src/main/java/example/
│   ├── OpenAiApiExample.java                    # 基本API使用示例
│   ├── OpenAiApiFunctionsExample.java           # 函数调用示例
│   ├── OpenAiApiFunctionsWithStreamExample.java # 流式函数调用示例
│   ├── OpenAiApiDynamicFunctionExample.java     # 动态函数定义示例
│   └── TikTokensExample.java                    # token计数示例
```

## 运行示例

使用Maven运行示例：

```bash
# 运行基本API示例
mvn exec:java -Dexec.mainClass="example.OpenAiApiExample"

# 运行函数调用示例
mvn exec:java -Dexec.mainClass="example.OpenAiApiFunctionsExample"

# 运行流式函数调用示例
mvn exec:java -Dexec.mainClass="example.OpenAiApiFunctionsWithStreamExample"
```

## 示例说明

### 基本API示例 (OpenAiApiExample)

展示了如何创建服务实例，发送基本的文本生成请求，并处理响应。

### 函数调用示例 (OpenAiApiFunctionsExample)

展示了如何定义函数、发送函数调用请求，并处理函数调用的响应。

### 流式函数调用示例 (OpenAiApiFunctionsWithStreamExample)

展示了如何使用流式API接收实时响应，适用于需要逐步展示生成内容的场景。

### 动态函数定义示例 (OpenAiApiDynamicFunctionExample)

展示了如何在运行时动态定义和注册函数，适用于函数需要根据上下文变化的情况。

### Token计数示例 (TikTokensExample)

展示了如何使用TikToken库计算输入文本的token数量，以便控制请求的大小。

## 注意事项

- 运行示例前，请确保您已配置有效的API密钥
- 可以通过环境变量设置API密钥：`export OPENAI_API_KEY=your-api-key`
- 或者修改示例代码中的API密钥常量 