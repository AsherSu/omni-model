package cn.ashersu.omni.model.completion.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.*;

public class ComplexChatMessage extends ChatMessage {

    private static final ObjectMapper mapper = new ObjectMapper();

    String role;

    @JsonInclude()
    List<Object> content;

    public ComplexChatMessage() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Object> getContent() {
        return content;
    }

    public void addContent(JsonNode content) {
        if (this.content == null) {
            this.content = new ArrayList<>();
        }
        this.content.add(content);
    }

    public void addContent(TextContent content) {
        if (this.content == null) {
            this.content = new ArrayList<>();
        }
        this.content.add(content);
    }

    public void addContent(VideoContent content) {
        if (this.content == null) {
            this.content = new ArrayList<>();
        }
        this.content.add(content);
    }

    public void addContent(ImageContent content) {
        if (this.content == null) {
            this.content = new ArrayList<>();
        }
        this.content.add(content);
    }
}
