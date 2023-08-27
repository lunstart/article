package com.ljw.bean;

public class Follow {
    private Integer id;
    private Integer user_id;
    private Integer follow_user_id;

    public Follow() {
    }

    public Follow(Integer id, Integer user_id, Integer follow_user_id) {
        this.id = id;
        this.user_id = user_id;
        this.follow_user_id = follow_user_id;
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

    public Integer getFollow_user_id() {
        return follow_user_id;
    }

    public void setFollow_user_id(Integer follow_user_id) {
        this.follow_user_id = follow_user_id;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", userId=" + user_id +
                ", followUserId=" + follow_user_id +
                '}';
    }
}
