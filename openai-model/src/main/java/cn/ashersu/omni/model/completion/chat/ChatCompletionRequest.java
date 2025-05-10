package cn.ashersu.omni.model.completion.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class ChatCompletionRequest {

    /**
     * 指定使用的模型名称
     */
    String model;

    /**
     * 聊天消息的列表，包含用户输入和上下文信息
     */
    List<ChatMessage> messages;

    /**
     * 控制生成文本的随机性。值越高（如 0.7），生成的文本越随机；值越低，生成的文本越确定。
     */
    Double temperature;

    /**
     * 使用核采样（Top-p Sampling）来限制生成的词汇范围。值越低，生成的词汇范围越小。
     */
    @JsonProperty("top_p")
    Double topP;

    /**
     * 指定生成的响应数量
     */
    Integer n;

    /**
     * 是否以流式方式返回生成结果。true 表示启用流式输出。
     */
    Boolean stream;

    /**
     * stop: 指定生成文本时的终止标记列表，例如 ["STOP"]。
     */
    List<String> stop;

    /**
     * 限制生成的最大 token 数量。
     */
    @JsonProperty("max_tokens")
    Integer maxTokens;

    /**
     * 控制生成文本中是否倾向于引入新主题。值越高，生成新内容的可能性越大。
     */
    @JsonProperty("presence_penalty")
    Double presencePenalty;

    /**
     * 控制生成文本中减少重复内容的可能性。值越高，减少重复的可能性越大。
     */
    @JsonProperty("frequency_penalty")
    Double frequencyPenalty;

    /**
     * 用于调整特定 token 的生成概率。例如，{"50256": -100} 会显著降低 token 50256 的生成概率。
     */
    @JsonProperty("logit_bias")
    Map<String, Integer> logitBias;


    /**
     * 用户标识符，用于区分不同用户的请求。
     */
    String user;

    /**
     * 可用函数的列表。
     */
    List<?> functions;

    /**
     * Controls how the model responds to function calls, as specified in the <a href="https://platform.openai.com/docs/api-reference/chat/create#chat/create-function_call">OpenAI documentation</a>.
     */
    @JsonProperty("function_call")
    ChatCompletionRequestFunctionCall functionCall;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTopP() {
        return topP;
    }

    public void setTopP(Double topP) {
        this.topP = topP;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Boolean getStream() {
        return stream;
    }

    public void setStream(Boolean stream) {
        this.stream = stream;
    }

    public List<String> getStop() {
        return stop;
    }

    public void setStop(List<String> stop) {
        this.stop = stop;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public Double getPresencePenalty() {
        return presencePenalty;
    }

    public void setPresencePenalty(Double presencePenalty) {
        this.presencePenalty = presencePenalty;
    }

    public Double getFrequencyPenalty() {
        return frequencyPenalty;
    }

    public void setFrequencyPenalty(Double frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
    }

    public Map<String, Integer> getLogitBias() {
        return logitBias;
    }

    public void setLogitBias(Map<String, Integer> logitBias) {
        this.logitBias = logitBias;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<?> getFunctions() {
        return functions;
    }

    public void setFunctions(List<?> functions) {
        this.functions = functions;
    }

    public ChatCompletionRequestFunctionCall getFunctionCall() {
        return functionCall;
    }

    public void setFunctionCall(ChatCompletionRequestFunctionCall functionCall) {
        this.functionCall = functionCall;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String model;
        private List<ChatMessage> messages;
        private Double temperature;
        private Double topP;
        private Integer n;
        private Boolean stream;
        private List<String> stop;
        private Integer maxTokens;
        private Double presencePenalty;
        private Double frequencyPenalty;
        private Map<String, Integer> logitBias;
        private String user;
        private List<?> functions;
        private ChatCompletionRequestFunctionCall functionCall;

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder messages(List<ChatMessage> messages) {
            this.messages = messages;
            return this;
        }

        public Builder temperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder topP(Double topP) {
            this.topP = topP;
            return this;
        }

        public Builder n(Integer n) {
            this.n = n;
            return this;
        }

        public Builder stream(Boolean stream) {
            this.stream = stream;
            return this;
        }

        public Builder stop(List<String> stop) {
            this.stop = stop;
            return this;
        }

        public Builder maxTokens(Integer maxTokens) {
            this.maxTokens = maxTokens;
            return this;
        }

        public Builder presencePenalty(Double presencePenalty) {
            this.presencePenalty = presencePenalty;
            return this;
        }

        public Builder frequencyPenalty(Double frequencyPenalty) {
            this.frequencyPenalty = frequencyPenalty;
            return this;
        }

        public Builder logitBias(Map<String, Integer> logitBias) {
            this.logitBias = logitBias;
            return this;
        }

        public Builder user(String user) {
            this.user = user;
            return this;
        }

        public Builder functions(List<?> functions) {
            this.functions = functions;
            return this;
        }

        public Builder functionCall(ChatCompletionRequestFunctionCall functionCall) {
            this.functionCall = functionCall;
            return this;
        }

        public ChatCompletionRequest build() {
            ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest();
            chatCompletionRequest.setModel(model);
            chatCompletionRequest.setMessages(messages);
            chatCompletionRequest.setTemperature(temperature);
            chatCompletionRequest.setTopP(topP);
            chatCompletionRequest.setN(n);
            chatCompletionRequest.setStream(stream);
            chatCompletionRequest.setStop(stop);
            chatCompletionRequest.setMaxTokens(maxTokens);
            chatCompletionRequest.setPresencePenalty(presencePenalty);
            chatCompletionRequest.setFrequencyPenalty(frequencyPenalty);
            chatCompletionRequest.setLogitBias(logitBias);
            chatCompletionRequest.setUser(user);
            chatCompletionRequest.setFunctions(functions);
            chatCompletionRequest.setFunctionCall(functionCall);
            return chatCompletionRequest;
        }
    }

    public static class ChatCompletionRequestFunctionCall {
        String name;

        public ChatCompletionRequestFunctionCall(String name) {
            this.name = name;
        }

        public static ChatCompletionRequestFunctionCall of(String name) {
            return new ChatCompletionRequestFunctionCall(name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
