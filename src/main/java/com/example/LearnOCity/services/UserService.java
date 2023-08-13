package com.example.LearnOCity.services;


import com.example.LearnOCity.dto.ResultDTO;
import com.example.LearnOCity.models.User;

public interface UserService {

    ResultDTO registration(User user);
    User getByUsername(String username);
    User getById(int id);
}
