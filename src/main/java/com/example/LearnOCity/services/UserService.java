package com.example.LearnOCity.services;


import com.example.LearnOCity.dao.UserDAOImpl;
import com.example.LearnOCity.dto.ResultDTO;
import com.example.LearnOCity.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface UserService {

    ResultDTO save(User user);
    User getByUsername(String username);
}
