<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Random" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color:white;
        }

        form {
            background-color: white;
            padding: 30px;
            width: 350px;
            
        }

        label {
            font-weight: bold;
        }

        input[type="email"],
        input[type="password"] {
            width: 220px;
            padding: 8px;
            margin: 6px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
            margin-top: 10px;
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

        h1, h3 {
            text-align: center;
        }

        h3 {
            color: green;
        }
    </style>
</head>
<body>
<center>
    <h1>Pentagon Space</h1>
    <h3>Login</h3>

    <% String success = (String) request.getAttribute("success"); %>
    <% if (success != null) { %>
    <h3><%= success %></h3>
    <% } %>
    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
    <h3><%= error %></h3>
    <% } %>

    <form action="login" method="post">
        <label>Enter your mail id: </label>
        <input type="email" name="email">
        <br><br>

        <label>Enter your password: </label>
        <input type="password" name="password">
        <br><br>

        <input type="submit" value="login">
        <br><br>

        <label>Forgot password?</label>
        <a href="forgotpassword.jsp">Reset</a>
        <br><br>

        <label>Don't have an account?</label>
        <a href="signup.jsp">Signup</a>
    </form>
    </center>
</body>
</html>
