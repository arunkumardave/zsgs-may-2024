<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Article Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: row;
            height: 100vh;
            background-color: #f4f4f4;
        }

        .left-section, .middle-section, .right-section {
            flex: 1;
            padding: 20px;
            margin: 10px;
        }

        .left-section {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 40px;
        }

        .middle-section {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            overflow-y: auto;
        }

        .right-section {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        h1 {
            font-size: 24px;
            color: #333;
        }

        label {
            font-size: 16px;
            color: #555;
        }

        input[type="text"], input[type="submit"], select, textarea {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .article-item {
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 10px;
        }

        .article-item h2 {
            color: #333;
            font-size: 20px;
            margin-bottom: 5px;
        }

        .article-item p {
            color: #666;
            font-size: 16px;
            margin: 5px 0;
        }

        .notification-item {
            background-color: #ffe4b5;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 10px;
            font-size: 14px;
            color: #333;
        }
    </style>
</head>
<body>
<div class="header">
        <div class="logo">ZS WebTech - Medium Redsign</div>
        <div class="welcome-message">Welcome, User!</div>
    </div>
    <div class="left-section">
        <h1>Create New Article</h1>
        <form action="ArticlesAction" method="post">
            <label for="title">Title:</label><br>
            <input type="text" id="title" name="title" required><br>
            
            <label for="content">Content:</label><br>
            <textarea id="content" name="content" required></textarea><br>
            
            <label for="author">Author:</label><br>
            <input type="text" id="author" name="author" required><br>
            
            <label for="category">Category:</label><br>
            <select id="category" name="category" required>
                <option value="Technology">Technology</option>
                <option value="Sports">Sports</option>
                <option value="Politics">Politics</option>
                <!-- Add more options as needed -->
            </select><br>
            
            <input type="submit" value="postArticle">
        </form>
    </div>

    <div class="middle-section">
        <h1>Existing Articles</h1>
        <div id="articlesContainer">
            <!-- Existing articles will be displayed here -->
            <table border="1">
		        <thead>
		            <tr>
		                <th>Title</th>
		                <th>Content</th>
		                <th>Author</th>
		                <th>Category</th>
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach var="article" items="${articles}">
		                <tr>
		                    <td><s:property value="#article.title" /></td>
		                    <td><s:property value="#article.content" /></td>
		                    <td><s:property value="#article.author" /></td>
		                    <td><s:property value="#article.category" /></td>
		                </tr>
		            </c:forEach>
		        </tbody>
		    </table>
        </div>
        
    </div>

    <div class="right-section">
        <h1>Notifications</h1>
        <div id="notificationsContainer">
            <!-- Notifications will be displayed here -->
        </div>
    </div>

    <script>
        // JavaScript to load existing articles and notifications

        function loadArticles() {
            fetch('GetArticlesServlet')
                .then(response => response.json())
                .then(data => {
                    var articlesContainer = document.getElementById('articlesContainer');
                    articlesContainer.innerHTML = ''; // Clear existing articles

                    data.forEach(article => {
                        var articleItem = document.createElement('div');
                        articleItem.classList.add('article-item');
                        articleItem.innerHTML = `
                            <h2>${article.title}</h2>
                            <p>${article.content}</p>
                            <p><strong>Author:</strong> ${article.author}</p>
                            <p><strong>Category:</strong> ${article.category}</p>
                        `;
                        articlesContainer.appendChild(articleItem);
                    });
                })
                .catch(error => console.error('Error:', error));
        }

        function loadNotifications() {
            // Fetch and display notifications here
        }

        // Load articles and notifications when the page loads
        loadArticles();
        loadNotifications();
    </script>
</body>
</html>
