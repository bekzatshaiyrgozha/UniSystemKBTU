package Users;
import Enumerations.Faculty;

public class Student extends User {
	private Faculty faculty;
	private int studyYear;

	public Student(String username, String password,Faculty faculty,int studyYear) {
		super(username, password);
		this.faculty = faculty;
		this.studyYear = studyYear;
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
	
	public String toString() {
        return getUsername() + "(" + faculty + ", studyYear=" + studyYear + ")";
    }
	

	

	

}