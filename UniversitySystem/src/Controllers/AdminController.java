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
			DBContext.manager.add(newManager); 
			return DBContext.saveManagers(); 
		default:
			return false;
		}
	}
	public static boolean deleteUser(String username , UserType type) {
		switch(type) {
		case TEACHER :
			boolean removedTeacher = DBContext.teacher.removeIf(teacher -> teacher.getUsername().equals(username));
			if(removedTeacher) {
				return DBContext.saveTeachers(); 
			}
			break; 
		case STUDENT: 
			boolean removedStudent = DBContext.student.removeIf(student -> student.getUsername().equals(username));
            if (removedStudent) {
                return DBContext.saveStudents();
            }
            break;
        case MANAGER:
            boolean removedManager = DBContext.manager.removeIf(manager -> manager.getUsername().equals(username));
            if (removedManager) {
                return DBContext.saveManagers();
            }
            break;
        default :
        	return false ;
		}
		return false ;
	}
	public static Admin getAdmin() {
		return Admin.getInstance(); 
	}
}
