package com.example.LearnOCity.models;

import java.util.List;

public class Test {
    private Integer id;
    private byte[] image;
    private String description;
    private Integer userId;
    private Integer categoryId;
    private List<Question> questionList;


    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Test(byte[] image, String description, Integer userId, Integer categoryId, List<Question> questionList) {
        this.image = image;
        this.description = description;
        this.userId = userId;
        this.categoryId = categoryId;
        this.questionList = questionList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}