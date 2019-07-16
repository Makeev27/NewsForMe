package com.android.example.newsforme.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class articles {

    @SerializedName("source")
    @Expose
    public source source;

    @SerializedName("author")
    @Expose
    public String author;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("urlToImage")
    @Expose
    public String urlToImage;

    @SerializedName("content")
    @Expose
    public String content;


    public com.android.example.newsforme.Data.source getSource() {
        return source;
    }

    public void setSource(com.android.example.newsforme.Data.source source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
