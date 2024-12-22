package Utils;

import java.io.Serializable;

public class Attestation implements Serializable{
	private static final long serialVersionUID = 1L ;
	private String courseId; 
	private String studentUsername ; 
	private double firstAttestation ; 
	private double secondAttestation ; 
	private double finalExamScore ; 

	public Attestation(String courseId , String studentUsername) {
		this.courseId = courseId; 
		this.studentUsername = studentUsername ; 
		this.firstAttestation = -1;
		this.secondAttestation = -1; 
		this.finalExamScore = -1 ; 
	}
	public String getCourseId() {
        return courseId;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void putFirstAttestation(double score) {
        firstAttestation = score;
    }

    public void putSecondAttestation(double score) {
        secondAttestation = score;
    }

    public void putFinalExamScore(double score) {
    	finalExamScore = score;
    }
    @Override
    public String toString() {
        return "Attestation {\n" +
               "* Course ID='" + courseId + 
               "\n* Student Username='" + studentUsername +
               "\n* First Attestation=" + firstAttestation +
               "\n* Second Attestation=" + secondAttestation +
               "\n* Final Exam=" + finalExamScore +
               '\n' + "}";
    }

}
