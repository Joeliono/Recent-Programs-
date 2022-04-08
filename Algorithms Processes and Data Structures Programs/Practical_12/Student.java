package Practical_12;

public class Student {
    private String studentID;
    private int avgStudentGrade;

    public Student(String studentID, int avgStudentGrade) {
        this.studentID = studentID;
        this.avgStudentGrade = avgStudentGrade;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getAvgStudentGrade() {
        return avgStudentGrade;
    }

    public void setAvgStudentGrade(int avgStudentGrade) {
        this.avgStudentGrade = avgStudentGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", avgStudentGrade=" + avgStudentGrade +
                '}';
    }

}
