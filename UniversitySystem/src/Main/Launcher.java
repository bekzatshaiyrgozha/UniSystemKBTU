package Main;

import Users.Teacher;
import Views.MainView;

public class Launcher {
	public static void main(String[] args) {
		MainView.welcome();
		Teacher t = new Teacher("a_izbassar", "teacher"); 
	}
}
