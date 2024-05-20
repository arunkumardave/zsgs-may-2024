//$Id$
package com.example.actions;

import java.util.List;

import com.example.object.Article;
import com.example.process.DatabaseManager;
import com.example.process.RedisManager;
import com.opensymphony.xwork2.ActionSupport;

public class WebsiteAction extends ActionSupport {

	public List<Article> articles;
	
	public String execute() 
    {
		System.out.println("Website - Success");
		
		articles = DatabaseManager.getArticles(500);
		setArticles(articles);
		
		System.out.println("articles.size() : "+articles.size());
		
		RedisManager.main(null);
        return SUCCESS;
    }

    public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Article> getArticles() {
        return articles;
    }
}
