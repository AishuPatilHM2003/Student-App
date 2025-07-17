package in.pentagon.studentapp.model; 
import java.util.ArrayList;
import java.util.Scanner; 
import in.pentagon.studentapp.dao.StudentDao; 
import in.pentagon.studentapp.dao.StudentDAOImpl; 
import in.pentagon.studentapp.dto.Student;

public class Login { 
public static void login() { 
	
Scanner sc=new Scanner(System.in);
Student s=new Student(); 

StudentDao sdao=new StudentDAOImpl(); 

int choice=0; 
System.out.println("Enter the mail ID:"); 
String mail=sc.next(); 
System.out.println("Enter the password:"); 
String password=sc.next(); 
Student st=sdao.getStudent(mail, password);

if(st!=null) { 
	   System.out.println("login successful, Welcome "+st.getName()); 
	   do { 
	    System.out.println("1. View Account"); 
	    System.out.println("2. Update Account"); 
	    System.out.println("3. Reset Password"); 
	    System.out.println("4. Search User"); 
	    System.out.println("5. Main menu"); 
	    if(st.getId()==1) {
	     System.out.println("6.View all Students "); 
	     System.out.println("7. Delete User"); 
	      
	    } 
	    choice=sc.nextInt(); 
	     switch(choice) { 
	     case 1: System.out.println(st); 
	     break; 
	     case 2: Update.update(st); 
	     break; 
	     case 3: ForgotPassword.forgot(); 
	     break; 
	     case 4: System.out.println("Enter the user name:"); 
	     ArrayList<Student> studentsList=sdao.getStudent(sc.next()); 
	     for(Student s2:studentsList) { 
	      System.out.println("=========================="); 
	      System.out.println("Id:"+s2.getId());
	      System.out.println("Name:"+s2.getName()); 
	      System.out.println("Branch"+s2.getBranch()); 
	      System.out.println("=========================="); 
	     } 
	     break; 
	     
	     case 5: System.out.println("Going back to main menu..."); 
	     break; 
	     
	     case 6: 
	      ArrayList<Student> students=sdao.getStudent(); 
	      for(Student s1:students) { 
	       System.out.println(s1); 
	      } 
	     break; 
	     
	     case 7: System.out.println("Enter the Student ID to be deleted:"); 
	       boolean res=sdao.deleteStudent(sc.nextInt()); 
	       if(res) { 
	        System.out.println("Data deleted successfully"); 
	       } 
	       else { 
	        System.out.println("Failed to delete the data"); 
	       } 
	     default: System.out.println("Invalid choice!"); 
	     break; 
	     } 
	      
	    }while(choice!=5); 
	  } 
	  else {
		  System.out.println("Failed to login!"); 
	  }  
	  }
	 } 
	
	          