package com.example.LearnOCity.dao;

import com.example.LearnOCity.models.User;

public interface UserDAO {
    User getByUsername(String username);

    int save(User user);

    User getById(int id);

//    boolean checkPassword(String username, String password);
}
