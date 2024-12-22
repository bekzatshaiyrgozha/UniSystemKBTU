package Views;

import java.util.Scanner;
import Users.Student;
import Utils.Course;
import Utils.Register;
import Utils.Request;
import Controllers.UserController;
import DLL.DBContext;

public class StudentView {
    static Scanner in = new Scanner(System.in); 

    public static void welcome(Student loggedInStudent) {
        System.out.println("\nWelcome to WSP, " + loggedInStudent.getUsername() + "!");
        System.out.println("Please select an option:");
        System.out.println("0. Exit");
        System.out.println("1. See all news");
        System.out.println("2.Send request");
        System.out.println("7. View My Profile");
        System.out.println("8. Register for a Course");

        int option = in.nextInt();
        in.nextLine();  

        if (option == 0) {
            System.out.println("Bye bye!");
            MainView.welcome();
        } 
        else if (option == 1) {
            ManagerView.seeNews();
        } 
        else if (option == 2) {
        	sendRequest(loggedInStudent); 
        }
        else if (option == 7) {
            myProfile(loggedInStudent);  
        }
        else if (option == 8) {
        	registerForCourse(loggedInStudent);
        }
        else {
            System.out.println("Invalid option. Please try again.");
            welcome(loggedInStudent);  
        }
    }
    public static void sendRequest(Student student) {
    	System.out.println("Enter your request description:");
        String description = in.nextLine();

        Request request = new Request(student, description);
        DBContext.addRequest(request);

        System.out.println("Your request has been sent!");
        welcome(student);
    }
    public static void myProfile(Student student) {
        System.out.println("\n--- Student Profile ---");
        System.out.println("Username: " + student.getUsername());
        System.out.println("Faculty: " + student.getFaculty());
        System.out.println("Semester: " + student.getStudyYear());
        System.out.println("-----------------------");
        welcome(student);

    }
    public static void registerForCourse(Student student) {
        for (Course course : UserController.getAllCourses()) {
            if (course.getFaculty().equals(student.getFaculty()) && course.getStudyYear() == student.getStudyYear()) {
                System.out.println(course);
            }
        }
        System.out.println("Enter the course ID to register:");
        String courseId = in.nextLine();

        // Find the course by its ID
        Course selectedCourse = null;
        for (Course course : UserController.getAllCourses()) {
            if (course.getCourseId().equals(courseId)) {
                selectedCourse = course;
                break;
            }
        }

        if (selectedCourse != null) {
            Register register = new Register(student, selectedCourse);

            DBContext.addRegister(register);
            
            System.out.println("Successfully registered for course: " + selectedCourse.getCourseName());
        } else {
            System.out.println("Course with the given ID not found.");
        }

        welcome(student);
    }


}
    
