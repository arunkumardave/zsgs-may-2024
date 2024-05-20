//$Id$
package com.example.actions;
import com.opensymphony.xwork2.ActionSupport;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class NotificationAction extends ActionSupport 
{
    
	private String mostRecentAuthor;
    private String mostRecentArticle;
    private String mostLikedArticle;
    private String mostCommentedArticle;
    private int totalArticlesCount;
    private Map<String, String> articlesCountByCategory;
    private Map<String, String> interestingStats;

    // Getters and Setters

    @Override
    public String execute() {
    	
    	String source = "mysql";
        
    	
    	if ("redis".equalsIgnoreCase(source)) 
        {
            return fetchFromRedis();
        } else {
            return fetchNotificationStats(); //Mysql
        }
    	
    	
    }

    private String fetchFromRedis() 
    {
        try (Jedis jedis = new Jedis("localhost", 6379)) 
        {
            mostRecentAuthor = jedis.get("mostRecentAuthor");
            mostRecentArticle = jedis.get("mostRecentArticle");
            mostLikedArticle = jedis.get("mostLikedArticle");
            mostCommentedArticle = jedis.get("mostCommentedArticle");
            
            //totalArticlesCount = jedis.get("totalArticlesCount") != null ? Integer.parseInt(jedis.get("totalArticlesCount")) : 0;
            //articlesCountByCategory = jedis.hgetAll("articlesCountByCategory");
            
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    private String fetchNotificationStats() 
    {
        
        String url = "jdbc:mysql://localhost:3306/zs_db1?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "MyNewPass";

        articlesCountByCategory = new HashMap<>();
        interestingStats = new HashMap<>();

        
        //Also push to redis
        Jedis jedis = new Jedis("localhost", 6379);
        		
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Most recent author
            String query = "SELECT author FROM Articles ORDER BY AddedDate DESC LIMIT 1";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    mostRecentAuthor = rs.getString("author");
                }
            }

            // Most recent article
            query = "SELECT title FROM Articles ORDER BY AddedDate DESC LIMIT 1";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    mostRecentArticle = rs.getString("title");
                }
            }

            // Most liked article
            query = "SELECT title FROM Articles ORDER BY likes DESC LIMIT 1";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    mostLikedArticle = rs.getString("title");
                }
            }

            // Most commented article
            query = "SELECT title FROM Articles ORDER BY LENGTH(comments) DESC LIMIT 1";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    mostCommentedArticle = rs.getString("title");
                }
            }

            // Total articles count
            query = "SELECT COUNT(*) FROM Articles";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    totalArticlesCount = rs.getInt(1);
                }
            }

            // Articles count by category
            query = "SELECT category, COUNT(*) FROM Articles GROUP BY category";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    articlesCountByCategory.put(rs.getString("category"), rs.getInt(2)+"");
                }
            }

            //Set in Redis as well

            jedis.set("mostRecentAuthor", mostRecentAuthor);
            jedis.set("mostRecentArticle", mostRecentArticle);
            jedis.set("mostLikedArticle", mostLikedArticle);
            jedis.set("mostCommentedArticle", mostCommentedArticle);
            jedis.set("totalArticlesCount", totalArticlesCount+"");
            
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
    
    
    

	public String getMostRecentAuthor() {
		return mostRecentAuthor;
	}

	public void setMostRecentAuthor(String mostRecentAuthor) {
		this.mostRecentAuthor = mostRecentAuthor;
	}

	public String getMostRecentArticle() {
		return mostRecentArticle;
	}

	public void setMostRecentArticle(String mostRecentArticle) {
		this.mostRecentArticle = mostRecentArticle;
	}

	public String getMostLikedArticle() {
		return mostLikedArticle;
	}

	public void setMostLikedArticle(String mostLikedArticle) {
		this.mostLikedArticle = mostLikedArticle;
	}

	public String getMostCommentedArticle() {
		return mostCommentedArticle;
	}

	public void setMostCommentedArticle(String mostCommentedArticle) {
		this.mostCommentedArticle = mostCommentedArticle;
	}

	public int getTotalArticlesCount() {
		return totalArticlesCount;
	}

	public void setTotalArticlesCount(int totalArticlesCount) {
		this.totalArticlesCount = totalArticlesCount;
	}

	public Map<String, String> getArticlesCountByCategory() {
		return articlesCountByCategory;
	}

	public void setArticlesCountByCategory(Map<String, String> articlesCountByCategory) {
		this.articlesCountByCategory = articlesCountByCategory;
	}

	public Map<String, String> getInterestingStats() {
		return interestingStats;
	}

	public void setInterestingStats(Map<String, String> interestingStats) {
		this.interestingStats = interestingStats;
	}

	
}
