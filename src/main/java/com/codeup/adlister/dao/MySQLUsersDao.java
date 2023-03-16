package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users{

    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
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
        User user = null;

        // prepare a SQL statement to select the user with the given username
        String sql = "SELECT * FROM adlister_users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                // if the query returns a row, create a User object from the result set
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getLong("id"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    // set any other user properties here
                }
            }
        } catch (SQLException e) {
            // handle any database errors
            throw new RuntimeException("Error finding user.", e);
        }

        return user;
    }

    @Override
    public Long insert(User user) {
        try {
        String sql = "INSERT INTO adlister_users(id, username, email, password) VALUES (?, ?, ?, ?) ";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setLong(1, user.getId());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());


        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getLong(1);

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }


    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

    private List<User> createUsersFromResults(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(extractUser(rs));
        }
        return users;
    }
}
