# Client模块变更日志

## 1.0.0 (2023-04-30)

### 特性

- 将Client模块改造为Maven模块
- 添加通用的模型客户端接口ModelClient
- 实现OpenAI和Anthropic客户端
- 创建客户端配置类ClientConfig
- 添加ModelClientFactory用于创建和管理客户端实例
- 支持同步和异步API调用
- 添加客户端使用示例

### 变更

- 移除Gradle构建脚本，完全使用Maven进行构建
- 添加新的客户端包结构com.horoscope.omnimodel.client
- 保留原有的OpenAI客户端实现 