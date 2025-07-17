<%@page import="in.pentagon.studentapp.dao.StudentDAOImpl"%>
<%@page import="in.pentagon.studentapp.dao.StudentDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<!-- ✅ Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Welcome Admin</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" 
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <a class="nav-link" href="dashboard.jsp">Back</a>
          </li>
        </ul>
      </div>
    </div>
   </nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<%String success=(String)request.getAttribute("success"); %>
	<%if(success!=null){ %>
	<h3 style="text-align: center;"><%= success %></h3>
	<%} %>
	<%String error=(String)request.getAttribute("error"); %>
	<%if(error!=null){ %>
	<h3 style="text-align: center;"><%= error %></h3>
	<%} %>
	<%StudentDao dao=new StudentDAOImpl(); %>
	<%ArrayList<Student> st=dao.getStudent();%>
	<div class="row">
      <div class="col-md-12">
        <h3 align="center">View Your Data</h3>
        <table class="table table-hover">
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Phone</th>
              <th>Mail ID</th>
              <th>Branch</th>
	      	  <th>Location</th>
	      	  <th>Remove</th>
            </tr>
          </thead>
          <tbody>
          <%if(st!=null && !st.isEmpty()){ %>
          <%for(Student s:st){ %>
          	<tr>
          		<td><%=s.getId() %></td>
          		<td><%=s.getName() %></td>
          		<td><%=s.getPhone() %></td>
          		<td><%=s.getMail() %></td>
          		<td><%=s.getBranch() %></td>
          		<td><%=s.getLocation() %></td>
          		<td>
          		<form action="delete" method="post">
          		<input type="hidden" name="id" value="<%=s.getId()%>">
          		<input type="submit" value="delete">
          		</form>
          		</td>
          	</tr>
          	<%}}else{ %>
          	<%="no users" %>
          	<%} %>
         </tbody>
        </table>  
      </div>
</body>
</html>