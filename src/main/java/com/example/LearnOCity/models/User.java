package com.example.LearnOCity.models;

public class User {
    private int id;
    private String username;
    private int age;
    private String password;
    private int type;
    private int category;
    public User(){}

    public User(String username, int age, String password, int type,int category) {
        this.username = username;
        this.age = age;
        this.password = password;
        this.type = type;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
