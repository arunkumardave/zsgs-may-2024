<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notifications</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .stat {
            margin-bottom: 20px;
        }
        .recent-articles, .top-authors {
            margin-bottom: 20px;
        }
        .recent-articles ul, .top-authors ul {
            list-style-type: none;
            padding: 0;
        }
        .recent-articles li, .top-authors li {
            background-color: #f9f9f9;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
            box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
        }
        
        .buttons {
        	padding : 50px;
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }
        .buttons button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: #4caf50;
            color: white;
            border: none;
            border-radius: 5px;
        }
        .buttons button:hover {
            background-color: #4caf50;
        }
    </style>
</head>
<body>
		<div class="buttons">
            <button onclick="location.href='welcome'">View all Article</button>
            <button onclick="location.href='postarticle.jsp'">Post new article</button>
        </div>
    <div class="container">
        <h1>Notifications</h1>

        <div class="stat">
            <p><strong>Most Recent Author:</strong> <s:property value="mostRecentAuthor" /></p>
        </div>
        <div class="stat">
            <p><strong>Most Recent Article:</strong> <s:property value="mostRecentArticle" /></p>
        </div>
        <div class="stat">
            <p><strong>Most Liked Article:</strong> <s:property value="mostLikedArticle" /></p>
        </div>
        <div class="stat">
            <p><strong>Most Commented Article:</strong> <s:property value="mostCommentedArticle" /></p>
        </div>
        <div class="stat">
            <p><strong>Total Articles Count:</strong> <s:property value="totalArticlesCount" /></p>
        </div>
        <div class="stat">
            <p><strong>Articles Count by Category:</strong></p>
            <ul>
                <s:iterator value="articlesCountByCategory.entrySet()" var="entry">
                    <li><s:property value="#entry.key" />: <s:property value="#entry.value" /></li>
                </s:iterator>
            </ul>
        </div>
        <div class="stat">
            <p><strong>Interesting Stats:</strong></p>
            <ul>
                <s:iterator value="interestingStats.entrySet()" var="entry">
                    <li><s:property value="#entry.key" />: <s:property value="#entry.value" /></li>
                </s:iterator>
            </ul>
        </div>

    </div>
</body>
</html>

