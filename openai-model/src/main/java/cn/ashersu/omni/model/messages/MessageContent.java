package cn.ashersu.omni.model.messages;

import cn.ashersu.omni.model.messages.content.ImageFile;
import cn.ashersu.omni.model.messages.content.Text;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the content of a message
 * <p>
 * https://platform.openai.com/docs/api-reference/messages/object
 */
public class MessageContent {
    /**
     * The content type, either "text" or "image_file"
     */
    private String type;

    /**
     * Text content of the message. Only present if type == text
     */
    private Text text;

    /**
     * The image content of a message. Only present if type == image_file
     */
    @JsonProperty("image_file")
    private ImageFile imageFile;
    
    public MessageContent() {
    }
    
    public MessageContent(String type, Text text, ImageFile imageFile) {
        this.type = type;
        this.text = text;
        this.imageFile = imageFile;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public Text getText() {
        return text;
    }
    
    public void setText(Text text) {
        this.text = text;
    }
    
    public ImageFile getImageFile() {
        return imageFile;
    }
    
    public void setImageFile(ImageFile imageFile) {
        this.imageFile = imageFile;
    }
}
