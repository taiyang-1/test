/**
 * @author lyf
 */
public class Teacher extends Person{
private double salary;

    public Teacher(String name ,int age,double salary) {
        super(name, age);
        this.salary = salary;
    }
    public Teacher(){}


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void show() {
        System.out.println(getName() + getAge() +" " + salary);
    }
}
