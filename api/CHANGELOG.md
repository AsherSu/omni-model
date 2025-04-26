# API模块变更日志

## 1.0.0 (2023-04-30)

### 特性

- 将API模块改造为Maven模块
- 添加ModelApiFactory用于创建不同提供商的API客户端
- 支持OpenAI和Anthropic API接口
- 添加API配置工具类ApiConfigUtil
- 添加API使用示例类

### 变更

- 移除Gradle构建脚本，完全使用Maven进行构建
- 修改包结构为com.horoscope.omnimodel.api
- 保留原有的OpenAI API模型类 