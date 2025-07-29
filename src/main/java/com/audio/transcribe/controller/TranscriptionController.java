package com.audio.transcribe.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.model.ApiKey;
import org.springframework.ai.model.SimpleApiKey;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/transcribe")
public class TranscriptionController {

    @Value("${spring.ai.openai.api-key}")
    private String openAiApiKey;

    @Value("${spring.ai.openai.audio.transcription.base-url}")
    private String baseUrl;

    private OpenAiAudioTranscriptionModel transcriptionModel;

    @PostConstruct
    public void init() {
        ApiKey apiKey = new SimpleApiKey(openAiApiKey);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        RestClient.Builder restClientBuilder = RestClient.builder();
        WebClient.Builder webClientBuilder = WebClient.builder();
        ResponseErrorHandler responseErrorHandler = new DefaultResponseErrorHandler();

        OpenAiAudioApi openAiAudioApi = new OpenAiAudioApi(
                baseUrl, apiKey, headers, restClientBuilder, webClientBuilder, responseErrorHandler
        );
        this.transcriptionModel = new OpenAiAudioTranscriptionModel(openAiAudioApi);
    }

    @PostMapping("/trans")
    public ResponseEntity<String> transcribeAudio(@RequestParam("file") MultipartFile file) throws IOException {
        File tempFile = File.createTempFile("audio", ".wav");
        file.transferTo(tempFile);

        OpenAiAudioTranscriptionOptions transcriptionOptions = OpenAiAudioTranscriptionOptions.builder()
                .responseFormat(OpenAiAudioApi.TranscriptResponseFormat.TEXT)
                .language("en")
                .temperature(0f)
                .build();

        FileSystemResource audioFile = new FileSystemResource(tempFile.getPath());

        AudioTranscriptionPrompt transcriptionRequest = new AudioTranscriptionPrompt(audioFile, transcriptionOptions);
        AudioTranscriptionResponse response = transcriptionModel.call(transcriptionRequest);

        tempFile.delete();

        return new ResponseEntity<>(response.getResult().getOutput(), HttpStatus.OK);
    }
}
