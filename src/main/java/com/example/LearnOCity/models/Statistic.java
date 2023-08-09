package com.example.LearnOCity.models;

public class Statistic {
    private int id;
    private int user_id;
    private int test_id;
    private int awerage_mark;
    private int date;
    public Statistic(int id, int user_id, int test_id, int awerage_mark, int date) {
        this.id = id;
        this.user_id = user_id;
        this.test_id = test_id;
        this.awerage_mark = awerage_mark;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public int getAwerage_mark() {
        return awerage_mark;
    }

    public void setAwerage_mark(int awerage_mark) {
        this.awerage_mark = awerage_mark;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
