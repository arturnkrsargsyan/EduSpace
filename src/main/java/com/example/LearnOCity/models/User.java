package com.example.LearnOCity.models;

import java.util.List;

public class User {
    private Integer id;
    private String username;
    private Integer age;
    private String password;
    private Integer type; //TODO Integer -> enumName
    private List<Category> categories;

    public User(){}


    public User(String username, Integer age, String password, Integer type, List<Category> categories) {
        this.username = username;
        this.age = age;
        this.password = password;
        this.type = type;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
