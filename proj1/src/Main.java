import java.util.Scanner;

/**
 * @author lyf
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 10000;
        String details = "收支\t账户金额\t收支金额\t说    明\n";
        details += "\t" + total + "\t\t\t初始金额\n";
        while (true) {
            System.out.println("===家庭收支明细===");
            System.out.println("===1.收支明细===");
            System.out.println("===2.登记收入===");
            System.out.println("===3.登记支出===");
            System.out.println("===4.退出===");
            System.out.println("请选择1-4：");
            char c = Utility.readMenuSelection();
            switch (c) {
                case '1':
                    System.out.println("==当前收支明细==");
                    System.out.println(details);
                    break;
                case '2':
                    System.out.println("登记收入");
                    System.out.println("本次收入金额：");
                    int income = Utility.readNumber();
                    System.out.println("本次收入说明：");
                    String incomeDetails = Utility.readString();
                    total += income;
                    details += "收入\t" + total + "\t\t" +
                            income + "\t\t" + incomeDetails + "\n";
                    System.out.println("---------------------登记完成---------------------");
                    break;
                case '3':
                    System.out.println("登记支出");
                    System.out.println("本次支出金额：");
                    int outcome = Utility.readNumber();
                    if (outcome  > total){
                        System.out.println("余额不足");
                        break;
                    }else{
                        System.out.println("本次支出说明：");
                        String outcomeDetails = Utility.readString();
                        total -= outcome;
                        details += "支出\t" + total + "\t\t" +
                                outcome + "\t\t" + outcomeDetails + "\n";
                    }
                    break;
                case '4':
                    System.out.println("退出系统");
                    return;
                default:
                    System.out.println("输入错误");
            }
        }
    }
}
