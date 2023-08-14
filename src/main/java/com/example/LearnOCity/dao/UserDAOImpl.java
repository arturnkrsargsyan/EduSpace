package com.example.LearnOCity.dao;

import com.example.LearnOCity.models.User;
import com.example.LearnOCity.util.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private static final String INSERT_QUERY = "insert into user(username, age, password, type) VALUES (?,?,?,?) returning id";
    private static final String GET_BY_USERNAME_QUERY = "select * from user where username=?";
    private static final String GET_BY_ID_QUERY = "select * from user where id=?";
    Connection connection;


    public UserDAOImpl() {}

    @Override
    public int save(User user) {
        try (PreparedStatement statement = ConnectionUtil.getConnection().prepareStatement(INSERT_QUERY)) {

            this.enrichStatement(user, statement);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public User getById(int id) {
        User user = new User();
        ResultSet resultSet;
        try (PreparedStatement statement = ConnectionUtil.getConnection().prepareStatement(GET_BY_ID_QUERY)) {
            resultSet = statement.executeQuery();
            enrichUser(user, resultSet);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return user;
    }

    @Override
    public User getByUsername(String username) {
        User user = new User();
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_USERNAME_QUERY)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            user = new User();
            enrichUser(user, resultSet);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return user;
    }

    private void enrichUser(User user, ResultSet resultSet) {
        try {
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setAge(resultSet.getInt("age"));
            user.setPassword(resultSet.getString("password"));
            user.setType(resultSet.getInt("type"));
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
