package com.example.LearnOCity.dto;

import java.util.List;

public class ResultDTO {
    private boolean success;
    private Integer newId;
    private List<String> validations;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public Integer getNewId() {
        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
    }

    public List<String> getValidations() {
        return validations;
    }

    public void setValidations(List<String> validations) {
        this.validations = validations;
    }
}
