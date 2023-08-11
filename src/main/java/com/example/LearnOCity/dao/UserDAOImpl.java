package com.example.LearnOCity.dao;

import com.example.LearnOCity.models.User;
import com.example.LearnOCity.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final String INSERT_QUERY = "insert into user(username, age, password, type) VALUES (?,?,?,?) returning id";
    private static final String GET_BY_USERNAME_QUERY = "select * from user where username=?";
    private Connection connection;

    public UserDAOImpl() {
        this.connection = ConnectionUtil.getConnection();
    }

    @Override
    public int save(User user) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {

            this.enrichStatement(user, statement);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public User getByUsername(String username) {
        User user = new User();
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_USERNAME_QUERY)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            enrichUser(user, resultSet);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return user;
    }

    private void enrichUser(User user, ResultSet resultSet) {
        try {
            resultSet.next();
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setAge(resultSet.getInt(3));
            user.setPassword(resultSet.getString(4));
            user.setType(resultSet.getInt(5));
            user.setCategory(resultSet.getInt(6));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void enrichStatement(User user, PreparedStatement statement) {
        try {
            statement.setString(1, user.getUsername());
            statement.setInt(2, user.getAge());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getType());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
