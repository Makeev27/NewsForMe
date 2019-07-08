package com.android.example.newsforme.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Json_Data {

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("totalResults")
    @Expose
    public String totalResults;

    @SerializedName("articles")
    @Expose
    public List<articles> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<articles> getArticles() {
        return articles;
    }

    public void setArticles(List<articles> articles) {
        this.articles = articles;
    }
}
