package Controllers;
import java.util.*;

import DLL.DBContext;
import Enumerations.UserType;
import Users.*; 
public class UserController {
	public static boolean authorize(String fileName , String username , String password) {
		Vector<?> users = null ; 
		if (fileName.equals("teacher.txt")) {
            users = (Vector<Teacher>) UserController.getUsers(UserType.TEACHER);
        } else if (fileName.equals("students.txt")) {
            users = (Vector<Student>) UserController.getUsers(UserType.STUDENT);
        } else if (fileName.equals("managers.txt")) {
            users = (Vector<Manager>) UserController.getUsers(UserType.MANAGER);
        }
        if (users == null) return false;

        for (Object user : users) {
            if (user instanceof User) {
                User u = (User) user;
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    return true;
                }
            }
        }

        return false;
	}
	public static Object getUsers(UserType type) {
		switch (type){
		case TEACHER:
			return DBContext.getTeachers();
		case STUDENT:
			return DBContext.getStudents();
		case MANAGER:
			//return DBContext.getManagers();
		default:
			return null;

	}
	}
}