package Practical_12;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StudentSupportOffice
{
  public static LinkedList<Grade> grades = new LinkedList<>();
    public static List<Module> modules = new ArrayList<>();
   public static List<Student> students = new ArrayList<>();


    public static void insertGrade(Student student, Module module, int score)
    {
        //makes a new grade for a student module
       Grade grade = new Grade(student, module, score);
        grades.add(grade);
    }

    public  static  void deleteGrade(Grade grade, Student student, Module module)
    {
        if (grade.getStudent() == student && grade.getModule() == module) //  where the grade contains the specific student and module
        {
            grades.remove(grade); //remove from linked list
        }
        else
        {
            System.out.println("failed to remove student");
        }
    }

    public static void updateGrade(Grade grade,Student student, Module module, int score)
    {
          if (grade.getStudent() == student && grade.getModule() == module)
          {
              System.out.println(grade.getScore() + " is (new score) now " + score);
              grade.setScore(score);
          }
          else
          {
              System.out.println("Failed to update score!");
          }

    }

    public static void recalculateAverage(Grade grade, Student student, Module module)
    {

        int studentAverage;
        int moduleAverage;
        if (grade.getStudent() == student && grade.getModule() == module)
        {

            studentAverage = ( grade.getStudent().getAvgStudentGrade() + grade.getScore() ) / 2;
            moduleAverage = ( grade.getModule().getAvgModuleGrade() + grade.getScore() ) / 2;

            System.out.println(grade.getStudent().getAvgStudentGrade() + " is (new student average) now " + studentAverage + " and " + grade.getModule().getAvgModuleGrade() + " is (new module average) now " + moduleAverage);

            grade.getStudent().setAvgStudentGrade(studentAverage);
            grade.getModule().setAvgModuleGrade(moduleAverage);


        }

    }

    public static void printAverages()
    {
       int i = 0;
       for (Grade temp : grades )
       {
           System.out.println(temp.getStudent().toString());
           System.out.println(temp.getModule().toString());
           i++;
       }

    }

    public static void main(String[] args) {



        Module m1 = new Module("CIS2344",76);
        Module m2 = new Module("CIS2201",82);
        Module m3 = new Module("CIS2208",90);
        Module m4 = new Module("CIS2313",64);
        Module m5 = new Module("CIS2601",58);
        Collections.addAll(modules,m1,m2,m3,m4,m5);


        Student s1 = new Student("U0000001",70);
        Student s2 = new Student("U0000002",65);
        Student s3 = new Student("U0000003",84);
        Student s4 = new Student("U0000004",74);
        Student s5 = new Student("U0000005",77);
        Collections.addAll(students,s1,s2,s3,s4,s5);


        Grade g1 = new Grade(s1,m1,72);
        Grade g2 = new Grade(s2,m2,85);
        Grade g3 = new Grade(s3,m3,77);
        Grade g4 = new Grade(s4,m4,48);
        Collections.addAll(grades,g1,g2,g3,g4);

        printAverages();
        insertGrade(s5,m5,38);
        deleteGrade(g1,s1,m1);
        updateGrade(g3,s3,m3,42);
        recalculateAverage(g2,s2,m2);
        printAverages();


    }



}
