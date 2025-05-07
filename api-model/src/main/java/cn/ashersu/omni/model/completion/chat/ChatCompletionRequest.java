package cn.ashersu.omni.model.completion.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ChatCompletionRequestFunctionCall {
        String name;

        public static ChatCompletionRequestFunctionCall of(String name) {
            return new ChatCompletionRequestFunctionCall(name);
        }

    }
}
