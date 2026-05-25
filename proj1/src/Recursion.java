import java.util.Scanner;

/**
 * @author lyf
 */
//递归  方法调用自己
public class Recursion {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("(阶乘)请输入数字：");
//        int n = scanner.nextInt();
//        int result = factorial(5);
//        System.out.println(result);
//
//        System.out.println("(fib)请输入数字: ");
//        int m = scanner.nextInt();
//        int result2 = fib(m);
//        System.out.println(result2);
//
//        System.out.println("(arraySum)请输入数字: ");
//        int[] arr = {1, 2, 3, 4, 5};
//        int result3 = arraySum(arr, arr.length - 1);
//        System.out.println(result3);
        System.out.println( "请输入想要的方法 1 阶乘 2 斐波那契 3 数组求和");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n){
            case 1:
                System.out.println("(阶乘)请输入数字：");
                int a = scanner.nextInt();
                int result = factorial(a);
                System.out.println(result);
                break;
            case 2:
                System.out.println("(fib)请输入数字: ");
                int b = scanner.nextInt();
                int result2 = fib(b);
                System.out.println(result2);
                break;
            case 3:
                System.out.println("(arraySum)请输入理想数组长度，为你随机生成数组: ");
                int[] arr = new int[scanner.nextInt()];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (int) (Math.random() * 10+1);
                }
                System.out.println("生成的数组为：");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i]+" ");
                }
                int result3 = arraySum(arr, arr.length - 1);
                System.out.println(result3);
        }


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
//    arraySum(arr, index) → 递归累加数组中所有元素
public static int arraySum(int[] arr, int index) {
    // 终止条件
    if (index < 0) {
        return 0;
    }

    // 递归调用
    return arr[index] + arraySum(arr, index - 1);
}



}
