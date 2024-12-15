package Views;

import java.util.Scanner;

public class TeacherView {
	private static Scanner in = new Scanner(System.in);
	public static void welcome() {
		
		System.out.println("Welcome to WSP! TO TEACHER SIDE!\nPlease select the option:");
		System.out.println("0.Exit"); 
		int option = in.nextInt() ;
		if(option == 0) {
			System.out.println("Bye bye") ;
			MainView.welcome(); 
		}
	}

}
