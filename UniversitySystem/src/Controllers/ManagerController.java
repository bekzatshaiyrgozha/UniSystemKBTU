package Controllers;

import java.util.List;
import DLL.DBContext;
import Enumerations.Faculty;
import Users.Manager;
import Users.Teacher;
import Utils.News;
import Utils.Request;
import Utils.Course;

public class ManagerController {

    // Универсальный метод для создания новостей
    public static boolean createNews(String title, String content) {
        News news = new News(title, content);
        return createNews(news);
    }

    public static boolean createNews(News news) {
        // Добавление новости в базу данных
        if (news != null) {
            DBContext.addNews(news);
            return true;
        }
        return false;
    }

    // Получение всех запросов
    public static List<Request> getAllRequests() {
        return DBContext.getRequests();
    }

    // Обработка запроса
    public static void processRequest(Request request, boolean approve) {
        if (approve) {
            request.approve();
            DBContext.addStudentToResearchers(request.getStudent());  // Добавление студента в список исследователей
        } else {
            request.reject();
        }
    }

    // Метод для создания курса
    public static boolean createCourse(String courseId, String courseName, String courseTeacher, int studyYear, Faculty faculty) {
        if (courseId == null || courseName == null || courseTeacher == null || studyYear <= 0 || faculty == null) {
            System.out.println("Invalid course data.");
            return false;
        }

        Course course = new Course(courseId, courseName, courseTeacher, studyYear, faculty);
        return createCourse(course);
    }

    public static boolean createCourse(Course course) {
        if (course != null) {
            DBContext.addCourse(course);
            System.out.println("Course " + course.getCourseName() + " created successfully!");
            return true;
        }
        return false;
    }

    // Получение всех преподавателей
    public static List<Teacher> getAllTeachers() {
        return DBContext.getTeachers();
    }
}
