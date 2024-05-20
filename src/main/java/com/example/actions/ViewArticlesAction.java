//$Id$
package com.example.actions;

import java.util.List;

import com.example.object.Article;
import com.example.process.DatabaseManager;
import com.opensymphony.xwork2.ActionSupport;

public class ViewArticlesAction extends ActionSupport{

	public String execute() 
    {
		System.out.println("Website - Success");
		
		List<Article> articles = DatabaseManager.getArticles(0);
		System.out.println("articles : "+articles);
		
        return SUCCESS;
    }
}
