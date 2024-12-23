package Users;
import Enumerations.Faculty;

public class Student extends User {
	private Faculty faculty;
	private int studyYear;
	private static boolean attendent = false;
	private static boolean attendentStatus = false;

	public Student(String username, String password,Faculty faculty,int studyYear) {
		super(username, password);
		this.faculty = faculty;
		this.studyYear = studyYear;
		this.attendentStatus = false;
		this.attendent = false;
	}
	public static boolean getattendent() {
		return attendent;
	}
	public static boolean getAttendentStatus() {
		return attendentStatus;
	}
	public static void resetAttendentStatus() {
		attendentStatus = false;
	}
	public static void resettattendent() {
		attendent = false;
	}
	public  void setAttendentStatus(boolean status) {
		this.attendentStatus = status;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	public int getStudyYear() {
		return studyYear;
	}
	public void setFaculty() {
		this.faculty = faculty;
	}
	
	public void setSemester() {
		this.studyYear = studyYear;
	}
	public static void setattendent() {
		attendent = true;
	}
	
	public String toString() {
        return "Student{username='" + getUsername() + "', faculty=" + faculty + ", studyYear=" + studyYear + "}";
    }
	

	

	

}