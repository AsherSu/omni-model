package cn.ashersu.omni.model.service.openai.item;

import cn.ashersu.omni.model.audio.*;
import cn.ashersu.omni.model.service.openai.BaseOpenAIService;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * 提供OpenAI音频相关API调用功能，包括音频转录、翻译和语音生成
 */
public class AudioService extends BaseOpenAIService {
    
    public AudioService(OpenAIConfig config) {
        super(config);
    }
    
    /**
     * 将音频转录为文本
     * 
     * @param request 音频转录请求
     * @param audioPath 音频文件路径
     * @return 转录结果
     */
    public TranscriptionResult createTranscription(CreateTranscriptionRequest request, String audioPath) {
        java.io.File audio = new java.io.File(audioPath);
        return createTranscription(request, audio);
    }

    /**
     * 将音频转录为文本
     * 
     * @param request 音频转录请求
     * @param audio 音频文件
     * @return 转录结果
     */
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

        return execute(getApi().createTranscription(builder.build()));
    }

    /**
     * 将音频翻译为英文文本
     * 
     * @param request 翻译请求
     * @param audioPath 音频文件路径
     * @return 翻译结果
     */
    public TranslationResult createTranslation(CreateTranslationRequest request, String audioPath) {
        java.io.File audio = new java.io.File(audioPath);
        return createTranslation(request, audio);
    }

    /**
     * 将音频翻译为英文文本
     * 
     * @param request 翻译请求
     * @param audio 音频文件
     * @return 翻译结果
     */
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

        return execute(getApi().createTranslation(builder.build()));
    }
    
    /**
     * 生成语音
     * 
     * @param request 语音生成请求
     * @return 生成的语音内容
     */
    public ResponseBody createSpeech(CreateSpeechRequest request) {
        return execute(getApi().createSpeech(request));
    }
} 