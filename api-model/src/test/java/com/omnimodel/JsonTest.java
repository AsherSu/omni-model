package com.omnimodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import cn.ashersu.omni.model.DeleteResult;
import cn.ashersu.omni.model.audio.TranscriptionResult;
import cn.ashersu.omni.model.audio.TranslationResult;
import cn.ashersu.omni.model.completion.chat.ChatCompletionRequest;
import cn.ashersu.omni.model.completion.chat.ChatCompletionResult;
import cn.ashersu.omni.model.embedding.EmbeddingRequest;
import cn.ashersu.omni.model.embedding.EmbeddingResult;
import cn.ashersu.omni.model.engine.Engine;
import cn.ashersu.omni.model.fine_tuning.FineTuningEvent;
import cn.ashersu.omni.model.fine_tuning.FineTuningJob;
import cn.ashersu.omni.model.fine_tuning.FineTuningJobRequest;
import cn.ashersu.omni.model.finetune.FineTuneEvent;
import cn.ashersu.omni.model.finetune.FineTuneResult;
import cn.ashersu.omni.model.image.ImageResult;
import cn.ashersu.omni.model.messages.Message;
import cn.ashersu.omni.model.model.Model;
import cn.ashersu.omni.model.moderation.ModerationRequest;
import cn.ashersu.omni.model.moderation.ModerationResult;
import cn.ashersu.omni.model.edit.EditRequest;
import cn.ashersu.omni.model.edit.EditResult;
import cn.ashersu.omni.model.file.File;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {

    @ParameterizedTest
    @ValueSource(classes = {
            ChatCompletionRequest.class,
            ChatCompletionResult.class,
            DeleteResult.class,
            EditRequest.class,
            EditResult.class,
            EmbeddingRequest.class,
            EmbeddingResult.class,
            Engine.class,
            File.class,
            FineTuneEvent.class,
            FineTuneResult.class,
            FineTuningEvent.class,
            FineTuningJob.class,
            FineTuningJobRequest.class,
            ImageResult.class,
            TranscriptionResult.class,
            TranslationResult.class,
            Message.class,
            Model.class,
            ModerationRequest.class,
            ModerationResult.class
    })
    void objectMatchesJson(Class<?> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        String path = "src/test/resources/fixtures/" + clazz.getSimpleName() + ".json";
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        String json = new String(bytes);

        String actual = mapper.writeValueAsString(mapper.readValue(json, clazz));

        // Convert to JsonNodes to avoid any json formatting differences
        assertEquals(mapper.readTree(json), mapper.readTree(actual));
    }
}
