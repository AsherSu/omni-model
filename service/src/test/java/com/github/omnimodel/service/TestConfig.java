package cn.ashersu.omni.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {
    private static final Properties properties = new Properties();
    
    static {
        try (InputStream input = TestConfig.class.getClassLoader().getResourceAsStream("test-config.properties")) {
            if (input == null) {
                throw new RuntimeException("无法找到test-config.properties文件");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("加载测试配置文件失败", e);
        }
    }
    
    // OpenAI配置
    public static String getOpenAiApiKey() {
        return properties.getProperty("openai.api.key");
    }
    
    public static String getOpenAiBaseUrl() {
        return properties.getProperty("openai.api.base.url");
    }
    
    public static String getOpenAiModel() {
        return properties.getProperty("openai.api.model");
    }

    // 阿里云配置
    public static String getAliApiKey() {
        return properties.getProperty("ali.api.key");
    }

    public static String getAliApiSecret() {
        return properties.getProperty("ali.api.secret");
    }

    public static String getAliBaseUrl() {
        return properties.getProperty("ali.api.base.url");
    }

    public static String getAliModel() {
        return properties.getProperty("ali.api.model");
    }

    // 火山引擎配置
    public static String getVolcApiKey() {
        return properties.getProperty("volc.api.key");
    }

    public static String getVolcBaseUrl() {
        return properties.getProperty("volc.api.base.url");
    }

    public static String getVolcModel() {
        return properties.getProperty("volc.api.model");
    }
}