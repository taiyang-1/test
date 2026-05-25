/**
 * @author lyf
 */
//类型转换
public class TypeConversion {
    public static void main(String[] args) {

//        int a = 1;
//        double b = 3.13;
//        char c = 'a';
//        boolean d = true;
//
//
//        //自动转换
//        double conversionA = a;
//        System.out.println(conversionA);
//
//        //强制转换
//        int conversionB = (int)b;
//        System.out.println(conversionB);
//
//       //char类型转换为int类型
//
//        int conversionC = (int)c;
//        System.out.println(conversionC);

        String str = "hello";
        System.out.println(str.length());
        System.out.println(str.charAt(2));
        System.out.println(str.indexOf('o'));
        System.out.println(str.lastIndexOf('o'));
        System.out.println(str.substring(2));
        System.out.println(str.substring(2,4));
        System.out.println(str.equals("hello"));
        System.out.println(str.equalsIgnoreCase("Hello"));

    }
}
