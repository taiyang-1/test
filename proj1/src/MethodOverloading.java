/**
 * @author lyf
 */
public class MethodOverloading {
    public static void main(String[] args) {
        double a = max(1,2);
        System.out.println(a);

        double b = max(1,2,3);
        System.out.println(b);

        String c = concat("hello", "world");
        System.out.println(c);

        String d = concat("hello", "world", "java");
        System.out.println(d);

        String e = concat("hello", 1);
        System.out.println(e);

    }
    public static double max(double a ,double b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    public static double max(double a ,double b,double c){
        double max1 = max(a,b);
        double max2 = max(max1,c);
        return max2;
    }

    public static String concat(String a, String b) {
        return a + b;
    }
    public static String concat(String a, String b, String c) {
        return a + b + c;
    }
    public static String concat(String a, int b) {
        return a + b;
    }
}
