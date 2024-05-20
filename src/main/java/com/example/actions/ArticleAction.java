package com.example.actions;

import com.example.object.Article;
import com.example.process.DatabaseManager;
import com.example.process.RedisManager;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class ArticleAction extends ActionSupport {
    private String title;
	private String content;
    private String author;
    private String category;
    private Long id;

    // Getters and Setters

    public String postArticle() {
        if (DatabaseManager.postArticle(title, author, category, content)) {
            //RedisManager.publishChange("New article posted: " + title);
            return SUCCESS;
        }
        return ERROR;
    }

    public String updateArticle() {
        if (DatabaseManager.updateArticle(id, title, author, category, content)) {
            //RedisManager.publishChange("Article updated: " + title);
            return SUCCESS;
        }
        return ERROR;
    }

    public String removeArticle() {
        if (DatabaseManager.removeArticle(id)) {
            //RedisManager.publishChange("Article removed: " + id);
            return SUCCESS;
        }
        return ERROR;
    }

    public String readArticles() {
        List<Article> articles = DatabaseManager.getArticles(500);
        // Set articles as a JSON response
        return SUCCESS;
    }
    
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
