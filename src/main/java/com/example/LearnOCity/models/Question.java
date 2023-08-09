package com.example.LearnOCity.models;

public class Question {
    private int id;
    private int test_id;
    private String question;
    private int[] answers;
    private int right_answer_number;
    private int mark;
    private int created_at;
    public Question(int id, int test_id, String question, int[] answers, int right_answer_number, int mark, int created_at) {
        this.id = id;
        this.test_id = test_id;
        this.question = question;
        this.answers = answers;
        this.right_answer_number = right_answer_number;
        this.mark = mark;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int[] getAnswers() {
        return answers;
    }

    public void setAnswers(int[] answers) {
        this.answers = answers;
    }

    public int getRight_answer_number() {
        return right_answer_number;
    }

    public void setRight_answer_number(int right_answer_number) {
        this.right_answer_number = right_answer_number;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }
}
