import java.util.Scanner;

/**
 * @author lyf
 */
//判断闰年
public class JudgeYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("请输入年份：");
            int year = scanner.nextInt();
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                System.out.println(year + "是闰年");
            }else {
                System.out.println(year + "不是闰年");
            }

        }

    }
}
