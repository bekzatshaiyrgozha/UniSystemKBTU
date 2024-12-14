package Controllers;
import Enumerations.* ; 
import Users.*; 
import DLL.*; 
public class AdminController {
	public static boolean addUser(
			String username,
			String password, 
			UserType type) {
		switch(type) {
		case TEACHER:
			Teacher newTeacher = new Teacher(username, password);
			DBContext.teacher.add(newTeacher);
			return DBContext.saveTeachers();
		case STUDENT:
			Student newStudent = new Student(username, password);
			DBContext.student.add(newStudent); 
			return DBContext.saveStudents(); 
		case MANAGER:
			Manager newManager = new Manager(username, password);
			break;
		default:
			return false;
		}
		
		return true;
	}
}
