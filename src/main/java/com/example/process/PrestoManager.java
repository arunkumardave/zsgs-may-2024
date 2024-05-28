//$Id$
package com.example.process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.object.Article;

public class PrestoManager 
{
    //private static final String URL = "jdbc:mysql://localhost:3306/zs_db1?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
	private static final String URL = "jdbc:presto://localhost:3306/mysql/zs_db1?user=root&password=MyNewPass&SSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "MyNewPass";

    /*
     * CREATE DATABASE zs_db;
     * 
     * CREATE TABLE UserDetails ( Name VARCHAR(100), DOB DATE, Username VARCHAR(50) PRIMARY KEY, Password VARCHAR(50), Email VARCHAR(100) UNIQUE );
     * 
     * CREATE TABLE Articles ( Articleid INT AUTO_INCREMENT PRIMARY KEY, Title VARCHAR(255) NOT NULL, Content TEXT, Category VARCHAR(50), Author VARCHAR(100), Addeddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, Likes INT DEFAULT 0, Comments INT DEFAULT 0);
     * 
     */
    
    public static Connection getConnection() throws SQLException
    {
    	return DriverManager.getConnection(URL);
    }
    
    public static boolean validateUser(String username, String password) {
        String sql = "SELECT * FROM UserDetails WHERE Username = ? AND Password = ?";
        try (Connection conn = DriverManager.getConnection(URL);
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
    	
    	if (userExists(username, email)) 
    	{
    		System.out.println("User exists with this email/username");
            return false; // User with the provided username or email already exists
        }
    	
        String sql = "INSERT INTO UserDetails (Name, DOB, Username, Password, Email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
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
        try (Connection conn = DriverManager.getConnection(URL);
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
    
    public static List<Article> getArticles(int limit) {
        List<Article> articles = new ArrayList<Article>();
        
        String query = "SELECT * FROM Articles order by AddedDate desc ";
        if(limit>0) {
        	query += " limit "+limit;
        }
        
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {
           	ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Article article = new Article(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getString("author"),
                    resultSet.getInt("likes"),
                    resultSet.getInt("comments"),
                    resultSet.getString("category"),
                    resultSet.getTimestamp("addeddate")
                );
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
    
    public static boolean postArticle(String title, String author, String category, String content) 
    {	
     	String query = "INSERT INTO Articles (title, content, author, category) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {
        	try {
        		stmt.setString(1, title);
        		stmt.setString(2, content);
        		stmt.setString(3, author);
        		stmt.setString(4, category);
        		stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        	return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of any exception
        }
    }
    
    public static boolean updateArticle(Long articleID, String title, String author, String category, String content) 
    {	
    	String query = "UPDATE Articles SET title=?, content=?, author=?, category=? WHERE articleid=?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {
        	try {
        		stmt.setString(1, title);
                stmt.setString(2, content);
                stmt.setString(3, author);
                stmt.setString(4, category);
                stmt.setLong(5, articleID);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        	return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of any exception
        }
    }
    
    
    public static boolean removeArticle(Long articleId) {
        String query = "DELETE FROM Articles WHERE articleid=?";
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement stmt = conn.prepareStatement(query)) {
           	try {
           		stmt.setLong(1, articleId);
           		stmt.executeUpdate();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           		return true;
           } catch (SQLException e) {
               e.printStackTrace();
               return false; // Return false in case of any exception
           }
    }
    
    
    public static List<Article> getRecentArticles(int limit) {
        List<Article> articles = new ArrayList<Article>();
        
        String query = "SELECT * FROM Articles order by AddedDate desc ";
        if(limit>0) {
        	query += " limit "+limit;
        }
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {
           	ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Article article = new Article(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getString("author"),
                    resultSet.getInt("likes"),
                    resultSet.getInt("comments"),
                    resultSet.getString("category"),
                    resultSet.getTimestamp("addeddate")
                );
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
    
    public static List<Article> getMostLikedArticle() {
        List<Article> articles = new ArrayList<Article>();
        
        String query = "SELECT * FROM Articles order by Likes desc limit 1 ";
        
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {
           	ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Article article = new Article(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getString("author"),
                    resultSet.getInt("likes"),
                    resultSet.getInt("comments"),
                    resultSet.getString("category"),
                    resultSet.getTimestamp("addeddate")
                );
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
    
    public static List<Article> getMostCommentedArticle() {
        List<Article> articles = new ArrayList<Article>();
        
        String query = "SELECT * FROM Articles order by Comments desc limit 1 ";
        
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {
           	ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Article article = new Article(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getString("author"),
                    resultSet.getInt("likes"),
                    resultSet.getInt("comments"),
                    resultSet.getString("category"),
                    resultSet.getTimestamp("addeddate")
                );
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }
    
    public static int getArticlesCount() {
        int count = 0;
        String query = "SELECT count(*) FROM Articles";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {
           	ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
            	count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public static int getArticlesCountByCategory() {
        int count = 0;
        String query = "SELECT Category, count(*) FROM Articles group by 1";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {
           	ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
            	count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    
    
}


