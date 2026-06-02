/**
 * @author lyf
 */
public class StringDemo {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(s.length());
        System.out.println(s.charAt(6));
        System.out.println(s.contains("World"));
        System.out.println(s.replace("l","x"));

        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" ");
        sb.append("World");
        sb.append("!");
        System.out.println(sb.toString());

    }
}
