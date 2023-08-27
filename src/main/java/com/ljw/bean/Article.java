package com.ljw.bean;

public class Article {
    private Integer id;
    private String title;
    private String content;
    private String title_time;
    private Integer author_id;

    public Article() {
    }

    public Article(Integer id, String title, String content, String title_time, Integer author_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.title_time = title_time;
        this.author_id = author_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle_time() {
        return title_time;
    }

    public void setTitle_time(String title_time) {
        this.title_time = title_time;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", title_time='" + title_time + '\'' +
                ", author_id=" + author_id +
                '}';
    }
}


