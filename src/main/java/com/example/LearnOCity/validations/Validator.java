package com.example.LearnOCity.validations;

import com.example.LearnOCity.models.User;

import java.util.List;

public interface Validator {


    List<String> validate(Object user);
}
