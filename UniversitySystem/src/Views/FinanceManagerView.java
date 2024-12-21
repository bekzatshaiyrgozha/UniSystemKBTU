package Views;

import java.util.Scanner;
import java.util.Vector;

import Controllers.FinanceManagerController;
import Controllers.ManagerController;
import Controllers.UserController;
import Enumerations.Faculty;
import Users.Employee;
import Utils.Course;
import Utils.News;

public class FinanceManagerView {
private static Scanner in = new Scanner(System.in);
    

    public static void welcome() {
        System.out.println("Welcome to WSP!\n<Finance MANAGER SIDE>\nPlease select the option:");
        System.out.println("- 0. Exit");
        System.out.println("- 1. See all news");
        System.out.println("- 2. Give salary");
        System.out.println("- 3. See budjet");
        System.out.println("- 4. Is gived salary");
        System.out.print("\nOption: ");
        int option = in.nextInt();
        
        if(option == 0) {
            System.out.println("Bye bye!");
            MainView.welcome();
        } else if(option == 1) {
            seeNews();
        }
          else if (option == 2){
          	giveSalary();
          }
          else if (option == 3){
        	  seeBudjet();
            }
          else if (option == 4){
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
    
    
    public static void seeNews() {
        System.out.println("Loading all news...");
        
        for (News news : UserController.getAllNews()) {
            System.out.println(news);
            System.out.println("------------------------");
        }
   
        welcome();
    }
	public static void giveSalary() {
    	System.out.println("Loading prosedure...");
    	FinanceManagerController.giveSalary();
    	welcome();
    }
    public static void seeBudjet() {
    	System.out.println("Uni budjet:" + FinanceManagerController.seeBudjet());
    	
    	welcome();
    	
    }
}
