package Practical_12;

public class Module {
    private String moduleID;
    private int avgModuleGrade;

    public Module(String moduleID, int avgModuleGrade) {
        this.moduleID = moduleID;
        this.avgModuleGrade = avgModuleGrade;
    }

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public int getAvgModuleGrade() {
        return avgModuleGrade;
    }

    public void setAvgModuleGrade(int avgModuleGrade) {
        this.avgModuleGrade = avgModuleGrade;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleID='" + moduleID + '\'' +
                ", avgModuleGrade=" + avgModuleGrade +
                '}';
    }
}
