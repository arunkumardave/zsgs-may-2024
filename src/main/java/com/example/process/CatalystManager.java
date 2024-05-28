//$Id$
package com.example.process;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.advanced.CatalystAdvancedIOHandler;
import com.zc.common.ZCProject;
import com.zc.component.object.ZCObject;
import com.zc.component.object.ZCRowObject;
import com.zc.component.zcql.ZCQL;


import com.example.object.Article;

public class CatalystManager 
{
    
    
    public static boolean validateUser(String username, String password){
        String sql = "SELECT * FROM UserDetails WHERE Username = "+username+" AND Password = "+password;
        
        try 
        {
        	ZCProject.initProject();
        	ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(sql);
            
            if(rowList.size()>1)
            {
              return true;  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public static boolean addUser(String name, String dob, String username, String password, String email){
    	
    	ZCProject.initProject();
    	if (userExists(username, email)) 
    	{
    		System.out.println("User exists with this email/username");
            return false; // User with the provided username or email already exists
        }
    	
        try {
            
            ZCRowObject row = ZCRowObject.getInstance();
			row.set("Name", name);
			row.set("DOB", dob);
			row.set("Username", username);
			row.set("Password", password);
			row.set("Email", email);
			
			ZCObject.getInstance().getTableInstance("UserDetails").insertRow(row);
			return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false in case of any exception
        }
    }
    
    private static boolean userExists(String username, String email){
        String sql = "SELECT COUNT(*) FROM UserDetails WHERE Username = "+username+" OR Email = "+email;
        try{
        	ZCProject.initProject();
        	ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(sql);
            
            if(rowList.size()>1)
            {
              return true;  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Return false by default
    }
    
    public static List<Article> getArticles(int limit){
        List<Article> articles = new ArrayList<Article>();
        
        String query = "SELECT * FROM Articles order by AddedDate desc ";
        if(limit>0) {
        	query += " limit "+limit;
        }
        
        try{
        	ZCProject.initProject();
        	ArrayList<ZCRowObject> rowList = ZCQL.getInstance().executeQuery(query);
            for(int i=0; i<rowList.size(); i++) 
            {
            	ZCRowObject row = rowList.get(i);
            	Article article = new Article(
            			Integer.parseInt(row.get("id").toString()),
            			row.get("title").toString(),
            			row.get("content").toString(),
            			row.get("author").toString(),
            			Integer.parseInt(row.get("likes").toString()),
            			Integer.parseInt(row.get("comments").toString()),
                        row.get("category").toString(),
                        null
                    );
                    articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }
    
    public static boolean postArticle(String title, String author, String category, String content) 
    {	
     	try{
        	
     		ZCProject.initProject();
        	ZCRowObject row = ZCRowObject.getInstance();
 			row.set("title", title);
 			row.set("content", content);
 			row.set("author", author);
 			row.set("category", category);
 			
 			ZCObject.getInstance().getTableInstance("UserDetails").insertRow(row);

        	return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false in case of any exception
        }
    }
    
    public static boolean updateArticle(Long articleID, String title, String author, String category, String content) 
    {	
    	String query = "UPDATE Articles SET title=?, content=?, author=?, category=? WHERE articleid=?";
        try{
        	try {
        		ZCProject.initProject();
        		
        		
            } catch (Exception e) {
                e.printStackTrace();
            }
        	return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false in case of any exception
        }
    }
    
    
    public static boolean removeArticle(Long articleId) {
        String query = "DELETE FROM Articles WHERE articleid=?";
        try{
           	try {
           		ZCProject.initProject();
           		
           		
               } catch (Exception e) {
                   e.printStackTrace();
               }
           		return true;
           } catch (Exception e) {
               e.printStackTrace();
               return false; // Return false in case of any exception
           }
    }

    
    
    
}


