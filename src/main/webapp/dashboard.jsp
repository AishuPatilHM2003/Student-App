<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Student Management</title>
  <link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body>

<%Student s=(Student)session.getAttribute("student"); %>
<%if(s!=null){ %>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand navbar-primary" href="#">Welcome <%=s.getName() %></a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
        
        <%if(s.getId()==2){ %>
         <li class="nav-item">
            <a class="nav-link" href="ViewUser.jsp">View Users</a>
          </li>
          <%} %>
          <li class="nav-item">
            <a class="nav-link" href="resetpassword.jsp">Reset Password</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="updatedata.jsp">Update Data</a>
          </li>
          <li class="nav-item">
          <form action="logout" method="post">
           <input class="btn btn-danger" type="submit" name="logout" value="Logout">
            </form>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container mt-4">
    <h1 class="text-center mb-4">Dashboard</h1>
</div>

<%String success=(String)request.getAttribute("success"); %>
<%if(success!=null){ %>
<h2 style="text-allign:center;"><%=success %></h2>
<%} %>

<!-- User Section -->
    <div class="row">
      <div class="col-md-12">
        <h3>View Your Data</h3>
        <table class="table table-hover">
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Phone</th>
              <th>Mail ID</th>
              <th>Branch</th>
	      	  <th>Location</th>
            </tr>          
          </thead>
          <tbody>
          <tr>
          <td><%=s.getId()%></td>
          <td><%=s.getName()%></td>
          <td><%=s.getPhone()%></td>
          <td><%=s.getMail()%></td>
          <td><%=s.getBranch()%></td>
          <td><%=s.getLocation()%></td>
          </tr>
         </tbody>
        </table>
        <%} %>
      </div>
    <div>
    <form action="searchUser" method="post">
    <h3>Search User</h3><br>
    <label>Enter the user name to search</label>
    <input type="text" name="user">
    <input type="submit" value="search">
    <% ArrayList<Student> users=(ArrayList<Student>)request.getAttribute("users"); %>
    <table class="table table-hover">
          <thead>
            <tr>
              <th>Id</th>            
              <th>Name</th>
              <th>Phone</th>
              <th>Mail Id</th>
              <th>Branch</th>
	      	  <th>Location</th>
            </tr>         
          </thead>
          <tbody>
          <%if(users!=null && !users.isEmpty()){ %>
          <%for(Student st:users){ %>
          <tr>
          <td><%=st.getId()%></td>
          <td><%=st.getName()%></td>
          <td><%=st.getPhone() %></td>
          <td><%=st.getMail() %></td>
          <td><%=st.getBranch()%></td>
          <td><%=st.getLocation()%></td>
          </tr>
           <%} %>
         </tbody>
        </table>
      <%} else{ %>
        <%="No such user" %>
        <%} %>
        </form>
       </div>
        </div>
</body>
</html>