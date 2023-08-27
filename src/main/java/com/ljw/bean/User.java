package com.ljw.bean;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer right;
    private String time;

    public User() {

    }

    public User(Integer id, String username, String password, String email, Integer right, String time) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.right = right;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", right=" + right +
                ", time='" + time + '\'' +
                '}';
    }
}
