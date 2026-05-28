package employee;

/**
 * @author lyf
 */
public abstract class Employee {
    private int id;
    private String name;
    private double baseSalary;

    public Employee() {
    }

    public Employee(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public void showInfo(){
        System.out.print("id:"+id+" name:"+name+" baseSalary:"+baseSalary);
    }
    public abstract void work();
}
