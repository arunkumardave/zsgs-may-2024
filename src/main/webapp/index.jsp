<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ZS WebTech Session</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        .container {
            width: 800px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            font-size: 2em;
            margin-bottom: 20px;
        }

        p {
            font-size: 1em;
            line-height: 1.5;
            margin-bottom: 10px;
        }

        .button-container {
            margin-top: 20px;
            text-align: center;
        }

        .button-container form {
            display: inline-block;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4caf50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
            margin: 10px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the ZS WebTech Session</h1>
        <p>This is a sample project web site to explain certain concepts of Web technology and server development.</p>
        <p>Session 1 - Introduction to Web technology.</p>
        <p>Session 2 - A web app login page with Struts/Tiles and DB connection.</p>
        <p>Session 3 - Redis Cache - Data fetch from intermediate redis server.</p>
        <p>Session 4 - Load Balancer Technique - Incoming URL redirection.</p>
        <p>Session 5 - //TBD//</p>
        <div class="button-container">
            <form action="login.jsp">
                <input type="submit" value="Login">
            </form>
            <form action="signup.jsp">
                <input type="submit" value="Signup">
            </form>
        </div>
    </div>
</body>
</html>
