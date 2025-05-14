package cn.ashersu.omni.model.completion.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Object containing a response chunk from the chat completions streaming api.
 */
public class ChatCompletionChunk {
	/**
     * Unique id assigned to this chat completion.
     */
    String id;

    /**
     * The type of object returned, should be "chat.completion.chunk"
     */
    String object;

    /**
     * The creation time in epoch seconds.
     */
    long created;
    
    /**
     * The model used.
     */
    String model;

    @JsonProperty("service_tier")
    String serviceTier;

    String usage;

    @JsonProperty("system_fingerprint")
    String systemFingerprint;

    /**
     * A list of all generated completions.
     */
    List<ChatCompletionChoice> choices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public String getServiceTier() {
        return serviceTier;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public void setServiceTier(String serviceTier) {
        this.serviceTier = serviceTier;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ChatCompletionChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<ChatCompletionChoice> choices) {
        this.choices = choices;
    }

    public String getSystemFingerprint() {
        return systemFingerprint;
    }

    public void setSystemFingerprint(String systemFingerprint) {
        this.systemFingerprint = systemFingerprint;
    }
}