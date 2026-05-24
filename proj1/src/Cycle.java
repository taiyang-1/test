import java.util.Scanner;

/**
 * @author lyf
 */
public class Cycle {
    public static void main(String[] args) {
        //打印乘法表
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j));
                System.out.print("\t");
            }
            System.out.println();
        }
        //用while求1-100的和
        int sum = 0;
        int count = 1;
        while (count <= 100) {

            sum = sum + count;
            count++;
        }
        System.out.println(sum);

//    do-while：猜数字游戏（Math.random() 生成1~10，猜中退出）
        int num = (int) (Math.random() * 10 + 1);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            do {
                System.out.println("输入1-10随机一个数");
                int guess = scanner.nextInt();
                if (guess < num) {
                    System.out.println("小了");
                } else if (guess > num) {
                    System.out.println("大了");
                } else {
                    System.out.println("恭喜你,猜对了");
                    break;
                }
            } while (true) ;
            System.out.println("是否继续Y/N");
            String choice = scanner.next();
            if (choice.equals("Y")){
                flag = true;
            }else if(choice.equals("N")){
                flag = false;
                System.out.println("游戏结束");
            }
        }


    }
}
