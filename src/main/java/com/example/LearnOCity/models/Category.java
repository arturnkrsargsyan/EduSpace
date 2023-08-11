package com.example.LearnOCity.models;

import java.util.List;

public class Category {
    private Integer id;
    private String name;
    private List<Test> tests;// TODO signUp form doesn't need it (for future case )

    public Category(){}


    public Category(Integer id, String name, List<Test> tests) {
        this.id = id;
        this.name = name;
        this.tests = tests;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
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
}
