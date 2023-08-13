package com.example.LearnOCity.validations;

import com.example.LearnOCity.models.Test;

import java.util.ArrayList;
import java.util.List;

public class TestValidation {

    public TestValidation() {
    }

    public List<String> validate(Test test) {
        List<String> validations = new ArrayList<>();
        if (test.getDescription() == null) {
            validations.add("You must add a description of the test!");
        }
        if (test.getOwnerID() == null) {
            validations.add("User is required!");
        }
        if (test.getCategoryId() == null) {
            validations.add("Category is required!");
        }
        if (test.getQuestionList().isEmpty()) {
            validations.add("You must add at least one question here!");
        }
        return validations;
    }
}
