package Practical_11;

public  class Student implements  Comparable<Student> {
    private String studentID;

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int compareTo(Student compareStudents)
    {

        return this.studentID.compareTo(compareStudents.studentID);

    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                '}';
    }

}
