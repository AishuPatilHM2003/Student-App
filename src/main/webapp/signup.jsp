<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Application Form</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        form {
            background-color: #fff;
            padding: 25px;
            width: 400px;
            margin-top: 20px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="tel"],
        input[type="email"],
        input[type="password"] {
            padding: 6px;
            width: 250px;
            margin: 5px 0;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            padding: 8px 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        a {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <center>
        <h1><strong>Pentagon Space</strong></h1>
        <h2>Application form</h2>
        
        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
        <h1><%= error %></h1>
        <% } %>

        <form action="signup" method="post">
            <label> Enter your Name:</label>
            <input type="text" name="name">
            <br><br>
            <label> Enter your Phone Number:</label>
            <input type="tel" name="phone">
            <br><br>
            <label> Enter your Mail ID:</label>
            <input type="email" name="mail">
            <br><br>
            <label> Enter your Branch:</label>
            <input type="text" name="branch">
            <br><br>
            <label> Enter your Location:</label>
            <input type="text" name="location">
            <br><br>
            <label> Enter your Password:</label>
            <input type="password" name="password">
            <br><br>
            <label> Confirm the password:</label>
            <input type="password" name="confirm">
            <br><br>

            <input type="submit" value="Create account">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <label>already have an account?</label>
            <a href="login.jsp">login</a>
        </form>
    </center>
</body>
</html>
