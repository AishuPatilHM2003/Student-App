package in.pentagon.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.pentagon.studentapp.connector.Connector;
import in.pentagon.studentapp.dto.Student;

public class StudentDAOImpl implements StudentDao{
	
	public StudentDAOImpl() {
		this.con=Connector.requestConnection();
	}
	
	Connection con=Connector.requestConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;

	@Override
	public boolean insertStudent(Student s) {
		int res = 0;
		String query="INSERT INTO STUDENT VALUES(0,?,?,?,?,?,?,SYSDATE())";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2,s.getPhone());
			ps.setString(3,s.getMail());
			ps.setString(4,s.getBranch());
			ps.setString(5,s.getLocation());
			ps.setString(6,s.getPassword());
			res=ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		if(res>=1) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateStudent(Student s) { 
		  PreparedStatement ps=null; 
		  String query="UPDATE STUDENT SET NAME=?,PHONE=?,MAIL=?,BRANCH=?,LOCATION=?,PASSWORD=? WHERE ID=?"; 
		  int i=0; 
		  try { 
		   ps=con.prepareStatement(query); 
		   ps.setString(1,s.getName()); 
		   ps.setLong(2, s.getPhone()); 
		   ps.setString(3,s.getMail()); 
		   ps.setString(4,s.getBranch()); 
		   ps.setString(5, s.getLocation()); 
		   ps.setString(6, s.getPassword()); 
		   ps.setInt(7, s.getId()); 
		   i=ps.executeUpdate(); 
		  } catch (SQLException e) { 
			  e.printStackTrace(); 
		  } 
		  if(i>0) 
		  { 
		   return true; 
		  } 
		  else { 
		   return false; 
		  } 
		 } 

	@Override
	public boolean deleteStudent(int id) {
		PreparedStatement ps=null;
		String query = "DELETE  FROM STUDENT WHERE ID=?";
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>=1) {
			return true;
		}
		else {
			return false;
		}
	}

	

	@Override
	public Student getStudent(String mail, String password) {
		PreparedStatement ps=null;
		  String query = "SELECT * FROM STUDENT WHERE MAIL=? AND PASSWORD=?";
		  Student s=null;
		    try {
		        ps = con.prepareStatement(query);
		        ps.setString(1, mail);
		        ps.setString(2, password);
		        rs = ps.executeQuery();
		        
		     while (rs.next()) {
		            s = new Student();
		            s.setId(rs.getInt("id"));
		            s.setName(rs.getString("name"));
		            s.setPhone(rs.getLong("phone"));
		            s.setMail(rs.getString("mail"));
		            s.setBranch(rs.getString("branch"));
		            s.setLocation(rs.getString("location"));
		            s.setPassword(rs.getString("password"));
		            s.setDate(rs.getString("date"));
		            System.out.println("Login successful");
		            
		        } 
		    } catch (SQLException e) {
		        e.printStackTrace();
		        
		    }
		    return s;

	}

	@Override
	public Student getStudent(long phone, String mail) {
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE PHONE=? AND MAIL=?";
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2, mail);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
	            s.setName(rs.getString("name"));
	            s.setPhone(rs.getLong("phone"));
	            s.setMail(rs.getString("mail"));
	            s.setBranch(rs.getString("branch"));
	            s.setLocation(rs.getString("location"));
	            s.setPassword(rs.getString("password"));
	            s.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;	
		}
		

	@Override
	public ArrayList<Student> getStudent() {
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE ID!=2";
		ArrayList<Student> studentlist=new ArrayList<Student>();
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				s = new Student();
	            s.setId(rs.getInt("id"));
	            s.setName(rs.getString("name"));
	            s.setPhone(rs.getLong("phone"));
	            s.setMail(rs.getString("mail"));
	            s.setBranch(rs.getString("branch"));
	            s.setLocation(rs.getString("location"));
	            s.setPassword(rs.getString("password"));
	            s.setDate(rs.getString("date"));
	            studentlist.add(s);
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentlist;

	}
	@Override
	public ArrayList<Student> getStudent(String name) {
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE NAME=?";
		ArrayList<Student> students=new ArrayList<Student>();
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			rs=ps.executeQuery();
			while(rs.next()) {
				s = new Student();
	            s.setId(rs.getInt("id"));
	            s.setName(rs.getString("name"));
	            s.setPhone(rs.getLong("phone"));
	            s.setMail(rs.getString("mail"));
	            s.setBranch(rs.getString("branch"));
	            s.setLocation(rs.getString("location"));
	            s.setPassword(rs.getString("password"));
	            s.setDate(rs.getString("date"));
	            students.add(s);
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	


}
