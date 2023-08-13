package com.example.LearnOCity.dto;

import java.util.Map;

public class QuestionDTO {
    private Integer id;
    private Integer testId;
    private String question;
    private Map<Integer, String> answers;//TODO LIST -> MAP
    private Integer rightAnswersNumber;//TODO in case if we get random questions this filed should null
    private double mark;

    private Long createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, String> answers) {
        this.answers = answers;
    }

    public int getRightAnswersNumber() {
        return rightAnswersNumber;
    }

    public void setRightAnswersNumber(int rightAnswersNumber) {
        this.rightAnswersNumber = rightAnswersNumber;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public QuestionDTO(Integer id, Integer testId, String question, Map<Integer, String> answers, int rightAnswersNumber, double mark, Long createdAt) {
        this.id = id;
        this.testId = testId;
        this.question = question;
        this.answers = answers;
        this.rightAnswersNumber = rightAnswersNumber;
        this.mark = mark;
        this.createdAt = createdAt;
    }
}
