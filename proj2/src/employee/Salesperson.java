package employee;

/**
 * @author lyf
 */
public class Salesperson extends Employee implements Bonus{
private double salesAmount;
private double commissionRate;

    public Salesperson() {}

    public Salesperson(int id, String name, double baseSalary, double salesAmount, double commissionRate) {
        super(id, name, baseSalary);
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }

    @Override
    public double calcBonus() {
        double bonus = salesAmount * commissionRate;
        return bonus;
    }

    @Override
    public void work() {
        System.out.println(getName() +"销售"+"业绩"+salesAmount);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("销售额："+salesAmount+"，提成率："+commissionRate);
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
