# OmniModel SDK

一个用于模型集成和管理的通用SDK组件，提供统一的API接口来访问各种AI/ML模型。

## 功能特点

- 统一的模型访问接口
- 灵活的模型配置
- 内置缓存和性能优化
- 完整的错误处理机制
- 易于扩展的插件系统

## 快速开始

### 添加依赖

Maven:
```xml
<dependency>
    <groupId>com.horoscope</groupId>
    <artifactId>OmniModel</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

Gradle:
```groovy
implementation 'com.horoscope:OmniModel:1.0-SNAPSHOT'
```

### 基本使用

```java
import com.horoscope.omnimodel.OmniModel;
import com.horoscope.omnimodel.config.ModelConfig;

// 配置模型
ModelConfig config = ModelConfig.builder()
    .name("gpt-3.5-turbo")
    .provider("openai")
    .apiKey("your-api-key")
    .build();

// 创建OmniModel实例
OmniModel model = new OmniModel(config);

// 发送请求
String response = model.generateText("Hello, world!");
System.out.println(response);
```

### 使用配置文件

```java
import com.horoscope.omnimodel.OmniModel;
import com.horoscope.omnimodel.config.ModelConfig;
import com.horoscope.omnimodel.util.ConfigLoader;

// 从默认配置加载
ConfigLoader configLoader = new ConfigLoader();
ModelConfig config = configLoader.buildModelConfig();

// 创建OmniModel实例
OmniModel model = new OmniModel(config);
```

## 文档

详细文档请访问：[https://github.com/horoscope/OmniModel/wiki](https://github.com/horoscope/OmniModel/wiki)

## 许可证

本项目采用 Apache License 2.0 许可证。详见 LICENSE 文件。