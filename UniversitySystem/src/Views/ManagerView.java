package Views;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import Controllers.ManagerController;
import Controllers.UserController;
import DLL.DBContext;
import Enumerations.Faculty;
import Utils.News;
import Utils.Request;
import Utils.Course;
import Users.Employee;
import Users.Student;
import Users.Teacher;

public class ManagerView {
    private static Scanner in = new Scanner(System.in);

    public static void welcome() {
        while (true) {
            System.out.println("Welcome to WSP!\n<MANAGER SIDE>\nPlease select the option:");
            System.out.println("- 0. Exit");
            System.out.println("- 1. Create news");
            System.out.println("- 2. See all news");
            System.out.println("- 3. Create course");
            System.out.println("- 4. See all course");
            System.out.println("- 5. Is gived salary");
            System.out.println("- 6. View requests");
            System.out.println("- 7. View Researchers");
            System.out.print("\nOption: ");
            int option = in.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Bye bye!");
                    MainView.welcome();
                    return;
                case 1:
                    createNews();
                    break;
                case 2:
                    seeNews();
                    break;
                case 3:
                    createcourse();
                    break;
                case 4:
                    seecourse();
                    break;
                case 5:
                    isGiveSalary();
                    break;
                case 6:
                    viewRequests();
                    break;
                case 7:
                    viewResearchers();
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void viewRequests() {
        List<Request> requests = ManagerController.getAllRequests();

        if (requests.isEmpty()) {
            System.out.println("No requests found.");
        } else {
            for (Request request : requests) {
                System.out.println(request);
                System.out.println("----------------------");
            }
        }

        System.out.println("Enter the request index to process, or -1 to return:");
        int index = in.nextInt();
        in.nextLine(); // Consume the newline

        if (index >= 0 && index < requests.size()) {
            Request request = requests.get(index);

            System.out.println("1. Approve");
            System.out.println("2. Reject");
            System.out.print("Option: ");
            int option = in.nextInt();

            if (option == 1) {
                ManagerController.processRequest(request, true);
                DBContext.getStudentsResearchers().add(request.getStudent()); // Add to researchers list
                System.out.println("Request approved.");
            } else if (option == 2) {
                ManagerController.processRequest(request, false);
                System.out.println("Request rejected.");
            } else {
                System.out.println("Invalid option.");
            }
        }

    }

    public static void viewResearchers() {
        Vector<Student> researchers = DBContext.getStudentsResearchers();  // Get the list of researchers

        if (researchers.isEmpty()) {
            System.out.println("No researchers found.");
        } else {
            System.out.println("List of researchers:");
            for (Student student : researchers) {
                System.out.println(student.getUsername() + " - Faculty: " + student.getFaculty());
            }
        }

    }

    public static void isGiveSalary() {
        if (Employee.isSalaryPaid()) {
            System.out.println("Salary has been given.");
        } else {
            System.out.println("Salary has not been given.");
        }
    }

    public static void createNews() {
        in.nextLine(); // Clear the scanner buffer

        System.out.println("Enter the news title:");
        String title = in.nextLine();

        System.out.println("Enter the news content:");
        String content = in.nextLine();

        News news = new News(title, content);

        boolean res = ManagerController.createNews(news);

        if (res) {
            System.out.println("News has been created successfully!");
        } else {
            System.out.println("Error creating news.");
        }
    }

    public static void createcourse() {
        in.nextLine(); // Clear the scanner buffer

        System.out.println("Enter the Course Id:");
        String courseId = in.nextLine();

        System.out.println("Enter the course name:");
        String courseName = in.nextLine();

        // Get the list of available teachers from the database or controller
        Vector<String> teachers = getExistingTeachers();

        // If no teachers, show a message and return
        if (teachers.isEmpty()) {
            System.out.println("No teachers available.");
            return;
        }

        // Show the list of teachers
        System.out.println("Select the course teacher:");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + ". " + teachers.get(i));  // Display teachers with numbers
        }
        System.out.print("Option: ");
        int teacherOption = in.nextInt();
        in.nextLine();  // Clear the buffer

        if (teacherOption < 1 || teacherOption > teachers.size()) {
            System.out.println("Invalid teacher option.");
            return;
        }

        // Get the selected teacher
        String selectedTeacher = teachers.get(teacherOption - 1);

        System.out.println("Select study year:");
        System.out.println("1. First Year");
        System.out.println("2. Second Year");
        System.out.println("3. Third Year");
        System.out.println("4. Fourth Year");
        System.out.print("Option: ");
        int yearOption = in.nextInt();
        int studyYear = 0;

        switch (yearOption) {
            case 1:
                studyYear = 1;
                break;
            case 2:
                studyYear = 2;
                break;
            case 3:
                studyYear = 3;
                break;
            case 4:
                studyYear = 4;
                break;
            default:
                System.out.println("Invalid year option.");
                return;
        }

        System.out.println("Select the faculty:");
        System.out.println("1. FIT");
        System.out.println("2. BS");
        System.out.println("3. SEPI");
        System.out.print("Option: ");
        int facultyOption = in.nextInt();
        Faculty faculty = null;

        switch (facultyOption) {
            case 1:
                faculty = Faculty.FIT;
                break;
            case 2:
                faculty = Faculty.BS;
                break;
            case 3:
                faculty = Faculty.SEPI;
                break;
            default:
                System.out.println("Invalid faculty option. Defaulting to FIT.");
                faculty = Faculty.FIT;
        }

        // Create the course object
        Course course = new Course(courseId, courseName, selectedTeacher, studyYear, faculty);

        boolean res = ManagerController.createCourse(course);

        if (res) {
            System.out.println("Course has been created successfully!");
        } else {
            System.out.println("Error creating course.");
        }
    }

    // Helper method to retrieve existing teachers from the database or controller
    private static Vector<String> getExistingTeachers() {
        Vector<String> teachers = new Vector<>();

        // Get all teachers (for now, using the manager controller)
        List<Teacher> allTeachers = ManagerController.getAllTeachers();

        for (Teacher teacher : allTeachers) {
            teachers.add(teacher.getUsername());  // Add the teachers' usernames to the list
        }

        return teachers;
    }

    public static void seeNews() {
        System.out.println("Loading all news...");

        for (News news : UserController.getAllNews()) {
            System.out.println(news);
            System.out.println("------------------------");
        }
    }

    public static void seecourse() {
        System.out.println("Loading all courses...");
        Vector<Course> courses = UserController.getAllCourses();  // Get courses from the database

        if (courses.isEmpty()) {
            System.out.println("No available courses.");
        } else {
            // Display information about each course
            for (Course course : courses) {
                System.out.println(course);  // The toString() method of the Course class will display the needed info
                System.out.println("------------------------");
            }
        }
    }
}
