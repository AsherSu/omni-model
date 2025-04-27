package cn.ashersu.omni.model.service.openai;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import cn.ashersu.omni.model.OpenAiResponse;
import cn.ashersu.omni.model.assistants.Assistant;
import cn.ashersu.omni.model.assistants.AssistantFunction;
import cn.ashersu.omni.model.assistants.AssistantRequest;
import cn.ashersu.omni.model.assistants.AssistantToolsEnum;
import cn.ashersu.omni.model.assistants.Tool;
import cn.ashersu.omni.model.completion.chat.ChatCompletionRequest;
import cn.ashersu.omni.model.completion.chat.ChatFunction;
import cn.ashersu.omni.model.completion.chat.ChatFunctionCall;
import cn.ashersu.omni.model.messages.Message;
import cn.ashersu.omni.model.messages.MessageRequest;
import cn.ashersu.omni.model.runs.RequiredAction;
import cn.ashersu.omni.model.runs.Run;
import cn.ashersu.omni.model.runs.RunCreateRequest;
import cn.ashersu.omni.model.runs.SubmitToolOutputRequestItem;
import cn.ashersu.omni.model.runs.SubmitToolOutputsRequest;
import cn.ashersu.omni.model.runs.ToolCall;
import cn.ashersu.omni.model.service.OpenAiService;
import cn.ashersu.omni.model.service.TestConfig;
import cn.ashersu.omni.model.mixin.ChatCompletionRequestMixIn;
import cn.ashersu.omni.model.mixin.ChatFunctionCallMixIn;
import cn.ashersu.omni.model.mixin.ChatFunctionMixIn;
import cn.ashersu.omni.model.threads.Thread;
import cn.ashersu.omni.model.threads.ThreadRequest;
import cn.ashersu.omni.model.utils.TikTokensUtil;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AssistantFunctionTest {
    String token = TestConfig.getOpenAiApiKey();
    OpenAiService service = new OpenAiService(token, Duration.ofMinutes(1));

    @Test
    void createRetrieveRun() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.addMixIn(ChatFunction.class, ChatFunctionMixIn.class);
        mapper.addMixIn(ChatCompletionRequest.class, ChatCompletionRequestMixIn.class);
        mapper.addMixIn(ChatFunctionCall.class, ChatFunctionCallMixIn.class);
        
        String funcDef = "{\n" +
                "  \"type\": \"object\",\n" +
                "  \"properties\": {\n" +
                "    \"location\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"description\": \"The city and state, e.g. San Francisco, CA\"\n" +
                "    },\n" +
                "    \"unit\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"enum\": [\"celsius\", \"fahrenheit\"]\n" +
                "    }\n" +
                "  },\n" +
                "  \"required\": [\"location\"]\n" +
                "}";
        Map<String, Object> funcParameters = mapper.readValue(funcDef, new TypeReference<Map<String, Object>>() {});
        AssistantFunction function = AssistantFunction.builder()
                .name("weather_reporter")
                .description("Get the current weather of a location")
                .parameters(funcParameters)
                .build();

        List<Tool> toolList = new ArrayList<>();
        Tool funcTool = new Tool(AssistantToolsEnum.FUNCTION, function);
        toolList.add(funcTool);
        
        
        AssistantRequest assistantRequest = AssistantRequest.builder()
                .model(TikTokensUtil.ModelEnum.GPT_4_1106_preview.getName())
                .name("MATH_TUTOR")
                .instructions("You are a personal Math Tutor.")
                .tools(toolList)
                .build();
        Assistant assistant = service.createAssistant(assistantRequest);

        ThreadRequest threadRequest = ThreadRequest.builder()
                .build();
        Thread thread = service.createThread(threadRequest);

        MessageRequest messageRequest = MessageRequest.builder()
                .content("What's the weather of Xiamen?")
                .build();

        Message message = service.createMessage(thread.getId(), messageRequest);

        RunCreateRequest runCreateRequest = RunCreateRequest.builder()
                .assistantId(assistant.getId())
                .build();

        Run run = service.createRun(thread.getId(), runCreateRequest);
        assertNotNull(run);

        Run retrievedRun = service.retrieveRun(thread.getId(), run.getId());
        while (!(retrievedRun.getStatus().equals("completed")) 
                && !(retrievedRun.getStatus().equals("failed")) 
                && !(retrievedRun.getStatus().equals("requires_action"))){
            retrievedRun = service.retrieveRun(thread.getId(), run.getId());
        }
        if (retrievedRun.getStatus().equals("requires_action")) {
            RequiredAction requiredAction = retrievedRun.getRequiredAction();
            System.out.println("requiredAction");
            System.out.println(mapper.writeValueAsString(requiredAction));
            List<ToolCall> toolCalls = requiredAction.getSubmitToolOutputs().getToolCalls();
            ToolCall toolCall = toolCalls.get(0);
            String toolCallId = toolCall.getId();

            SubmitToolOutputRequestItem toolOutputRequestItem = SubmitToolOutputRequestItem.builder()
                    .toolCallId(toolCallId)
                    .output("sunny")
                    .build();
            List<SubmitToolOutputRequestItem> toolOutputRequestItems = new ArrayList<>();
            toolOutputRequestItems.add(toolOutputRequestItem);
            SubmitToolOutputsRequest submitToolOutputsRequest = SubmitToolOutputsRequest.builder()
                    .toolOutputs(toolOutputRequestItems)
                    .build();
            retrievedRun = service.submitToolOutputs(retrievedRun.getThreadId(), retrievedRun.getId(), submitToolOutputsRequest);

            while (!(retrievedRun.getStatus().equals("completed"))
                    && !(retrievedRun.getStatus().equals("failed"))
                    && !(retrievedRun.getStatus().equals("requires_action"))){
                retrievedRun = service.retrieveRun(thread.getId(), run.getId());
            }

            OpenAiResponse<Message> response = service.listMessages(thread.getId());

            List<Message> messages = response.getData();

            System.out.println(mapper.writeValueAsString(messages));
            
        }
    }
}
