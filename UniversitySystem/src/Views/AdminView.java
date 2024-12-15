package Views;

import java.util.Scanner;

import Controllers.AdminController;
import Controllers.UserController;
import Enumerations.UserType;

public class AdminView {
	
	private static Scanner in = new Scanner(System.in);
//	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	//admin welcome page
	public static void welcome() {
		System.out.println("Welcome to WSP!\n<ADMIN SIDE>\nPlease select the option:");
		System.out.println("- 0.Exit"); 
		System.out.println("- 1. Create a new user;");
		System.out.println("- 2. Show teachers;");
		System.out.println("- 3. Show students;");
		System.out.println("- 4.Delete a user"); 
		System.out.print("\nOption : ");
		int option = in.nextInt();
		if(option == 0) {
			System.out.println("Bye bye!"); 
			MainView.welcome();
		}
		else if (option == 1) {
			createUser();
		} else if (option == 2) {
			showTeachers();
		} else if (option == 3) {
			showStudents(); 
		} else if(option == 4) {
			deleteUser(); 
		}
	}
	
	public static void showTeachers() {
		System.out.println("Loading the teachers...");
		
		Object o = UserController.getUsers(UserType.TEACHER);
		
		System.out.println(o);
		
		welcome();
	}
	public static void showStudents() {
		System.out.println("Loading the students..."); 
		
		Object o = UserController.getUsers(UserType.STUDENT); 
		
		System.out.println(o) ;
		
		welcome() ; 
	}
	public static void createUser() {
		
		System.out.println("What role do you want to create?");
		System.out.println("- 0. Back to Admin side"); 
		System.out.println("- 1. Teacher;");
		System.out.println("- 2. Student;");
		System.out.println("- 3. Manager;");
		System.out.print("\n Option : ");
		int option = in.nextInt();
		
		in.nextLine(); // waiting moment
		if(option == 0) {
			System.out.println("TO ADMIN SIDE ..."); 
			welcome(); 
		}
		else if (option == 1) {
			System.out.println("Creating a new teacher...");
			
			System.out.print("Enter a username:");
			String username = in.nextLine();
			System.out.println(); 
			System.out.print("Enter a password:");
			String password = in.nextLine();
			
			// controller
			boolean res = AdminController.addUser(username, password, UserType.TEACHER);
			
			if (res) {
				System.out.println(username + " is created!");
			} else {
				System.err.println("error!");
			}
			welcome();
		}
		if (option == 2) {
			System.out.println("Creating a new student..."); 
			System.out.println("Enter a username:");
			String username = in.nextLine();
			System.out.println("Enter a password:");
			String password = in.nextLine();
			
			boolean res = AdminController.addUser(username, password, UserType.STUDENT); 
			
			if(res) {
				System.out.println(username + " is created!"); 
			}
			else {
				System.out.println("error!"); 
			}
			welcome() ;
		}
	
	}
	public static void deleteUser() {
		 System.out.println("What type of user do you want to delete?");
	     System.out.println("- 0.Back to ADMIN SIDE"); 
		 System.out.println("- 1. Teacher");
	     System.out.println("- 2. Student");
	     System.out.println("- 3. Manager");
	     System.out.print("\nOption :");
	     int option = in.nextInt(); 
	     if(option == 0) {
	    	 System.out.println("TO ADMIN SIDE..."); 
	    	 welcome(); 
	     }
	     else {
	    	 in.nextLine(); 
	     	System.out.println("Enter the username of the user to delete");
	     	String username = in.nextLine(); 
	     
	     	UserType type = option == 1 ? UserType.TEACHER : option == 2 ? UserType.STUDENT : UserType.MANAGER; 
	     	boolean res = AdminController.deleteUser(username, type); 
	     	if(res) {
	    	 	System.out.println(username + " has been deleted!") ;
	     	}
	     	else {
	    	 	System.out.println("Error : USER NOT FOUND!"); 
	     	}
	     	welcome() ; 
	     }
	}
}