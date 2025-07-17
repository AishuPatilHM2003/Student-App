package in.pentagon.studentapp.model;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import in.pentagon.studentapp.dao.StudentDao;
public class Search {
	public static void user() {
		Scanner sc= new Scanner(System.in);
		StudentDao dao=new StudentDAOImpl();
		System.out.println("Enter the name of the user to search");
		ArrayList <Student> st=dao.getStudent(sc.next());
		if(st!=null) {
			for(Student s:st) {
				System.out.println("------------------------");
				System.out.println("ID:"+s.getId());
				System.out.println("name:"+s.getName());
				System.out.println("branch:"+s.getBranch());
				System.out.println("------------------------");
			}
		}
		else {
			System.out.println("No such user!");
		}
	}
}