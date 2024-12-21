package Utils;

import Users.Student;

public class Request {
    private Student student;
    private String description;
    private String status; // "Pending", "Approved", "Rejected"

    public Request(Student student, String description) {
        this.student = student;
        this.description = description;
        this.status = "Pending"; // Default status
    }

    public Student getStudent() {
        return student;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void approve() {
        this.status = "Approved";
    }

    public void reject() {
        this.status = "Rejected";
    }

    @Override
    public String toString() {
        return "Request from: " + student.getUsername() +
               "\nDescription: " + description +
               "\nStatus: " + status;
    }
}