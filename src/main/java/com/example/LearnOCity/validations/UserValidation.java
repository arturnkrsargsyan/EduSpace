package com.example.LearnOCity.validations;

import com.example.LearnOCity.models.User;
import com.example.LearnOCity.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserValidation {
    private final UserService userService;

    public UserValidation(UserService userService) {
        this.userService = userService;
    }

    public List<String> validate(User user) {
        List<String> validations = new ArrayList<>();
        if (user.getUsername()==null||user.getUsername().isEmpty()) {
            validations.add("Username is required!");
        }
        if (user.getPassword()==null||user.getPassword().isEmpty()) {
            validations.add("Password is required!");
        }
        if (userService.getByUsername(user.getUsername()) != null) {
            validations.add("Username already exist!");
        }
        return validations;
    }
}
