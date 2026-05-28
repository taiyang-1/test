package employee;

/**
 * @author lyf
 */
public class Main {
    public static void main(String[] args) {
        Employee[] arr = new Employee[5];
        arr[0] = new Manager(1,"张三",15000,"IT",10);
        arr[1] = new Manager(2,"李四",8000,"HR",20);
        arr[2] = new Salesperson(3,"王五",30000,100000,0.01);
        arr[3] = new Programmer(4,"赵六",11000,"java",5);
        arr[4] = new Programmer(5,"老七",10000,"python",6);
        CompanyUtil.printAll(arr);
        System.out.println();
        System.out.println("奖金合计："+CompanyUtil.totalBonus(arr));
        System.out.println();
        CompanyUtil.trainAll(arr);
        System.out.println();
        CompanyUtil.sortBySalary(arr);
        CompanyUtil.printAll(arr);
    }
}
