package com.example.LearnOCity.services;

import com.example.LearnOCity.dao.UserDAO;
import com.example.LearnOCity.dto.ResultDTO;
import com.example.LearnOCity.models.User;
import com.example.LearnOCity.validations.UserValidation;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Collections;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {


    private final UserDAO userDAO;
    private final UserValidation userValidation;

    public UserServiceImpl(UserDAO userDAO, UserValidation userValidation) {
        this.userDAO = userDAO;
        this.userValidation = userValidation;
    }

    public ResultDTO registration(User user) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setValidations(userValidation.validate(user));
        if (resultDTO.getValidations().isEmpty()) {
            user.setId(userDAO.save(user));
            resultDTO.setSuccess(true);
        }
        return resultDTO;
    }

    @Override
    public User getByUsername(String username) {
        return userDAO.getByUsername(username);
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public ResultDTO login(String username, String password) {
        ResultDTO resultDTO = new ResultDTO();
        User user = getByUsername(username);
        if (!(Objects.equals(user.getPassword(), password))) {
            resultDTO.setSuccess(false);
            return resultDTO;
        }
        resultDTO.setValidations(userValidation.validateLogin(user, password));
        if (resultDTO.getValidations().isEmpty()) {
            resultDTO.setSuccess(true);
            resultDTO.setNewId(user.getId());
        }
        return resultDTO;
    }

}
