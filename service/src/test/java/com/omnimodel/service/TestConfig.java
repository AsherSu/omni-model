package com.omnimodel.service;

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
    
    public static String getApiKey() {
        return properties.getProperty("openai.api.key");
    }
    
    public static String getBaseUrl() {
        return properties.getProperty("openai.api.base.url");
    }
    
    public static String getModel() {
        return properties.getProperty("openai.api.model");
    }
}