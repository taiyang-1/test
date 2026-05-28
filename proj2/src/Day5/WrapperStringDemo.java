package Day5;


/**
 * @author lyf
 */
//包装类
public class WrapperStringDemo {
    public static void main(String[] args) {
        String s = Integer.toString(123);
        Integer i = Integer.parseInt("123");
        Integer i1 = 100;
        int i2 = i1;
        String s1 = String.valueOf(1224243421);
        System.out.println(s1.length());
        System.out.println(s1.charAt(2));
        System.out.println(s1.substring(2,5));
        System.out.println(s1.equals("12"));
        System.out.println(s1.indexOf("1"));
        System.out.println(s1.replace("1","2"));

//        for (int j = 0; j < 10000; j++) {
//            s1=s1+"1";
//        }
//        System.out.println(s1);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 10000; j++) {
            sb.append("1");
        }
        System.out.println(sb);
    }
}
