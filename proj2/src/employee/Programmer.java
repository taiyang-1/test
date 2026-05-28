package employee;

/**
 * @author lyf
 */
public class Programmer extends Employee implements Bonus{
    private String skill;
    private  int projectCount;
    @Override
    public void work() {
        System.out.println("程序员"+getName()+"正在开发项目，技能是"+skill);
    }

    public Programmer(String skill, int projectCount) {
        this.skill = skill;
        this.projectCount = projectCount;
    }

    public Programmer(int id, String name, double baseSalary, String skill, int projectCount) {
        super(id, name, baseSalary);
        this.skill = skill;
        this.projectCount = projectCount;
    }
    public Programmer() {}

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    @Override
    public double calcBonus() {
        double bonus = getBaseSalary()*0.2 + projectCount*800;
        return bonus;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("技能是"+skill+"，项目数量"+projectCount);
    }
}
