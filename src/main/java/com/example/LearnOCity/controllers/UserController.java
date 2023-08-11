package com.example.LearnOCity.controllers;

import com.example.LearnOCity.dto.ResultDTO;
import com.example.LearnOCity.dto.UserDTO;
import com.example.LearnOCity.models.User;
import com.example.LearnOCity.services.UserService;
import com.example.LearnOCity.validations.UserValidation;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final UserValidation userValidation;

    public UserController(UserService userService, ModelMapper modelMapper, UserValidation userValidation) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.userValidation = userValidation;
    }

    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestParam("username") String username,
                                            @RequestParam("password") String password) {
        return null;
    }

    @PostMapping("/registration")
    public ResultDTO signUp(@RequestBody UserDTO userDTO) {
        return userService.save(convertToUser(userDTO));
    }

    private User convertToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }


}
