package Views;

import java.util.Scanner;

import Controllers.UserController;
import Utils.News;

public class TeacherView {
	static Scanner in = new Scanner(System.in); 
	public static void welcome() {
		System.out.println("Welcome to WSP!\nPlease select the option:");
		System.out.println("0.Exit");
		System.out.println("1.See all news");
		int option = in.nextInt();
		if(option == 0) {
			System.out.println("Bye bye!"); 
			MainView.welcome();
		}
		else if (option == 1) {
			ManagerView.seeNews();
		} else if (option == 2) {
			//showTeachers();
		} else if (option == 3) {
			//showStudents(); 
		} else if(option == 4) {
			//showManagers(); 
		} else if(option == 5) {
			//deleteUser();
		} else if(option == 6) {
			//ManagerView.seeNews();
		}
	}
}
