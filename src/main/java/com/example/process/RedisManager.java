//$Id$
package com.example.process;

import com.example.object.Article;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
public class RedisManager 
{

    public static void main(String[] args) 
    {
        // Connect to Redis server
        
        JedisPool pool = new JedisPool("localhost", 6379);
        
        try (Jedis jedis1 = pool.getResource()) {
        	  jedis1.set("clientName", "Jedis");
        	}
        
        Jedis jedis = new Jedis("localhost", 6379); // default host and port
        System.out.println ("Server is running:" + jedis.ping ());
        
        
        // Set a key-value pair
        jedis.set("Sample-Key", "Sample-Key");
        
        // Get the value for a key
        String value = jedis.get("Sample-Key");
        System.out.println("Value for 'Sample-Key': " + value);
        
        // Increment a counter
        jedis.incr("counter");
        System.out.println("Incremental-Counter value: " + jedis.get("counter"));
        
        // Close the connection
        jedis.close();
    }
    
    public static void publishChange(String title, String author, String category)
    {
    	Jedis jedis = new Jedis("localhost", 6379); // default host and port
        	jedis.set("mostRecentAuthor", author);
        	jedis.set("mostRecentArticle", title);
        	
        	jedis.incr("totalArticles");
        	
        	if(category.equals("Technology")) {
        		jedis.incr("Technology-articles");
        	}else if(category.equals("Sports")) {
        		jedis.incr("Sports-articles");
        	}else if(category.equals("Politics")) {
        		jedis.incr("Politics-articles");
        	}else if(category.equals("Entertainment")) {
        		jedis.incr("Entertainment-articles");
        	}else if(category.equals("Engineering")) {
        		jedis.incr("Engineering-articles");
        	}else if(category.equals("Marketing")) {
        		jedis.incr("Marketing-articles");
        	}
        	
        	//Write logic and add stats here
        	jedis.set("mostLikedArticle", "0");
        	jedis.set("mostCommentedArticle", "0");
        	jedis.set("articlesCountByCategory", "0");
        	
        jedis.close();
    }
    
    public static void updateArticleCount()
    {
    	Jedis jedis = new Jedis("localhost", 6379); // default host and port
    	int articles = Integer.parseInt(jedis.get("articles"));
    	
    	if(true) {
    		jedis.set("articles", "1");
    		return;
    	}
    	jedis.incr("articles");
    }
    
    
    public static void addRecentArticle()
    {
    	
    }
}
