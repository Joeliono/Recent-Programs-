package Practical_11;

public class StudentSupportOffice {

    public static void main(String[] args) {
        Student s1 = new Student("U0000001");
        Student s2 = new Student("U0000002");
        Student s3 = new Student("U0000003");
        Student s4 = new Student("U0000004");
        Student s5 = new Student("U0000005");


        Module m1 = new Module("CIS2344");
        Module m2 = new Module("CIS2360");
        Module m3 = new Module("CIM2130");


        m1.enrolStudent(s1);
        m1.enrolStudent(s4);
        m1.enrolStudent(s2);
        m1.enrolStudent(s5);
        m1.enrolStudent(s3);
        m1.setClassSize(m1.classList.length);

        m2.enrolStudent(s1);
        m2.enrolStudent(s3);
        m2.enrolStudent(s5);
        m2.unenrolStudent(1);
        m2.enrolStudent(s2);
        m2.setClassSize(m2.classList.length);

        m3.enrolStudent(s3);
        m3.enrolStudent(s4);
        m3.enrolStudent(s5);
        m3.unenrolStudent(2);
        m3.enrolStudent(s1);
        m3.setClassSize(m3.classList.length);


        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);


    }



}
