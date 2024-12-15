package Views;

import java.util.Scanner;

import Controllers.ManagerController;
import Controllers.UserController;
import Utils.News;

public class ManagerView {
private static Scanner in = new Scanner(System.in);
    
    // Manager welcome page
    public static void welcome() {
        System.out.println("Welcome to WSP!\n<MANAGER SIDE>\nPlease select the option:");
        System.out.println("- 0. Exit");
        System.out.println("- 1. Create news");
        System.out.println("- 2. See all news");
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
        } else {
            System.out.println("Invalid option, try again.");
            welcome();
        }
    }

    // Method to create news
    public static void createNews() {
        in.nextLine(); // consume the newline character left by nextInt()
        
        System.out.println("Enter the news title:");
        String title = in.nextLine();
        
        System.out.println("Enter the news content:");
        String content = in.nextLine();
        
        // Create a News object
        News news = new News(title, content);
        
        // Delegate the saving of the news to the ManagerController
        boolean res = ManagerController.createNews(news);
        
        if(res) {
            System.out.println("News has been created successfully!");
        } else {
            System.out.println("Error creating news.");
        }
        
        welcome();
    }
    public static void seeNews() {
        System.out.println("Loading all news...");
        
        // Retrieve all news using UserController
        for (News news : UserController.getAllNews()) {
            System.out.println(news);
            System.out.println("------------------------");
        }
   
        welcome();
    }
}