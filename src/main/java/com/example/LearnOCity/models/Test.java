package com.example.LearnOCity.models;

import java.util.List;

public class Test {
    private Integer id;
    private String name;
    private byte[] image;
    private String description;
    private Integer ownerID;
    private Integer categoryId;
    private List<Question> questionList;

    public Test(String name, byte[] image, String description, Integer ownerID, Integer categoryId, List<Question> questionList) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.ownerID = ownerID;
        this.categoryId = categoryId;
        this.questionList = questionList;
    }

    public Test() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Integer ownerID) {
        this.ownerID = ownerID;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}