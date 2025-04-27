# OmniModel SDK

[![Maven Central](https://img.shields.io/maven-central/v/cn.ashersu.omni.model/svg)](https://maven-badges.herokuapp.com/maven-central/cn.ashersu.omni.model/OmniModel)
[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](LICENSE)
[![Build Status](https://img.shields.io/travis/horoscope/OmniModel/main.svg)](https://travis-ci.org/horoscope/OmniModel)

OmniModel是一个强大的模型集成和管理SDK，提供统一的API接口来访问和管理各种AI/ML模型。它能够帮助开发者快速集成各类模型，简化开发流程，提高开发效率。

## 🌟 主要特性

- **统一接口**: 提供标准化的API接口，支持多种模型的无缝接入
- **灵活配置**: 支持多种配置方式，包括代码配置和配置文件
- **性能优化**: 内置智能缓存机制，提供最佳性能体验
- **错误处理**: 完善的错误处理和重试机制
- **可扩展性**: 插件化架构设计，支持自定义扩展
- **多模型支持**: 支持主流AI/ML模型，如GPT、BERT等
- **监控集成**: 内置性能监控和指标收集

## 📦 安装

### Maven

```xml
<!-- 添加仓库配置（如果使用SNAPSHOT版本） -->
<repositories>
    <repository>
        <id>ossrh</id>
        <url>https://s01.oss.sonatype.org/content/repositories/snapshots</url>
    </repository>
</repositories>

<!-- 核心功能模块 -->
<dependency>
    <groupId>cn.ashersu.omni.model</groupId>
    <artifactId>omnimodel-service</artifactId>
    <version>0.0.1</version>
</dependency>

<!-- API模型模块（可选） -->
<dependency>
    <groupId>cn.ashersu.omni.model</groupId>
    <artifactId>omnimodel-api-model</artifactId>
    <version>0.0.1</version>
</dependency>

<!-- 完整功能包（推荐） -->
<dependency>
    <groupId>cn.ashersu.omni.model</groupId>
    <artifactId>omnimodel-bundle</artifactId>
    <version>0.0.1</version>
</dependency>
```

### Gradle

```groovy
// 添加仓库配置（如果使用SNAPSHOT版本）
repositories {
    maven {
        url 'https://s01.oss.sonatype.org/content/repositories/snapshots'
    }
}

// 核心功能模块
implementation 'cn.ashersu.omni.model:omnimodel-service:0.0.1'

// API模型模块（可选）
implementation 'cn.ashersu.omni.model:omnimodel-api-model:0.0.1'

// 完整功能包（推荐）
implementation 'cn.ashersu.omni.model:omnimodel-bundle:0.0.1'
```

**注意**：如果你在使用SNAPSHOT版本时遇到问题，建议：
1. 确保已添加上述仓库配置
2. 使用 `mvn clean install` 手动安装到本地仓库
3. 或等待正式发布版本

## 🚀 快速开始

### 基础用法

```java
import cn.ashersu.omni.model.OmniModel;
import cn.ashersu.omni.model.config.ModelConfig;

// 配置模型
ModelConfig config = ModelConfig.builder()
    .name("gpt-3.5-turbo")
    .provider("openai")
    .apiKey("your-api-key")
    .maxRetries(3)
    .timeout(30000)
    .build();

// 创建OmniModel实例
OmniModel model = new OmniModel(config);

// 发送请求
String response = model.generateText("Hello, world!");
System.out.println(response);
```

### 使用配置文件

```java
import cn.ashersu.omni.model.OmniModel;
import cn.ashersu.omni.model.config.ModelConfig;
import cn.ashersu.omni.model.util.ConfigLoader;

// 从配置文件加载
ConfigLoader configLoader = new ConfigLoader("config.yaml");
ModelConfig config = configLoader.buildModelConfig();

// 创建OmniModel实例
OmniModel model = new OmniModel(config);
```

### 异步调用

```java
import cn.ashersu.omni.model.OmniModel;
import java.util.concurrent.CompletableFuture;

// 异步生成文本
CompletableFuture<String> future = model.generateTextAsync("Hello, world!");
future.thenAccept(response -> System.out.println(response));
```

## 📖 详细文档

- [完整文档](https://github.com/horoscope/OmniModel/wiki)
- [API参考](https://github.com/horoscope/OmniModel/wiki/API-Reference)
- [配置指南](https://github.com/horoscope/OmniModel/wiki/Configuration)
- [最佳实践](https://github.com/horoscope/OmniModel/wiki/Best-Practices)
- [常见问题](https://github.com/horoscope/OmniModel/wiki/FAQ)

## 🔧 高级配置

### YAML配置示例

```yaml
model:
  name: gpt-3.5-turbo
  provider: openai
  api-key: ${OPENAI_API_KEY}
  max-retries: 3
  timeout: 30000
  cache:
    enabled: true
    max-size: 1000
    expire-after-write: 1h
```

### 自定义模型提供者

```java
import cn.ashersu.omni.model.provider.ModelProvider;

public class CustomModelProvider implements ModelProvider {
    @Override
    public String generateText(String prompt) {
        // 实现自定义逻辑
    }
}
```

## 🤝 贡献指南

我们欢迎所有形式的贡献，包括但不限于：

- 提交问题和建议
- 改进文档
- 提交代码修复
- 添加新功能

请查看[贡献指南](CONTRIBUTING.md)了解详细信息。

## 📊 性能监控

OmniModel提供了内置的性能监控功能：

```java
import cn.ashersu.omni.model.metrics.MetricsCollector;

MetricsCollector metrics = model.getMetricsCollector();
System.out.println("平均响应时间: " + metrics.getAverageResponseTime());
System.out.println("请求成功率: " + metrics.getSuccessRate());
```

## 🔒 安全建议

- 请勿在代码中硬编码API密钥
- 使用环境变量或配置文件管理敏感信息
- 定期更新SDK到最新版本
- 启用请求限流和重试机制

## 📄 许可证

本项目采用 [Apache License 2.0](LICENSE) 许可证。

## 🌐 相关链接

- [项目主页](https://github.com/horoscope/OmniModel)
- [问题反馈](https://github.com/horoscope/OmniModel/issues)
- [更新日志](CHANGELOG.md)

## 📬 联系我们

- 邮箱：omnimodel@example.com
- 微信群：扫描下方二维码加入技术交流群
- [GitHub Discussions](https://github.com/horoscope/OmniModel/discussions)

## 🙏 鸣谢

感谢所有为本项目做出贡献的开发者！