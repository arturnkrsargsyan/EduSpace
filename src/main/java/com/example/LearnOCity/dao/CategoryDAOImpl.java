package com.example.LearnOCity.dao;

import com.example.LearnOCity.models.Category;
import com.example.LearnOCity.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAOImpl implements CategoryDAO {
    private Connection connection;
    private final String INSERT_QUERY = "insert into category(name) values (?) returning id";
    private final String GET_BY_NAME_QUERY = "select * from category where name=?";

    public CategoryDAOImpl() {
        connection = ConnectionUtil.getConnection();
    }

    @Override
    public int create(Category category) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, category.getName());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Category getByCategoryName(String name) {
        Category category = new Category();
        try (PreparedStatement statement = connection.prepareStatement(GET_BY_NAME_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            enrichCategory(resultSet, category);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return category;
    }
    private void enrichCategory(ResultSet resultSet, Category category) {
        try {
            resultSet.next();
            category.setId(resultSet.getInt("id"));
            category.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
