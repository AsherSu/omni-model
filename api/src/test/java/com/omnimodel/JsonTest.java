package com.omnimodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.omnimodel.audio.TranscriptionResult;
import com.omnimodel.audio.TranslationResult;
import com.omnimodel.completion.chat.ChatCompletionRequest;
import com.omnimodel.completion.chat.ChatCompletionResult;
import com.omnimodel.embedding.EmbeddingRequest;
import com.omnimodel.embedding.EmbeddingResult;
import com.omnimodel.engine.Engine;
import com.omnimodel.fine_tuning.FineTuningEvent;
import com.omnimodel.fine_tuning.FineTuningJob;
import com.omnimodel.fine_tuning.FineTuningJobRequest;
import com.omnimodel.finetune.FineTuneEvent;
import com.omnimodel.finetune.FineTuneResult;
import com.omnimodel.image.ImageResult;
import com.omnimodel.messages.Message;
import com.omnimodel.model.Model;
import com.omnimodel.moderation.ModerationRequest;
import com.omnimodel.moderation.ModerationResult;
import com.omnimodel.edit.EditRequest;
import com.omnimodel.edit.EditResult;
import com.omnimodel.file.File;
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
