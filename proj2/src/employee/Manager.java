package employee;

/**
 * @author lyf
 */
public class Manager extends Employee implements Trainable,Bonus{
private String department;
private int teamSize;
    @Override
    public double calcBonus() {
        double Bonus = getBaseSalary()*0.3 + teamSize*500;
        return Bonus;
    }

    @Override
    public void work() {
        System.out.println(getName()+"正在" + getDepartment() + " is working");
    }

    @Override
    public void train() {
        System.out.println(getName()+"正在" + getDepartment() + " is training");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("department:" + department + " teamSize:" + teamSize);
    }

    public Manager(){}

    public Manager(int id, String name, double baseSalary, String department, int teamSize) {
        super(id, name, baseSalary);
        this.department = department;
        this.teamSize = teamSize;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
