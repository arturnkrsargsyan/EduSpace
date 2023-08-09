package com.example.LearnOCity.models;

public class Test {
    private int id;
    private String description;
    private int user_id;
    private int category_id;
    public Test(int id, String description, int user_id, int category_id) {
        this.id = id;
        this.description = description;
        this.user_id = user_id;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
