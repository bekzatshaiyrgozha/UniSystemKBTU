package Utils;

import Users.Teacher;
import Users.Student;
import Enumerations.UrgencyLevel;

public class Complaint {
    private Teacher teacher;  // Преподаватель, который подает жалобу
    private UrgencyLevel priorityLevel;  // Уровень срочности (важности)
    private Student targetStudent;  // Студент, на которого подана жалоба

    // Конструктор
    public Complaint(Teacher teacher, UrgencyLevel priorityLevel, Student targetStudent) {
        this.teacher = teacher;
        this.priorityLevel = priorityLevel;
        this.targetStudent = targetStudent;
    }

    // Геттеры
    public Teacher getTeacher() {
        return teacher;
    }

    

    public UrgencyLevel getPriorityLevel() {
        return priorityLevel;
    }

    public Student getTargetStudent() {
        return targetStudent;
    }

    // Метод для вывода жалобы в строковом виде
    @Override
    public String toString() {
        return "Complaint from " + teacher.getUsername() + " about " + targetStudent.getUsername() + 
               " (" + priorityLevel + ")";
    }
}
