package com.example.LearnOCity.dao;

import com.example.LearnOCity.models.User;

import java.util.List;

public interface UserDAO {
    User getByUsername(String username);

    int save(User user);

    User getById(int id);
}
