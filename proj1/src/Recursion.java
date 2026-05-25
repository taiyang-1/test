import java.util.Scanner;

/**
 * @author lyf
 */
//递归  方法调用自己
public class Recursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字：");
        int n = scanner.nextInt();
        int result = factorial(5);
        System.out.println(result);
    }
    public static int factorial(int n ){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }


}
