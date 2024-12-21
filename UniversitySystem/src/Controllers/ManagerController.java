package Controllers;

import DLL.DBContext;
import Enumerations.Faculty;
import Enumerations.SemesterType;
import Users.Employee;
import Utils.News;
import Utils.Course;
import Users.Manager;
import Users.Teacher;
import Users.Admin;
import Utils.FinanceOffice;

public class ManagerController {
	public static void createNews(String title , String content) {
		News news = new News(title , content); 
		DBContext.addNews(news);
	}

	public static boolean createNews(News news) {
		DBContext.addNews(news);
		return true; 
	}
	
	public static void createCourse(String courseId, String courseName, String courseTeacher, 
            int studyYear, Faculty faculty) {
    Course course = new Course(courseId, courseName, courseTeacher, studyYear, faculty);
    
    DBContext.addCourse(course);
    System.out.println("Course " + courseName + " created successfully!");
	}

	public static boolean createcourse(Course course) {
		DBContext.addCourse(course);
		return true; 
	}
	
	
	
}
