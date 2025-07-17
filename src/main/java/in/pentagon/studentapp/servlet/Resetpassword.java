package in.pentagon.studentapp.servlet;

import java.io.IOException;

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
@WebServlet("/resetpassword")
public class Resetpassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		StudentDAOImpl sdao=new StudentDAOImpl();
		Student s=(Student)session.getAttribute("student");
		
		if(s!=null) {
			if(Long.parseLong(req.getParameter("phone"))==s.getPhone() && req.getParameter("email").equals(s.getMail())){
				if(req.getParameter("password").equals(req.getParameter("confirm"))) {
					s.setPassword(req.getParameter("password"));
					boolean res=sdao.updateStudent(s);
					if(res) {
						req.setAttribute("success","Password updated successfully!"); 
					      RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp"); 
					      rd.forward(req, resp);
					}
					else { 
					      req.setAttribute("error","Failed to update the password!"); 
					      RequestDispatcher rd=req.getRequestDispatcher("resetpassword.jsp"); 
					      rd.forward(req, resp); 
					     }
				}
				else {
					req.setAttribute("error","Password mismatch!"); 
				     RequestDispatcher rd=req.getRequestDispatcher("resetpassword.jsp"); 
				     rd.forward(req, resp); 
				}
				
			}
			else {
				req.setAttribute("error","Something went wrong!!!!!!"); 
			     RequestDispatcher rd=req.getRequestDispatcher("login.jsp"); 
			     rd.forward(req, resp); 
				
			}
		}
		else {
			req.setAttribute("error","Session expired!"); 
			   RequestDispatcher rd=req.getRequestDispatcher("login.jsp"); 
			   rd.forward(req, resp);
		}
	}

}
