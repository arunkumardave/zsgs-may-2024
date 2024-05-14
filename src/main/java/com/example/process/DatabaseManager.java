package com.example.process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/zs_db?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    /*
     * CREATE DATABASE zs_db;
     * 
     * CREATE TABLE UserDetails (
	    Name VARCHAR(100),
	    DOB DATE,
	    Username VARCHAR(50) PRIMARY KEY,
	    Password VARCHAR(50),
	    Email VARCHAR(100) UNIQUE
		);
     */
    
    public static boolean validateUser(String username, String password) {
        String sql = "SELECT * FROM UserDetails WHERE Username = ? AND Password = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Returns true if user exists, false otherwise
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of any exception
        }
    }
    
    
    public static boolean addUser(String name, String dob, String username, String password, String email) {
    	
    	if (userExists(username, email)) {
            return false; // User with the provided username or email already exists
        }
    	
        String sql = "INSERT INTO UserDetails (Name, DOB, Username, Password, Email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, dob);
            stmt.setString(3, username);
            stmt.setString(4, password);
            stmt.setString(5, email);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Return true if insertion successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of any exception
        }
    }
    
    private static boolean userExists(String username, String email) {
        String sql = "SELECT COUNT(*) FROM UserDetails WHERE Username = ? OR Email = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Return true if user with username or email already exists
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false by default
    }
    
    //sample test changes
}


