package Views;

import java.util.Scanner;
import Users.*;
import Controllers.UserController;
import Enumerations.UserType;

public class MainView {
    private static Scanner in = new Scanner(System.in);

    // This will store the logged-in student (for later use)
    private static Student loggedInStudent;

    public static void welcome() {
        System.out.println("Welcome to WSP!\nSelect your role:");
        System.out.println("0. Admin");
        System.out.println("1. Teacher");
        System.out.println("2. Manager");
        System.out.println("3. Student");
        System.out.print("\nRole: ");
        int option = in.nextInt();

        switch (option) {
            case 0:
                authorizeAdmin();
                break;
            case 1:
                authorize("teacher.txt", UserType.TEACHER);
                break;
            case 2:
                authorize("managers.txt", UserType.MANAGER);
                break;
            case 3:
                authorize("students.txt", UserType.STUDENT);
                break;
            default:
                System.out.println("Invalid option!");
                welcome();
        }
    }

    public static void authorizeAdmin() {
        System.out.println("Please, enter admin credentials:");
        in.nextLine();  
        System.out.print("Username: ");
        String username = in.nextLine();
        System.out.print("Password: ");
        String password = in.nextLine();
        Admin admin = Admin.getInstance();
        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            System.out.println("Admin login successful!");
            AdminView.welcome();
        } else {
            System.out.println("Invalid username or password, TRY AGAIN:(!");
            welcome();
        }
    }

    public static void authorize(String fileName, UserType userType) {
        System.out.println("Please, enter your credentials:");
        in.nextLine();  // Consume the newline character left by nextInt()

        System.out.print("Username: ");
        String username = in.nextLine();

        System.out.print("Password: ");
        String password = in.nextLine();

        boolean res = UserController.authorize(fileName, username, password);

        if (res) {
            System.out.println("Login successful!");

            if (userType == UserType.STUDENT) {
                loggedInStudent = UserController.getStudentByUsername(username);
                StudentView.welcome(loggedInStudent);  
            } else if (userType == UserType.TEACHER) {
                Teacher loggedInTeacher = UserController.getTeacherByUsername(username); // Get the logged-in teacher
                TeacherView.welcome(loggedInTeacher);  // Pass the Teacher object to the TeacherView
            } else if (userType == UserType.MANAGER) {
                ManagerView.welcome(); 
            }
        } else {
            System.out.println("Invalid username or password.");
            welcome();  
        }
    }
}
