package com.example.LearnOCity.validations;

import com.example.LearnOCity.models.Statistic;

import java.util.ArrayList;
import java.util.List;

public class StatisticValidation implements Validator {
    @Override
    public List<String> validate(Object user) {
        List<String> validations = new ArrayList<>();
        Statistic statistic = (Statistic) user;
        if (statistic == null) {
            validations.add("Statistic should be");
        }
        return validations;
    }
}
