package com.example.LearnOCity.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/final_project_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection connection;

    private ConnectionUtil() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
