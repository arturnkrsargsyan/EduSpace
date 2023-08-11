package com.example.LearnOCity.services;

import com.example.LearnOCity.dao.UserDAO;
import com.example.LearnOCity.dto.ResultDTO;
import com.example.LearnOCity.models.User;
import com.example.LearnOCity.validations.UserValidation;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserDAO userDAO;
    private final UserValidation userValidation;

    public UserServiceImpl(UserDAO userDAO, UserValidation userValidation) {
        this.userDAO = userDAO;
        this.userValidation = userValidation;
    }

    public ResultDTO save(User user) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setValidations(userValidation.validate(user));
        if (resultDTO.getValidations().isEmpty()) {
            resultDTO.setSuccess(true);
            user.setId(userDAO.save(user));
        }
        return resultDTO;
    }

    @Override
    public User getByUsername(String username) {
        return userDAO.getByUsername(username);
    }
}
