package cn.ashersu.omni.model.audio;

import java.util.List;

/**
 * An object with the text transcription
 *
 * https://platform.openai.com/docs/api-reference/audio/create
 */
public class TranscriptionResult {

    /**
     * The text transcription.
     */
    private String text;

    /**
     * Task name
     * @apiNote verbose_json response format only
     */
    private String task;

    /**
     * Speech language
     * @apiNote verbose_json response format only
     */
    private String language;

    /**
     * Speech duration
     * @apiNote verbose_json response format only
     */
    private Double duration;

    /**
     * List of segments
     * @apiNote verbose_json response format only
     */
    private List<TranscriptionSegment> segments;
    
    public TranscriptionResult() {
    }
    
    public TranscriptionResult(String text, String task, String language, Double duration, List<TranscriptionSegment> segments) {
        this.text = text;
        this.task = task;
        this.language = language;
        this.duration = duration;
        this.segments = segments;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getTask() {
        return task;
    }
    
    public void setTask(String task) {
        this.task = task;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public void setLanguage(String language) {
        this.language = language;
    }
    
    public Double getDuration() {
        return duration;
    }
    
    public void setDuration(Double duration) {
        this.duration = duration;
    }
    
    public List<TranscriptionSegment> getSegments() {
        return segments;
    }
    
    public void setSegments(List<TranscriptionSegment> segments) {
        this.segments = segments;
    }
}
