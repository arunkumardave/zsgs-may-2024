<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <title><tiles:getAsString name="title" /></title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .header {
            background-color: #f8f9fa;
            padding: 10px;
            text-align: center;
        }
        .container {
            display: flex;
            flex-direction: column;
            gap: 20px;
            padding: 20px;
        }
        .section {
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .action-button {
            background-color: green;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="header">
        <h2>Hello, User!</h2>
    </div>
    <div class="container">
        <div class="section post-article">
            <tiles:insertAttribute name="postArticle" />
        </div>
        <div class="section read-articles">
            <tiles:insertAttribute name="readArticles" />
        </div>
        <div class="section notifications">
            <tiles:insertAttribute name="notifications" />
        </div>
    </div>
</body>
</html>
