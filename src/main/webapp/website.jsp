<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medium Alike</title>
    <style>
        /* CSS styles for the Medium clone */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        .header {
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .header .logo {
            font-size: 24px;
            font-weight: bold;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .article {
            margin-bottom: 20px;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 5px;
            box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
        }

        .article h2 {
            margin-top: 0;
            margin-bottom: 10px;
            font-size: 20px;
        }

        .article p {
            margin-top: 0;
            margin-bottom: 10px;
            font-size: 16px;
            line-height: 1.5;
        }

        .footer {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 -2px 4px rgba(0, 0, 0, 0.1);
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
    <div class="header">
        <div class="logo">Medium Alike</div>
    </div>
    <!-- <div class="container">
        <h1>Welcome!</h1>
        <p>You have successfully logged in.</p>
    </div> -->
    	<div class="buttons">
            <button onclick="location.href='postarticle.jsp'">Post Article</button>
            <button onclick="location.href='notifications'">View Notifications</button>
            <!-- <a href="notifications.action?source=mysql">View Notifications (MySQL)</a>
			<a href="notifications.action?source=redis">View Notifications (Redis)</a> -->
        </div>
        
    <div class="container">
    <s:iterator value="articles" var="article">
    	<div class="article">
            <h2><s:property value="#article.title" /></h2>
            <p><strong>Author:</strong> <s:property value="#article.author" /></p>
            <p><strong>Category:</strong> <s:property value="#article.category" /></p>
            <p><s:property value="#article.content" /></p>
        </div>
    </s:iterator>
    </div>
    
        
    <div class="footer">
        &copy; 2024 Medium Alike
    </div>
</body>
</html>
