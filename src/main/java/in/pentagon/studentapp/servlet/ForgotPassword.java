package in.pentagon.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dao.StudentDao;

import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forgotpassword")
public class ForgotPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s=new Student();
		StudentDao sdao=new StudentDAOImpl();
		PrintWriter out=resp.getWriter();
		
		Student st=sdao.getStudent(Long.parseLong(req.getParameter("phone")),req.getParameter("email"));
		if(st!=null) {
			if(req.getParameter("password").equals(req.getParameter("confirm"))){
				st.setPassword(req.getParameter("password"));
				boolean res=sdao.updateStudent(st);
				if(res) {
					//out.println("<h1>Password updated successfully</h1>");
					req.setAttribute("updated", "password updated successfully");
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				}
				else {
					//out.println("<h1>Password updation failed</h1>");
					req.setAttribute("error", "password failed to reset");
					RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.jsp");
					rd.forward(req, resp);
					
				}	
			}
			else {
				//out.println("<h1>Password missmatch!</h1>");	
				req.setAttribute("error", "password mismatch!");
				RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.jsp");
				rd.forward(req, resp);
			}			
		}
		else {
			//out.println("<h1>student not found</h1>");
		req.setAttribute("error", "no such student");
		RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.jsp");
		rd.forward(req, resp);
		}
		
	}

}
