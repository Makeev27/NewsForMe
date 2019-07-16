package com.android.example.newsforme.Model;

public class News {

    public String posterUrl;
    public String description;
    public String source;
    public String content;
    public String author;
    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public News(String posterUrl, String description, String source, String content, String author, String title) {
        this.posterUrl = posterUrl;
        this.description = description;
        this.source = source;
        this.content = content;
        this.author = author;
        this.title = title;
    }

    public News() {
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
