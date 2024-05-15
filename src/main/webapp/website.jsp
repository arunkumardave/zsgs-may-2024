<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
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

        .container0 {
            text-align: center;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
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
    </style>
</head>
<body>
    <div class="header">
        <div class="logo">Medium Alike</div>
    </div>
    <div class="container0">
        <h1>Welcome!</h1>
        <p>You have successfully logged in.</p>
    </div>
    
    <%-- <tiles:insertDefinition name="articles" /> --%>
    
    <div class="container">
        <div class="article">
            <h2>Sample Article 11</h2>
            <p>Blah.,.,blah..blah..blah,...blahlll.</p>
        </div>
        <div class="article">
            <h2>Sample Article 12</h2>
            <p>Blah.,.,blah..blah..blah,...blahlll.</p>
        </div>
        <div class="article">
            <h2>Sample Article 13</h2>
            <p>Blah.,.,blah..blah..blah,...blahlll.</p>
        </div>
        <div class="article">
            <h2>Another Article Title</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce tempor velit non ligula tristique..</p>
        </div>
   </div>
   
   <div class="footer">
        <div class="">Some footer</div>
    </div>
</body>
</html>

            
            
            
            
             
