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

        System.out.println("(fib)请输入数字: ");
        int m = scanner.nextInt();
        int result2 = fib(m);
        System.out.println(result2);


    }
    public static int factorial(int n ){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static int fib(int m ){
        if(m==0){
            return 0;
        }else if(m==1){
            return 1;
        }else{
            return fib(m-1)+fib(m-2);
        }

    }


}
