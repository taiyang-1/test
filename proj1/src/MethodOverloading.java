/**
 * @author lyf
 */
public class MethodOverloading {
    public static void main(String[] args) {
        double a = new MethodOverloading().max(1,2);
        System.out.println(a);

        double b = new MethodOverloading().max(1,2,3);
        System.out.println(b);


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
}
