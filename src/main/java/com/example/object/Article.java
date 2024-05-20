//$Id$
package com.example.object;

import java.util.Date;

public class Article {
    private int articleId;
    private String title;
    private String content;
    private String author;
    private int likes;
    private int comments;
    private String category;
    private Date addedDate;

    public Article(int articleId, String title, String content, String author, int likes, int comments, String category, Date addedDate) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.likes = likes;
        this.comments = comments;
        this.category = category;
        this.addedDate = addedDate;
    }

    // Getters and setters for all fields
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
}
