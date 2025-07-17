package in.pentagon.studentapp.servlet;

import java.io.IOException;

import in.pentagon.studentapp.dao.StudentDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class Delete extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAOImpl dao=new StudentDAOImpl();
		boolean res=dao.deleteStudent(Integer.parseInt(req.getParameter("id")));
		if(res) {
			req.setAttribute("success", "user's record deleted!");
			RequestDispatcher rd=req.getRequestDispatcher("ViewUser.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("error", "Failed to delete the data");
			RequestDispatcher rd=req.getRequestDispatcher("ViewUser");
			rd.forward(req, resp);
		}
		
	}

}
