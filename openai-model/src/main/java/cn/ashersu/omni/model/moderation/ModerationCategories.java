package cn.ashersu.omni.model.moderation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * An object containing the flags for each moderation category
 *
 * https://beta.openai.com/docs/api-reference/moderations/create
 */
public class ModerationCategories {

    private boolean hate;

    @JsonProperty("hate/threatening")
    private boolean hateThreatening;

    @JsonProperty("self-harm")
    private boolean selfHarm;

    private boolean sexual;

    @JsonProperty("sexual/minors")
    private boolean sexualMinors;

    private boolean violence;

    @JsonProperty("violence/graphic")
    private boolean violenceGraphic;
    
    public boolean isHate() {
        return hate;
    }
    
    public void setHate(boolean hate) {
        this.hate = hate;
    }
    
    public boolean isHateThreatening() {
        return hateThreatening;
    }
    
    public void setHateThreatening(boolean hateThreatening) {
        this.hateThreatening = hateThreatening;
    }
    
    public boolean isSelfHarm() {
        return selfHarm;
    }
    
    public void setSelfHarm(boolean selfHarm) {
        this.selfHarm = selfHarm;
    }
    
    public boolean isSexual() {
        return sexual;
    }
    
    public void setSexual(boolean sexual) {
        this.sexual = sexual;
    }
    
    public boolean isSexualMinors() {
        return sexualMinors;
    }
    
    public void setSexualMinors(boolean sexualMinors) {
        this.sexualMinors = sexualMinors;
    }
    
    public boolean isViolence() {
        return violence;
    }
    
    public void setViolence(boolean violence) {
        this.violence = violence;
    }
    
    public boolean isViolenceGraphic() {
        return violenceGraphic;
    }
    
    public void setViolenceGraphic(boolean violenceGraphic) {
        this.violenceGraphic = violenceGraphic;
    }
}
