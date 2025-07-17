package in.pentagon.studentapp.servlet;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dao.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")

public class Signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s=new Student();
		StudentDao sdao=new StudentDAOImpl();
		PrintWriter out=resp.getWriter();
		s.setName(req.getParameter("name"));
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("mail"));
		s.setBranch(req.getParameter("branch"));
		s.setLocation(req.getParameter("location"));
		
//		s.setPassword(req.getParameter("password"));
//		s.setconfpassword(req.getParameter("confirm"));
		
		if (req.getParameter("password").equals(req.getParameter("confirm"))){
			s.setPassword(req.getParameter("password"));
			boolean res=sdao.insertStudent(s);
			if(res)
			{
				//out.println("<h1>Data saved successfully</h1>");
				req.setAttribute("success", "Account added successfully");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}
			else {
				//out.println("<h1>failed to save the data</h1>");
				req.setAttribute("error", "Failed to create an account");
				RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			//out.println("<h1>Password mismatch</h1>");
			req.setAttribute("error", "Password missmatch");
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
			
		}
	
	}
	
	

}
