package com.example.LearnOCity.util;

public class ErrorResponse {
private String massage;
private long timestamp;

    public ErrorResponse(String massage, long timestamp) {
        this.massage = massage;
        this.timestamp = timestamp;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
