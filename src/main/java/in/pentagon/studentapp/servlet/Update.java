package in.pentagon.studentapp.servlet;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dao.StudentDao;
import in.pentagon.studentapp.dto.Student;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/updateAccount")
public class Update extends HttpServlet {

	
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession session=req.getSession(false);
			StudentDao sdao=new StudentDAOImpl();
			Student st=(Student)session.getAttribute("student");
			
			if(st!=null) {
				st.setName(req.getParameter("name"));
				st.setPhone(Long.parseLong(req.getParameter("phone")));
				st.setMail(req.getParameter("mail"));
				st.setBranch(req.getParameter("branch"));
				st.setLocation(req.getParameter("loc"));
				boolean res=sdao.updateStudent(st);
				if(res) {
					req.setAttribute("success", "account updated successfully");
					RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
					rd.forward(req, resp);
					
				}
				else {
					req.setAttribute("error", "failed to update");
					RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
					rd.forward(req, resp);
				}
			}
			else {
				req.setAttribute("error", "session expired");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
				
			}
			
			
		}
		

	}


