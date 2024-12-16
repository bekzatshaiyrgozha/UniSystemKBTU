package Utils;

//class Course
class Course {
  private String courseName;
  private int courseCredits;
  private String courseDescription;
  private String courseAttribute;


  public Course(String courseName, int courseCredits, String courseDescription, String courseAttribute) {
      this.courseName = courseName;
      this.courseCredits = courseCredits;
      this.courseDescription = courseDescription;
      this.courseAttribute = courseAttribute;
  }


  //getters and setters:
  public String getCourseName() {
      return courseName;
  }

  public void setCourseName(String courseName) {
      this.courseName = courseName;
  }

  public int getCourseCredits() {
      return courseCredits;
  }

  public void setCourseCredits(int courseCredits) {
      this.courseCredits = courseCredits;
  }

  public String getCourseDescription() {
      return courseDescription;
  }

  public void setCourseDescription(String courseDescription) {
      this.courseDescription = courseDescription;
  }

  @Override
  public String toString() {
      return "Course [courseName=" + courseName + ", courseCredits=" + courseCredits
              + ", courseDescription=" + courseDescription + ", courseAttribute=" + courseAttribute + "]";
  }
}