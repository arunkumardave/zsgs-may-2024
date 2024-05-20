<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Post Article</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 10px;
            font-weight: bold;
        }
        input, select, textarea {
            margin-bottom: 20px;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
        }
        button:hover {
            background-color: #0056b3;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
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
            <button onclick="location.href='notifications.jsp'">View Notifications</button>
        </div>
    <div class="container">
        <h2>Post a New Article</h2>
        <div class="left-section">
        <form action="postarticle" method="post">
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
                <option value="Entertainment">Entertainment</option>
		        <option value="Engineering">Engineering</option>
		        <option value="Life Style">Life Style</option>
		        <option value="Marketing">Marketing</option>
                <!-- Add more options as needed -->
            </select><br>
            
            <input type="submit" value="Submit">
        </form>
    </div>
    </div>
</body>
</html>
