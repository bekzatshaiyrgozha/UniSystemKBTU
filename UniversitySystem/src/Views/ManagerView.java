package Views;

import java.util.Scanner;
import java.util.Vector;

import Controllers.ManagerController;
import Controllers.UserController;
import Enumerations.Faculty;
import Utils.News;
import Utils.Course;
import Users.Employee;

public class ManagerView
 {
private static Scanner in = new Scanner(System.in);
    

    public static void welcome() {
        System.out.println("Welcome to WSP!\n<MANAGER SIDE>\nPlease select the option:");
        System.out.println("- 0. Exit");
        System.out.println("- 1. Create news");
        System.out.println("- 2. See all news");
        System.out.println("- 3. Create course");;
        System.out.println("- 4. See all course");
        System.out.println("- 5. Is gived salary");
        System.out.print("\nOption: ");
        int option = in.nextInt();
        
        if(option == 0) {
            System.out.println("Bye bye!");
            MainView.welcome();
        }
        else if(option == 1) {
            createNews();
        } else if(option == 2) {
            seeNews();
        } else if (option == 3){
        	createcourse();
        }
          else if (option == 4){
        	  seecourse();
        }
          else if (option == 5){
        	  isGiveSalary(); 
            }
          else
        {
            System.out.println("Invalid option, try again.");
            welcome();
        }
    }

    public static void isGiveSalary() {
    	if(Employee.isSalaryPaid()) {
    		System.out.println("Gived salary.");
    		
    		
    	}else {
    		System.out.println("Not geved salary.");
    	}
    	welcome();
    	
    }
    public static void createNews() {
        in.nextLine(); 
        
        System.out.println("Enter the news title:");
        String title = in.nextLine();
        
        System.out.println("Enter the news content:");
        String content = in.nextLine();
        
        News news = new News(title, content);
        
        
       
        boolean res = ManagerController.createNews(news);
        
        if(res) {
            System.out.println("News has been created successfully!");
        } else {
            System.out.println("Error creating news.");
        }
        
        welcome();
    }
    
    public static void createcourse() {
        in.nextLine();
        
        System.out.println("Enter the Course Id:");
        String courseId = in.nextLine();
        
        System.out.println("Enter the course name:");
        String courseName = in.nextLine();
        
        System.out.println("Enter the course teacher:");
        String courseTeacher = in.nextLine();
        
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
                System.out.println("Invalid year option");
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
    }

        
        Course course = new Course(courseId, courseName, courseTeacher, yearOption, faculty);
        
       
        boolean res = ManagerController.createcourse(course);
        
        if(res) {
            System.out.println("Course has been created successfully!");
        } else {
            System.out.println("Error creating course.");
        }
        
        welcome();
    }
    
    
    public static void seeNews() {
        System.out.println("Loading all news...");
        
        for (News news : UserController.getAllNews()) {
            System.out.println(news);
            System.out.println("------------------------");
        }
   
        welcome();
    }
    public static void seecourse() {
        System.out.println("Загружаю все курсы...");
        Vector<Course> courses = UserController.getAllCourses();  // Получаем курсы из файла

        if (courses.isEmpty()) {
            System.out.println("Нет доступных курсов.");
        } else {
            // Выводим информацию о каждом курсе
            for (Course course : courses) {
                System.out.println(course);  // Метод toString() класса Course будет выводить нужную информацию
                System.out.println("------------------------");
            }
        }

        welcome();  
    }
    

}
