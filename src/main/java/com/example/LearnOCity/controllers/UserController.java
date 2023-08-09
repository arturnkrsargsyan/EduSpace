package com.example.LearnOCity.controllers;

import com.example.LearnOCity.dto.UserDTO;
import com.example.LearnOCity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestParam("username") String username,
                                            @RequestParam("password") String password) {
        return null;
    }

    @PostMapping("/registration")
    public UserDTO signUp(@RequestBody UserDTO userDTO) {
        return null;
    }

}
