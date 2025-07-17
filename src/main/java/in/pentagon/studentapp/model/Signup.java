package in.pentagon.studentapp.model;

import java.util.Scanner;
import in.pentagon.studentapp.dao.StudentDao; 
import in.pentagon.studentapp.dao.StudentDAOImpl; 
import in.pentagon.studentapp.dto.Student;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dao.StudentDao;


import in.pentagon.studentapp.dto.Student;

public class Signup {

	public static void signup() {
		Scanner sc=new Scanner(System.in);
		Student s=new Student();
		
		StudentDao dao=new StudentDAOImpl();
		System.out.println("<--Welcome to Signup Page-->");
		System.out.println("Enter the name: ");
		s.setName(sc.next());
		System.out.println("Enter the Phone number: ");
		s.setPhone(sc.nextLong());
		System.out.println("Enter the Mail: ");
		s.setMail(sc.next());
		System.out.println("Enter the Branch: ");
		s.setBranch(sc.next());
		System.out.println("Enter the Location: ");
		s.setLocation(sc.next());
		System.out.println("Enter the Password: ");
		String password=sc.next();
		System.out.println("Confirm password: ");
		String confpassword=sc.next();
		
		
		if(password.equals(confpassword)) { 
			   s.setPassword(confpassword); 
			   boolean res=dao.insertStudent(s); 
			   if(res) { 
			    System.out.println("Data added successfully"); 
			   } 
			   else { 
			    System.out.println("Failed to add the data"); 
			   } 
		 } 
		else { 
			 System.out.println("Password mismatch!"); 
		}  
	}
}


