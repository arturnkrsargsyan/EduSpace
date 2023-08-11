package com.example.LearnOCity.models;

import java.security.Timestamp;
import java.util.List;

public class Statistic {
    private Integer id;
    private Integer userId;
    private Integer testId;
    private double averageMark;
    private Long date;
    private List<Test> testList;

    public Statistic(Integer userId, Integer testId, double averageMark, Long date, List<Test> testList) {
        this.userId = userId;
        this.testId = testId;
        this.averageMark = averageMark;
        this.date = date;
        this.testList = testList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }
}
