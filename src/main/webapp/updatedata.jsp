<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Account</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"> 
    <style>
        body {
            background-color: #add8e6;
            font-family: Arial, sans-serif;
        }

        .heading {     
            color: #000080;
        }

        .sub {
            color: #1e90ff;
        }

        .success {
            color: green;
        }

        .failure {
            color: red;
        }

        form {
            background-color: white;
            padding: 30px 50px;
            border-radius: 10px;
            box-shadow: 0 0 12px rgba(0,0,0,0.2);
            width: 500px;
            margin-top: 30px;
        }

        table {
            width: 100%;
        }

        td {
            padding: 10px;
        }

        input[type="text"],
        input[type="email"],
        input[type="tel"] {
            width: 100%;
            padding: 6px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
    </style>
</head>
<body>
    <div align="center">
        <h1 class="heading">Pentagon Space</h1>
        <h3 class="sub">Update your account</h3>

        <% Student st = (Student) session.getAttribute("student"); %>

        <form action="updateAccount" method="post">
            <table>
                <tr>
                    <td><b>Enter your Name:</b></td>
                    <td><input type="text" name="name" value="<%= st.getName() %>"></td>
                </tr>
                <tr>
                    <td><b>Enter the Phone number:</b></td>
                    <td><input type="tel" name="phone" value="<%= st.getPhone() %>"></td>
                </tr>
                <tr>
                    <td><b>Enter the Mail ID:</b></td>
                    <td><input type="email" name="mail" value="<%= st.getMail() %>"></td>
                </tr>
                <tr>
                    <td><b>Enter the Branch:</b></td>
                    <td><input type="text" name="branch" value="<%= st.getBranch() %>"></td>
                </tr>
                <tr>
                    <td><b>Enter the Location:</b></td>
                    <td><input type="text" name="loc" value="<%= st.getLocation() %>"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <input class="btn btn-success" type="submit" value="Update Account">
                        &nbsp;&nbsp;
                        <a class="btn btn-primary" href="dashboard.jsp">Back</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
