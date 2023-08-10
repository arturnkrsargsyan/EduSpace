package com.example.LearnOCity.models;

public enum Type {
    STUDENT(1),
    TEACHER(2);
    private final int value;

    Type(int value) {
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}
