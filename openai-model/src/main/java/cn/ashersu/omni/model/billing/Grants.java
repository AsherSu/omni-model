package cn.ashersu.omni.model.billing;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 *
 *
 */
public class Grants {
    private String object;
    @JsonProperty("data")
    private List<Datum> data;
    
    public Grants() {
    }
    
    public Grants(String object, List<Datum> data) {
        this.object = object;
        this.data = data;
    }
    
    public String getObject() {
        return object;
    }
    
    public void setObject(String object) {
        this.object = object;
    }
    
    public List<Datum> getData() {
        return data;
    }
    
    public void setData(List<Datum> data) {
        this.data = data;
    }
}
