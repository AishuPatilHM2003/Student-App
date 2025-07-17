<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: white;
        }

        form {
            background-color: #fff;
            padding: 30px;
            width: 400px;
            
        }

        label {
            font-weight: bold;
            display: inline-block;
            width: 180px;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            padding: 8px;
            width: 200px;
            
        }

        input[type="submit"] {
            background-color: #28a745;
            color: white;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            font-weight: bold;
            cursor: pointer;
            margin-top: 10px;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }

        button {
            background-color: #007bff;
            border: none;
            padding: 8px 16px;
            border-radius: 4px;
            margin-top: 10px;
        }

        a {
            text-decoration: none;
            color: white;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        h1, h2 {
            color: #333;
        }

        h1, h2, form {
            text-align: center;
        }
    </style>
</head>
<body>
    <center>
        <h1><strong>Pentagon Space</strong></h1>
        <h2>Reset your password here</h2>
        
        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
        <h1><%= error %></h1>
        <% } %>

        <form action="forgotpassword" method="post">
            <label> Enter your Phone Number:</label>
            <input type="text" name="phone">
            <br><br>

            <label> Enter your Mail ID:</label>
            <input type="email" name="email">
            <br><br>

            <label> Enter your Password:</label>
            <input type="password" name="password">
            <br><br>

            <label> Confirm the password:</label>
            <input type="password" name="confirm">
            <br><br>

            <input type="submit" value="Reset Password">
            <br><br>

            <button><a href="login.jsp">Back</a></button>
        </form>
    </center>
</body>
</html>
