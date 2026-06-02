import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author lyf
 */
public class MathDemo {
    public static void main(String[] args) {
        double db = Math.random()*100;
        System.out.println((int)db);
        System.out.println(Math.pow(2,10));

        BigInteger a = new BigInteger("12345678901234567890");
        BigInteger b = new BigInteger("98765432109876543210");
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));

        BigDecimal c = new BigDecimal("0.1");
        BigDecimal d = new BigDecimal("0.2");
        System.out.println(c.add(d));
    }
}
