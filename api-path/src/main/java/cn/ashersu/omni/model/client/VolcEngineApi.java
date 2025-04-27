package cn.ashersu.omni.model.client;

import cn.ashersu.omni.model.fine_tuning.FineTuningEvent;
import cn.ashersu.omni.model.fine_tuning.FineTuningJob;
import cn.ashersu.omni.model.fine_tuning.FineTuningJobRequest;
import cn.ashersu.omni.model.moderation.ModerationRequest;
import cn.ashersu.omni.model.moderation.ModerationResult;
import cn.ashersu.omni.model.DeleteResult;
import cn.ashersu.omni.model.OpenAiResponse;
import cn.ashersu.omni.model.assistants.*;
import cn.ashersu.omni.model.runs.*;
import cn.ashersu.omni.model.audio.CreateSpeechRequest;
import cn.ashersu.omni.model.audio.TranscriptionResult;
import cn.ashersu.omni.model.audio.TranslationResult;
import cn.ashersu.omni.model.billing.BillingUsage;
import cn.ashersu.omni.model.billing.Subscription;
import cn.ashersu.omni.model.completion.CompletionRequest;
import cn.ashersu.omni.model.completion.CompletionResult;
import cn.ashersu.omni.model.completion.chat.ChatCompletionRequest;
import cn.ashersu.omni.model.completion.chat.ChatCompletionResult;
import cn.ashersu.omni.model.edit.EditRequest;
import cn.ashersu.omni.model.edit.EditResult;
import cn.ashersu.omni.model.embedding.EmbeddingRequest;
import cn.ashersu.omni.model.embedding.EmbeddingResult;
import cn.ashersu.omni.model.engine.Engine;
import cn.ashersu.omni.model.file.File;
import cn.ashersu.omni.model.finetune.FineTuneEvent;
import cn.ashersu.omni.model.finetune.FineTuneRequest;
import cn.ashersu.omni.model.finetune.FineTuneResult;
import cn.ashersu.omni.model.image.CreateImageRequest;
import cn.ashersu.omni.model.image.ImageResult;
import cn.ashersu.omni.model.messages.Message;
import cn.ashersu.omni.model.messages.MessageFile;
import cn.ashersu.omni.model.messages.MessageRequest;
import cn.ashersu.omni.model.messages.ModifyMessageRequest;
import cn.ashersu.omni.model.model.Model;
import cn.ashersu.omni.model.threads.Thread;
import cn.ashersu.omni.model.threads.ThreadRequest;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.time.LocalDate;
import java.util.Map;

public interface VolcEngineApi {

    @GET("models")
    Single<OpenAiResponse<Model>> listModels();

    @GET("models/{model_id}")
    Single<Model> getModel(@Path("model_id") String modelId);

    @POST("chat/completions")
    Single<CompletionResult> createCompletion(@Body CompletionRequest request);

    @Streaming
    @POST("completions")
    Call<ResponseBody> createCompletionStream(@Body CompletionRequest request);

    @POST("chat/completions")
    Single<ChatCompletionResult> createChatCompletion(@Body ChatCompletionRequest request);

    @Streaming
    @POST("chat/completions")
    Call<ResponseBody> createChatCompletionStream(@Body ChatCompletionRequest request);

    @Deprecated
    @POST("engines/{engine_id}/completions")
    Single<CompletionResult> createCompletion(@Path("engine_id") String engineId, @Body CompletionRequest request);

    @POST("edits")
    Single<EditResult> createEdit(@Body EditRequest request);

    @Deprecated
    @POST("engines/{engine_id}/edits")
    Single<EditResult> createEdit(@Path("engine_id") String engineId, @Body EditRequest request);

    @POST("embeddings")
    Single<EmbeddingResult> createEmbeddings(@Body EmbeddingRequest request);

    @Deprecated
    @POST("engines/{engine_id}/embeddings")
    Single<EmbeddingResult> createEmbeddings(@Path("engine_id") String engineId, @Body EmbeddingRequest request);

    @GET("files")
    Single<OpenAiResponse<File>> listFiles();

    @Multipart
    @POST("files")
    Single<File> uploadFile(@Part("purpose") RequestBody purpose, @Part MultipartBody.Part file);

    @DELETE("files/{file_id}")
    Single<DeleteResult> deleteFile(@Path("file_id") String fileId);

    @GET("files/{file_id}")
    Single<File> retrieveFile(@Path("file_id") String fileId);

    @Streaming
    @GET("files/{file_id}/content")
    Single<ResponseBody> retrieveFileContent(@Path("file_id") String fileId);

    @POST("fine_tuning/jobs")
    Single<FineTuningJob> createFineTuningJob(@Body FineTuningJobRequest request);

    @GET("fine_tuning/jobs")
    Single<OpenAiResponse<FineTuningJob>> listFineTuningJobs();

    @GET("fine_tuning/jobs/{fine_tuning_job_id}")
    Single<FineTuningJob> retrieveFineTuningJob(@Path("fine_tuning_job_id") String fineTuningJobId);

    @POST("fine_tuning/jobs/{fine_tuning_job_id}/cancel")
    Single<FineTuningJob> cancelFineTuningJob(@Path("fine_tuning_job_id") String fineTuningJobId);

    @GET("fine_tuning/jobs/{fine_tuning_job_id}/events")
    Single<OpenAiResponse<FineTuningEvent>> listFineTuningJobEvents(@Path("fine_tuning_job_id") String fineTuningJobId);

    @Deprecated
    @POST("fine-tunes")
    Single<FineTuneResult> createFineTune(@Body FineTuneRequest request);

    @POST("completions")
    Single<CompletionResult> createFineTuneCompletion(@Body CompletionRequest request);

    @Deprecated
    @GET("fine-tunes")
    Single<OpenAiResponse<FineTuneResult>> listFineTunes();

    @Deprecated
    @GET("fine-tunes/{fine_tune_id}")
    Single<FineTuneResult> retrieveFineTune(@Path("fine_tune_id") String fineTuneId);

    @Deprecated
    @POST("fine-tunes/{fine_tune_id}/cancel")
    Single<FineTuneResult> cancelFineTune(@Path("fine_tune_id") String fineTuneId);

    @Deprecated
    @GET("fine-tunes/{fine_tune_id}/events")
    Single<OpenAiResponse<FineTuneEvent>> listFineTuneEvents(@Path("fine_tune_id") String fineTuneId);

    @DELETE("models/{fine_tune_id}")
    Single<DeleteResult> deleteFineTune(@Path("fine_tune_id") String fineTuneId);

    @POST("images/generations")
    Single<ImageResult> createImage(@Body CreateImageRequest request);

    @POST("images/edits")
    Single<ImageResult> createImageEdit(@Body RequestBody requestBody);

    @POST("images/variations")
    Single<ImageResult> createImageVariation(@Body RequestBody requestBody);

    @POST("audio/transcriptions")
    Single<TranscriptionResult> createTranscription(@Body RequestBody requestBody);

    @POST("audio/translations")
    Single<TranslationResult> createTranslation(@Body RequestBody requestBody);

    @POST("audio/speech")
    Single<ResponseBody> createSpeech(@Body CreateSpeechRequest requestBody);

    @POST("moderations")
    Single<ModerationResult> createModeration(@Body ModerationRequest request);

    @Deprecated
    @GET("v1/engines")
    Single<OpenAiResponse<Engine>> getEngines();

    @Deprecated
    @GET("engines/{engine_id}")
    Single<Engine> getEngine(@Path("engine_id") String engineId);

    /**
     * Account information inquiry: It contains total amount (in US dollars) and other information.
     *
     * @return
     */
    @Deprecated
    @GET("v1/dashboard/billing/subscription")
    Single<Subscription> subscription();

    /**
     * Account call interface consumption amount inquiry.
     * totalUsage = Total amount used by the account (in US cents).
     *
     * @param starDate
     * @param endDate
     * @return Consumption amount information.
     */
    @Deprecated
    @GET("dashboard/billing/usage")
    Single<BillingUsage> billingUsage(@Query("start_date") LocalDate starDate, @Query("end_date") LocalDate endDate);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("assistants")
    Single<Assistant> createAssistant(@Body AssistantRequest request);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("assistants/{assistant_id}")
    Single<Assistant> retrieveAssistant(@Path("assistant_id") String assistantId);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("assistants/{assistant_id}")
    Single<Assistant> modifyAssistant(@Path("assistant_id") String assistantId, @Body ModifyAssistantRequest request);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @DELETE("assistants/{assistant_id}")
    Single<DeleteResult> deleteAssistant(@Path("assistant_id") String assistantId);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("assistants")
    Single<OpenAiResponse<Assistant>> listAssistants(@QueryMap Map<String, Object> filterRequest);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("assistants/{assistant_id}/files")
    Single<AssistantFile> createAssistantFile(@Path("assistant_id") String assistantId, @Body AssistantFileRequest fileRequest);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("assistants/{assistant_id}/files/{file_id}")
    Single<AssistantFile> retrieveAssistantFile(@Path("assistant_id") String assistantId, @Path("file_id") String fileId);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @DELETE("assistants/{assistant_id}/files/{file_id}")
    Single<DeleteResult> deleteAssistantFile(@Path("assistant_id") String assistantId, @Path("file_id") String fileId);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("assistants/{assistant_id}/files")
    Single<OpenAiResponse<AssistantFile>> listAssistantFiles(@Path("assistant_id") String assistantId, @QueryMap Map<String, Object> filterRequest);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("threads")
    Single<Thread> createThread(@Body ThreadRequest request);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("threads/{thread_id}")
    Single<Thread> retrieveThread(@Path("thread_id") String threadId);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("threads/{thread_id}")
    Single<Thread> modifyThread(@Path("thread_id") String threadId, @Body ThreadRequest request);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @DELETE("threads/{thread_id}")
    Single<DeleteResult> deleteThread(@Path("thread_id") String threadId);


    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("threads/{thread_id}/messages")
    Single<Message> createMessage(@Path("thread_id") String threadId, @Body MessageRequest request);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("threads/{thread_id}/messages/{message_id}")
    Single<Message> retrieveMessage(@Path("thread_id") String threadId, @Path("message_id") String messageId);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @POST("threads/{thread_id}/messages/{message_id}")
    Single<Message> modifyMessage(@Path("thread_id") String threadId, @Path("message_id") String messageId, @Body ModifyMessageRequest request);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("threads/{thread_id}/messages")
    Single<OpenAiResponse<Message>> listMessages(@Path("thread_id") String threadId);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("threads/{thread_id}/messages")
    Single<OpenAiResponse<Message>> listMessages(@Path("thread_id") String threadId, @QueryMap Map<String, Object> filterRequest);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("threads/{thread_id}/messages/{message_id}/files/{file_id}")
    Single<MessageFile> retrieveMessageFile(@Path("thread_id") String threadId, @Path("message_id") String messageId, @Path("file_id") String fileId);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("threads/{thread_id}/messages/{message_id}/files")
    Single<OpenAiResponse<MessageFile>> listMessageFiles(@Path("thread_id") String threadId, @Path("message_id") String messageId);

    @Headers({"OpenAI-Beta: assistants=v1"})
    @GET("threads/{thread_id}/messages/{message_id}/files")
    Single<OpenAiResponse<MessageFile>> listMessageFiles(@Path("thread_id") String threadId, @Path("message_id") String messageId, @QueryMap Map<String, Object> filterRequest);

    @Headers("OpenAI-Beta: assistants=v1")
    @POST("threads/{thread_id}/runs")
    Single<Run> createRun(@Path("thread_id") String threadId, @Body RunCreateRequest runCreateRequest);

    @Headers("OpenAI-Beta: assistants=v1")
    @GET("threads/{thread_id}/runs/{run_id}")
    Single<Run> retrieveRun(@Path("thread_id") String threadId, @Path("run_id") String runId);

    @Headers("OpenAI-Beta: assistants=v1")
    @POST("threads/{thread_id}/runs/{run_id}")
    Single<Run> modifyRun(@Path("thread_id") String threadId, @Path("run_id") String runId, @Body Map<String, String> metadata);

    @Headers("OpenAI-Beta: assistants=v1")
    @GET("threads/{thread_id}/runs")
    Single<OpenAiResponse<Run>> listRuns(@Path("thread_id") String threadId, @QueryMap Map<String, String> listSearchParameters);


    @Headers("OpenAI-Beta: assistants=v1")
    @POST("threads/{thread_id}/runs/{run_id}/submit_tool_outputs")
    Single<Run> submitToolOutputs(@Path("thread_id") String threadId, @Path("run_id") String runId, @Body SubmitToolOutputsRequest submitToolOutputsRequest);


    @Headers("OpenAI-Beta: assistants=v1")
    @POST("threads/{thread_id}/runs/{run_id}/cancel")
    Single<Run> cancelRun(@Path("thread_id") String threadId, @Path("run_id") String runId);

    @Headers("OpenAI-Beta: assistants=v1")
    @POST("threads/runs")
    Single<Run> createThreadAndRun(@Body CreateThreadAndRunRequest createThreadAndRunRequest);

    @Headers("OpenAI-Beta: assistants=v1")
    @GET("threads/{thread_id}/runs/{run_id}/steps/{step_id}")
    Single<RunStep> retrieveRunStep(@Path("thread_id") String threadId, @Path("run_id") String runId, @Path("step_id") String stepId);

    @Headers("OpenAI-Beta: assistants=v1")
    @GET("threads/{thread_id}/runs/{run_id}/steps")
    Single<OpenAiResponse<RunStep>> listRunSteps(@Path("thread_id") String threadId, @Path("run_id") String runId, @QueryMap Map<String, String> listSearchParameters);
}
