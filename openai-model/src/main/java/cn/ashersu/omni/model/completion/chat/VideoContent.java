package cn.ashersu.omni.model.completion.chat;

import java.util.List;

public class VideoContent {
    private String type="video";
    private List<String> video;

    public VideoContent() {
    }

    public VideoContent(String type, List<String> content) {
        this.type = type;
        this.video = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getVideo() {
        return video;
    }

    public void setVideo(List<String> content) {
        this.video = content;
    }
}
