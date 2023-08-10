package com.example.LearnOCity.dao;

import com.example.LearnOCity.models.User;
import com.example.LearnOCity.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private static final String INSERT_QUERY = "insert into user(username, age, password, type) VALUES (?,?,?,?)";
    private Connection connection;

    public UserDAOImpl() {
        this.connection = ConnectionUtil.getConnection();
    }

    @Override
    public void save(User user){
        try(PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {

        }catch (SQLException e){

        }
    }
    private void enrichStatement(User user, PreparedStatement statement){
        try {
            statement.setString(1,user.getUsername());
            statement.setString(2, user.getDescription());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
