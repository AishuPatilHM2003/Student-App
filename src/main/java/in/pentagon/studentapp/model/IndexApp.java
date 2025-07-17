package in.pentagon.studentapp.model;

import java.util.Scanner;

public class IndexApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		System.out.println("welcome to student app");
		
		do {
			System.out.println("1.SIGNUP");
			System.out.println("2.LOGIN");
			System.out.println("3.FORGOT PASSWORD?");
			System.out.println("4.EXIT");
			
			choice=sc.nextInt();
			switch(choice) {
			case 1: Signup.signup();
				break;
			case 2: Login.login();
				break;
			case 3: ForgotPassword.forgot();
				break;
			case 4: System.out.println("thank you");
			    break;
			default:System.out.println("invalid choice, enter valid choice");
			   
			
			}
		}while(choice!=4);

	}

}
