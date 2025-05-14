package cn.ashersu.omni.model.completion.chat;

import java.util.HashMap;
import java.util.Map;

public class ImageContent {
    private String type = "image_url";
    private Map<String,String> imageUrl;

    public ImageContent() {
    }

    public ImageContent(Map<String,String>  imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ImageContent(String type, Map<String,String>  imageUrl) {
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String,String>  getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Map<String,String>  imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static ImageContent url(String imageUrl) {
        Map<String, String> map = new HashMap<>();
        map.put("url", imageUrl);
        return new ImageContent(map);
    }
}
