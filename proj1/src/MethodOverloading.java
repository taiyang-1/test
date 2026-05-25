/**
 * @author lyf
 */
public class MethodOverloading {
    public static void main(String[] args) {
        double a = new MethodOverloading().max(1,2);
        System.out.println(a);

        double b = new MethodOverloading().max(1,2,3);
        System.out.println(b);

        String c = new MethodOverloading().concat("hello", "world");
        System.out.println(c);

        String d = new MethodOverloading().concat("hello", "world", "java");
        System.out.println(d);

        String e = new MethodOverloading().concat("hello", 1);
        System.out.println(e);

    }
    public double max(double a ,double b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    public double max(double a ,double b,double c){
        double max1 = new MethodOverloading(). max(a,b);
        double max2 = new MethodOverloading().max(max1,c);
        return max2;
    }

    public String concat(String a, String b) {
        return a + b;
    }
    public String concat(String a, String b, String c) {
        return a + b + c;
    }
    public String concat(String a, int b) {
        return a + b;
    }
}
