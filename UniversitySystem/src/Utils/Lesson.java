package Utils;

import Enumerations.LessonType;

import java.util.SortedSet;
import java.util.Date;

//class Lesson
public class Lesson {
    private Course course;
    private Users.Teacher teacher;
    private SortedSet<Users.Student> students;
    private Date startHour;
    private Date endHour;
    private LessonType type;

    public Lesson(Course course, Users.Teacher teacher, SortedSet<Users.Student> students, Date startHour, Date endHour, LessonType type) {
        this.course = course;
        this.startHour = startHour;
        this.endHour = endHour;
        this.type = type;
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date time) {
        this.startHour = time;
    }

    public Date getEndHour() {
        return endHour;
    }

    public void setEndHour(Date time) {
        this.endHour = time;
    }

    public Enumerations.LessonType getLessonType() {
        return type;
    }

    public void setLessonType(Enumerations.LessonType type) {
        this.type = type;
    }

    public SortedSet<Users.Student> getStudents() {
        return students;
    }

    public Users.Teacher getTeacher() {
        return teacher;
    }
}