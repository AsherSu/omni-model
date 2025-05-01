package cn.ashersu.omni.model.news;

import cn.ashersu.omni.model.DeleteResult;
import cn.ashersu.omni.model.ListSearchParameters;
import cn.ashersu.omni.model.OpenAiResponse;
import cn.ashersu.omni.model.audio.*;
import cn.ashersu.omni.model.billing.BillingUsage;
import cn.ashersu.omni.model.billing.Subscription;
import cn.ashersu.omni.model.completion.chat.ChatCompletionChunk;
import cn.ashersu.omni.model.completion.chat.ChatFunctionCall;
import cn.ashersu.omni.model.completion.chat.ChatMessage;
import cn.ashersu.omni.model.completion.chat.ChatMessageRole;
import cn.ashersu.omni.model.embedding.EmbeddingRequest;
import cn.ashersu.omni.model.embedding.EmbeddingResult;
import cn.ashersu.omni.model.moderation.ModerationRequest;
import cn.ashersu.omni.model.moderation.ModerationResult;
import cn.ashersu.omni.model.runs.*;
import cn.ashersu.omni.model.service.ChatMessageAccumulator;
import cn.ashersu.omni.model.threads.Thread;
import cn.ashersu.omni.model.threads.ThreadRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import io.reactivex.Flowable;
import io.reactivex.Single;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OtherService extends BaseOpenAIService{
    public OtherService(OpenAIConfig config) {
        super(config);
    }

    public EmbeddingResult createEmbeddings(EmbeddingRequest request) {
        return execute(api.createEmbeddings(request));
    }

    public TranscriptionResult createTranscription(CreateTranscriptionRequest request, String audioPath) {
        java.io.File audio = new java.io.File(audioPath);
        return createTranscription(request, audio);
    }

    public TranscriptionResult createTranscription(CreateTranscriptionRequest request, java.io.File audio) {
        RequestBody audioBody = RequestBody.create(MediaType.parse("audio"), audio);

        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MediaType.get("multipart/form-data"))
                .addFormDataPart("model", request.getModel())
                .addFormDataPart("file", audio.getName(), audioBody);

        if (request.getPrompt() != null) {
            builder.addFormDataPart("prompt", request.getPrompt());
        }
        if (request.getResponseFormat() != null) {
            builder.addFormDataPart("response_format", request.getResponseFormat());
        }
        if (request.getTemperature() != null) {
            builder.addFormDataPart("temperature", request.getTemperature().toString());
        }
        if (request.getLanguage() != null) {
            builder.addFormDataPart("language", request.getLanguage());
        }

        return execute(api.createTranscription(builder.build()));
    }

    public TranslationResult createTranslation(CreateTranslationRequest request, String audioPath) {
        java.io.File audio = new java.io.File(audioPath);
        return createTranslation(request, audio);
    }

    public TranslationResult createTranslation(CreateTranslationRequest request, java.io.File audio) {
        RequestBody audioBody = RequestBody.create(MediaType.parse("audio"), audio);

        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MediaType.get("multipart/form-data"))
                .addFormDataPart("model", request.getModel())
                .addFormDataPart("file", audio.getName(), audioBody);

        if (request.getPrompt() != null) {
            builder.addFormDataPart("prompt", request.getPrompt());
        }
        if (request.getResponseFormat() != null) {
            builder.addFormDataPart("response_format", request.getResponseFormat());
        }
        if (request.getTemperature() != null) {
            builder.addFormDataPart("temperature", request.getTemperature().toString());
        }

        return execute(api.createTranslation(builder.build()));
    }

    public ModerationResult createModeration(ModerationRequest request) {
        return execute(api.createModeration(request));
    }

    public ResponseBody createSpeech(CreateSpeechRequest request) {
        return execute(api.createSpeech(request));
    }



    public Thread createThread(ThreadRequest request) {
        return execute(api.createThread(request));
    }

    public Thread retrieveThread(String threadId) {
        return execute(api.retrieveThread(threadId));
    }

    public Thread modifyThread(String threadId, ThreadRequest request) {
        return execute(api.modifyThread(threadId, request));
    }

    public DeleteResult deleteThread(String threadId) {
        return execute(api.deleteThread(threadId));
    }





    public Run createRun(String threadId, RunCreateRequest runCreateRequest) {
        return execute(api.createRun(threadId, runCreateRequest));
    }

    public Run retrieveRun(String threadId, String runId) {
        return execute(api.retrieveRun(threadId, runId));
    }

    public Run modifyRun(String threadId, String runId, Map<String, String> metadata) {
        return execute(api.modifyRun(threadId, runId, metadata));
    }

    public OpenAiResponse<Run> listRuns(String threadId, ListSearchParameters listSearchParameters) {
        Map<String, String> search = new HashMap<>();
        if (listSearchParameters != null) {
            ObjectMapper mapper = defaultObjectMapper();
            search = mapper.convertValue(listSearchParameters, Map.class);
        }
        return execute(api.listRuns(threadId, search));
    }

    public Run submitToolOutputs(String threadId, String runId, SubmitToolOutputsRequest submitToolOutputsRequest) {
        return execute(api.submitToolOutputs(threadId, runId, submitToolOutputsRequest));
    }

    public Run cancelRun(String threadId, String runId) {
        return execute(api.cancelRun(threadId, runId));
    }

    public Run createThreadAndRun(CreateThreadAndRunRequest createThreadAndRunRequest) {
        return execute(api.createThreadAndRun(createThreadAndRunRequest));
    }

    public RunStep retrieveRunStep(String threadId, String runId, String stepId) {
        return execute(api.retrieveRunStep(threadId, runId, stepId));
    }

    public OpenAiResponse<RunStep> listRunSteps(String threadId, String runId, ListSearchParameters listSearchParameters) {
        Map<String, String> search = new HashMap<>();
        if (listSearchParameters != null) {
            ObjectMapper mapper = defaultObjectMapper();
            search = mapper.convertValue(listSearchParameters, Map.class);
        }
        return execute(api.listRunSteps(threadId, runId, search));
    }

    /**
     * Shuts down the OkHttp ExecutorService.
     * The default behaviour of OkHttp's ExecutorService (ConnectionPool)
     * is to shut down after an idle timeout of 60s.
     * Call this method to shut down the ExecutorService immediately.
     */
    public void shutdownExecutor() {
        Objects.requireNonNull(this.executorService, "executorService must be set in order to shut down");
        this.executorService.shutdown();
    }

    public Flowable<ChatMessageAccumulator> mapStreamToAccumulator(Flowable<ChatCompletionChunk> flowable) {
        ChatFunctionCall functionCall = new ChatFunctionCall(null, null);
        ChatMessage accumulatedMessage = new ChatMessage(ChatMessageRole.ASSISTANT.value(), null);

        return flowable.map(chunk -> {
            ChatMessage messageChunk = chunk.getChoices().get(0).getMessage();
            if (messageChunk.getFunctionCall() != null) {
                if (messageChunk.getFunctionCall().getName() != null) {
                    String namePart = messageChunk.getFunctionCall().getName();
                    functionCall.setName((functionCall.getName() == null ? "" : functionCall.getName()) + namePart);
                }
                if (messageChunk.getFunctionCall().getArguments() != null) {
                    String argumentsPart = messageChunk.getFunctionCall().getArguments() == null ? "" : messageChunk.getFunctionCall().getArguments().asText();
                    functionCall.setArguments(new TextNode((functionCall.getArguments() == null ? "" : functionCall.getArguments().asText()) + argumentsPart));
                }
                accumulatedMessage.setFunctionCall(functionCall);
            } else {
                accumulatedMessage.setContent((accumulatedMessage.getContent() == null ? "" : accumulatedMessage.getContent()) + (messageChunk.getContent() == null ? "" : messageChunk.getContent()));
            }

            if (chunk.getChoices().get(0).getFinishReason() != null) { // last
                if (functionCall.getArguments() != null) {
                    functionCall.setArguments(mapper.readTree(functionCall.getArguments().asText()));
                    accumulatedMessage.setFunctionCall(functionCall);
                }
            }

            return new ChatMessageAccumulator(messageChunk, accumulatedMessage);
        });
    }

    /**
     * Account information inquiry: including total amount and other information.
     *
     * @return Account information.
     */
    public Subscription subscription() {
        Single<Subscription> subscription = api.subscription();
        return subscription.blockingGet();
    }

    /**
     * Account API consumption amount information inquiry.
     * Up to 100 days of inquiry.
     *
     * @param starDate
     * @param endDate
     * @return Consumption amount information.
     */
    public BillingUsage billingUsage(@NotNull LocalDate starDate, @NotNull LocalDate endDate) {
        Single<BillingUsage> billingUsage = api.billingUsage(starDate, endDate);
        return billingUsage.blockingGet();
    }
}
