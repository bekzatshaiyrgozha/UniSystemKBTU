package Utils;

import java.io.Serializable;
import Users.Student;

public class Register implements Serializable {
    private static final long serialVersionUID = 1L;

    private Student student; 
    private Course course;   
    public Register(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Register [student=" + student.getUsername() + ", course=" + course.getCourseName() + "]";
    }
}
