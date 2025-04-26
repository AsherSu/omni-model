# OmniModel 提供商配置说明

本目录包含各个大模型提供商的配置模板，方便您根据自己的需求快速配置不同的模型提供商。

## 使用方法

1. 从本目录选择您需要的模型提供商配置模板，例如 `openai.properties.example`
2. 复制并重命名为实际配置文件，去掉 `.example` 后缀，例如 `openai.properties`
3. 编辑配置文件，填入您的实际 API 密钥和其他必要参数
4. 将配置文件放在应用的配置目录下，例如 `classpath:` 或自定义目录

## 配置加载

可以通过以下方式在代码中加载提供商特定配置：

```java
import com.horoscope.omnimodel.OmniModel;
import com.horoscope.omnimodel.config.ModelConfig;
import com.horoscope.omnimodel.util.ConfigLoader;

// 创建配置加载器
ConfigLoader configLoader = new ConfigLoader();

// 加载提供商特定配置
configLoader.loadFromFile("config/providers/openai.properties");

// 构建模型配置
ModelConfig config = configLoader.buildModelConfig();

// 创建OmniModel实例
OmniModel model = new OmniModel(config);
```

## 多提供商配置

在应用中配置多个提供商，可以按需切换：

```java
import com.horoscope.omnimodel.OmniModel;
import com.horoscope.omnimodel.config.ModelConfig;
import com.horoscope.omnimodel.util.ConfigLoader;

import java.util.HashMap;
import java.util.Map;

// 存储不同提供商的模型实例
Map<String, OmniModel> modelMap = new HashMap<>();

// 加载OpenAI配置
ConfigLoader openaiLoader = new ConfigLoader();
openaiLoader.loadFromFile("config/providers/openai.properties");
modelMap.put("openai", new OmniModel(openaiLoader.buildModelConfig()));

// 加载阿里云配置
ConfigLoader aliyunLoader = new ConfigLoader();
aliyunLoader.loadFromFile("config/providers/aliyun.properties");
modelMap.put("aliyun", new OmniModel(aliyunLoader.buildModelConfig()));

// 根据需求使用不同提供商
OmniModel defaultModel = modelMap.get("openai");
String response = defaultModel.generateText("你好，请介绍下自己");
```

## 环境变量覆盖

为了更好地保护API密钥和敏感信息，您可以使用环境变量覆盖配置文件中的值：

```bash
# OpenAI配置
export OMNIMODEL_PROVIDER=openai
export OMNIMODEL_API_KEY=your-api-key-here

# 阿里云配置
# export OMNIMODEL_PROVIDER=aliyun 
# export OMNIMODEL_API_KEY=your-aliyun-api-key-here
```

然后在代码中加载环境变量：

```java
// 创建配置加载器（先加载文件，再用环境变量覆盖）
ConfigLoader configLoader = new ConfigLoader();
configLoader.loadFromFile("config/providers/openai.properties");
configLoader.loadFromEnvironment();

// 构建模型配置
ModelConfig config = configLoader.buildModelConfig();
```

## 支持的提供商

本目录包含以下提供商的配置模板：

- `openai.properties.example`: OpenAI (GPT-3.5/GPT-4)
- `aliyun.properties.example`: 阿里云通义千问
- `tencent.properties.example`: 腾讯云混元
- `baidu.properties.example`: 百度文心一言
- `azure.properties.example`: 微软Azure OpenAI
- `minimax.properties.example`: MiniMax
- `zhipu.properties.example`: 智谱AI (ChatGLM)

## 安全提示

- **不要**将包含真实API密钥的配置文件提交到版本控制系统
- 在生产环境中，建议使用环境变量或安全的密钥管理系统存储敏感信息
- 定期轮换API密钥以提高安全性 