package cn.ashersu.omni.model.service.impl.testutil;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class JsonMockLoader {
    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    /**
     * 读取 src/test/resources/mocks/ 下的 JSON 文件，返回原始字符串
     */
    public static String json(String fileName) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("mocks/" + fileName);
        if (is == null) {
            throw new RuntimeException("Mock file not found: " + fileName);
        }
        try (Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.name())) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }

    /**
     * 读取并反序列化 mocks/ 下的 JSON 文件到指定类型
     */
    public static <T> T load(String fileName, Class<T> clazz) {
        try {
            return mapper.readValue(json(fileName), clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse mock JSON: " + fileName, e);
        }
    }
} 