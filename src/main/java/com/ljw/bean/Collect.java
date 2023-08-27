package com.ljw.bean;

public class Collect {
    private Integer id;
    private Integer user_id;
    private Integer article_id;

    public Collect() {
    }

    public Collect(Integer id, Integer user_id, Integer article_id) {
        this.id = id;
        this.user_id = user_id;
        this.article_id = article_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", article_id=" + article_id +
                '}';
    }
}
