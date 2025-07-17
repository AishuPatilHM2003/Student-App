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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")

public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s=new Student();
		HttpSession session=req.getSession(true);
		StudentDao sdao=new StudentDAOImpl();
		//PrintWriter out=resp.getWriter();
		
		Student st=sdao.getStudent((req.getParameter("email")), (req.getParameter("password")));
		if(st!=null) {
			//out.print("<h1>Login successfull</h1>");
			
			//req.setAttribute("student",st);
			
			session.setAttribute("student", st);
			req.setAttribute("success","Logged in successfully!");
			RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			rd.forward(req, resp);
		}
		else {
			//out.print("<h1>failed to Login </h1>");
			req.setAttribute("error", "failed to login");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}

	}
	

}
