package Practical_12;

public class Grade {

    private Student student;
    private Module module;
    private int score;

    public Grade(Student student, Module module, int score) {
        this.student = student;
        this.module = module;
        this.score = score;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public int getScore() {
        return score;
    }

    public Grade setScore(int score) {
        this.score = score;
        return null;
    }


}
