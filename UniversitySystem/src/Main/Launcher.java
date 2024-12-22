package Main;

import Exception.UserNotFoundException;
import Views.MainView;

public class Launcher {
	public static void main(String[] args) throws UserNotFoundException {
		MainView.welcome();
	}
}
