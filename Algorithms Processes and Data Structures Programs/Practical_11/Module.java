package Practical_11;

import java.util.Arrays;

public class Module {

    private String moduleID;
    Student[] classList = new Student[5];
    private int classSize;


    public Module(String moduleID) {
        this.moduleID = moduleID;

    }

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public int getClassSize() {
        return classList.length;
    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    public void enrolStudent(Student student) {
        // make a copy of the array
      classList = Arrays.copyOf(classList,classList.length + 1 );
      // set student in the array
      classList[classList.length - 1] = student;
      //make a temp array which doesn't have the nulls
      Student[] removedNull = Arrays.stream(classList).filter(value -> value!= null && value.toString().length() > 0).toArray(size -> new Student[size]);
      //change that to the array we are using
        classList = removedNull;
        // sort the students
        Arrays.sort(classList);


    }


    public void unenrolStudent(int index) {
        //set the student at that index to null
       classList[index] = null;
        Student[] removedNull = Arrays.stream(classList).filter(value -> value!= null && value.toString().length() > 0).toArray(size -> new Student[size]);
        classList = removedNull;
        Arrays.sort(classList);


    }



    @Override
    public String toString() {
        return "Module{" +
                "moduleID='" + moduleID + '\'' +
                ", classList=" + Arrays.toString(classList) +
                ", classSize=" + classSize +
                "}";
    }
}

