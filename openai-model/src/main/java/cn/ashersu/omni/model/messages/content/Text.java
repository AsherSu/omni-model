package cn.ashersu.omni.model.messages.content;

import java.util.List;

/**
 * The text content that is part of a message
 * <p>
 * https://platform.openai.com/docs/api-reference/messages/object
 */
public class Text {

    /**
     * The data that makes up the text.
     */
    private String value;

    /**
     * Text annotations that show additional details
     */
    private List<Annotation> annotations;
    
    public Text() {
    }
    
    public Text(String value, List<Annotation> annotations) {
        this.value = value;
        this.annotations = annotations;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public List<Annotation> getAnnotations() {
        return annotations;
    }
    
    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }
}
