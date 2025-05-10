package cn.ashersu.omni.model.audio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * An object represents transcription segment
 *
 * https://platform.openai.com/docs/api-reference/audio/create
 */
public class TranscriptionSegment {

    private Integer id;
    private Integer seek;
    private Double start;
    private Double end;
    private String text;
    private List<Integer> tokens;
    private Double temperature;
    @JsonProperty("avg_logprob")
    private Double averageLogProb;
    @JsonProperty("compression_ratio")
    private Double compressionRatio;
    @JsonProperty("no_speech_prob")
    private Double noSpeechProb;
    @JsonProperty("transient")
    private Boolean transientFlag;
    
    public TranscriptionSegment() {
    }
    
    public TranscriptionSegment(Integer id, Integer seek, Double start, Double end, String text, 
                               List<Integer> tokens, Double temperature, Double averageLogProb,
                               Double compressionRatio, Double noSpeechProb, Boolean transientFlag) {
        this.id = id;
        this.seek = seek;
        this.start = start;
        this.end = end;
        this.text = text;
        this.tokens = tokens;
        this.temperature = temperature;
        this.averageLogProb = averageLogProb;
        this.compressionRatio = compressionRatio;
        this.noSpeechProb = noSpeechProb;
        this.transientFlag = transientFlag;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getSeek() {
        return seek;
    }
    
    public void setSeek(Integer seek) {
        this.seek = seek;
    }
    
    public Double getStart() {
        return start;
    }
    
    public void setStart(Double start) {
        this.start = start;
    }
    
    public Double getEnd() {
        return end;
    }
    
    public void setEnd(Double end) {
        this.end = end;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public List<Integer> getTokens() {
        return tokens;
    }
    
    public void setTokens(List<Integer> tokens) {
        this.tokens = tokens;
    }
    
    public Double getTemperature() {
        return temperature;
    }
    
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
    
    public Double getAverageLogProb() {
        return averageLogProb;
    }
    
    public void setAverageLogProb(Double averageLogProb) {
        this.averageLogProb = averageLogProb;
    }
    
    public Double getCompressionRatio() {
        return compressionRatio;
    }
    
    public void setCompressionRatio(Double compressionRatio) {
        this.compressionRatio = compressionRatio;
    }
    
    public Double getNoSpeechProb() {
        return noSpeechProb;
    }
    
    public void setNoSpeechProb(Double noSpeechProb) {
        this.noSpeechProb = noSpeechProb;
    }
    
    public Boolean getTransientFlag() {
        return transientFlag;
    }
    
    public void setTransientFlag(Boolean transientFlag) {
        this.transientFlag = transientFlag;
    }
}
