package cn.ashersu.omni.model.completion.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatFunctionParameters {

    private final String type = "object";

    private final HashMap<String, ChatFunctionProperty> properties = new HashMap<>();

    private List<String> required;

    public ChatFunctionParameters() {
    }

    public String getType() {
        return type;
    }

    public HashMap<String, ChatFunctionProperty> getProperties() {
        return properties;
    }

    public List<String> getRequired() {
        return required;
    }

    public void setRequired(List<String> required) {
        this.required = required;
    }

    public void addProperty(ChatFunctionProperty property) {
        properties.put(property.getName(), property);
        if (Boolean.TRUE.equals(property.getRequired())) {
            if (this.required == null) {
                this.required = new ArrayList<>();
            }
            this.required.add(property.getName());
        }
    }
}
