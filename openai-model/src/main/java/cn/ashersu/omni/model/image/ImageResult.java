package cn.ashersu.omni.model.image;

import java.util.List;

/**
 * An object with a list of image results.
 *
 * https://beta.openai.com/docs/api-reference/images
 */
public class ImageResult {

    /**
     * The creation time in epoch seconds.
     */
    private Long created;

    /**
     * List of image results.
     */
    private List<Image> data;
    
    public Long getCreated() {
        return created;
    }
    
    public void setCreated(Long created) {
        this.created = created;
    }
    
    public List<Image> getData() {
        return data;
    }
    
    public void setData(List<Image> data) {
        this.data = data;
    }
}
