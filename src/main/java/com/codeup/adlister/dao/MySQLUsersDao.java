package com.codeup.adlister.dao;

import com.codeup.adlister.Config.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;


    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return extractFromResult(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving the user.");
        }
    }

    private User extractFromResult(ResultSet rs) throws SQLException {
        User user = new User();
        if (rs.next()) {
            user.setId(rs.getLong(1));
            user.setUsername(rs.getString(2));
            user.setEmail(rs.getString(3));
            user.setPassword(rs.getString(4));
        }
        return user;
    }

    @Override
    public Long insert(User user) {
        try {
            String query = "INSERT INTO users(username, email, password) VALUES (?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException throwables) {
            throw new RuntimeException("Error");
        }
    }
}
