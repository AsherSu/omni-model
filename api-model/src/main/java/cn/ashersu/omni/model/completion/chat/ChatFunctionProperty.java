package cn.ashersu.omni.model.completion.chat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Set;

public class ChatFunctionProperty {
    @JsonIgnore
    private String name;
    
    private String type;
    
    @JsonIgnore
    private Boolean required;
    
    private String description;
    
    private ChatFunctionProperty items;
    
    @JsonProperty("enum")
    private Set<?> enumValues;
    
    public ChatFunctionProperty() {
    }
    
    public ChatFunctionProperty(String name, String type, Boolean required, String description, 
                            ChatFunctionProperty items, Set<?> enumValues) {
        this.name = Objects.requireNonNull(name, "name cannot be null");
        this.type = Objects.requireNonNull(type, "type cannot be null");
        this.required = required;
        this.description = description;
        this.items = items;
        this.enumValues = enumValues;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "name cannot be null");
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = Objects.requireNonNull(type, "type cannot be null");
    }
    
    public Boolean getRequired() {
        return required;
    }
    
    public void setRequired(Boolean required) {
        this.required = required;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public ChatFunctionProperty getItems() {
        return items;
    }
    
    public void setItems(ChatFunctionProperty items) {
        this.items = items;
    }
    
    public Set<?> getEnumValues() {
        return enumValues;
    }
    
    public void setEnumValues(Set<?> enumValues) {
        this.enumValues = enumValues;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String name;
        private String type;
        private Boolean required;
        private String description;
        private ChatFunctionProperty items;
        private Set<?> enumValues;
        
        public Builder name(String name) {
            this.name = Objects.requireNonNull(name, "name cannot be null");
            return this;
        }
        
        public Builder type(String type) {
            this.type = Objects.requireNonNull(type, "type cannot be null");
            return this;
        }
        
        public Builder required(Boolean required) {
            this.required = required;
            return this;
        }
        
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        
        public Builder items(ChatFunctionProperty items) {
            this.items = items;
            return this;
        }
        
        public Builder enumValues(Set<?> enumValues) {
            this.enumValues = enumValues;
            return this;
        }
        
        public ChatFunctionProperty build() {
            return new ChatFunctionProperty(name, type, required, description, items, enumValues);
        }
    }
}