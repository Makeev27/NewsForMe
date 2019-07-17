package com.android.example.newsforme.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Json_data_sources {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sources")
    @Expose
    private List<S_source> sources = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<S_source> getSources() {
        return sources;
    }

    public void setSources(List<S_source> sources) {
        this.sources = sources;
    }

}
