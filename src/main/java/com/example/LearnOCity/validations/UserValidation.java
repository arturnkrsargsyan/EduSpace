package com.example.LearnOCity.validations;

import com.example.LearnOCity.models.User;
import com.example.LearnOCity.services.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserValidation implements Validator {
    private final UserService userService;

    public UserValidation(UserService userService) {
        this.userService = userService;
    }


    @Override
    public List<String> validate(Object object) {
        User user = (User) object;
        List<String> validations = new ArrayList<>();
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            validations.add("Username is required!");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            validations.add("Password is required!");
        }
        if (userService.getByUsername(user.getUsername()) != null) {
            validations.add("Username already exist!");
        }
        return validations;
    }

    public List<String> validateLogin(User user, String password) {
        List<String> validations = new ArrayList<>();

        if (user.getUsername() == null && user.getUsername().isEmpty()) {
            validations.add("Username does not exist");
        }
        if ((user.getPassword() == null && user.getPassword().isEmpty())) {
            validations.add("Password does not exist");
        }
        return validations;
    }
}