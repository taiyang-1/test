package Day5;

/**
 * @author lyf
 */
public class ExceptionDemo {

    public int divide(int a, int b) {
        int result = 0;
        try {
            result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } finally {
            System.out.println("结束运算");
        }
        return result;
    }
    public static int getElement(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("索引超出范围");
        }
        return -1;
    }

     public static int parseInt(String s){
         try {
             return  Integer.parseInt(s);
         } catch (NumberFormatException e) {
             System.out.println("字符串格式不正确");
             return -1;
         }

     }
    // T1-4: 多catch — 注意 catch(异常类型 变量名)，变量名不能省
    public static void testMultiCatch() {
        try {
            int x = 10 / 0;           // ArithmeticException
            String s = null;
            s.length();               // NullPointerException（上一行已炸，走不到）
        } catch (ArithmeticException e) {
            System.out.println("捕获：算术异常");
        } catch (NullPointerException e) {
            System.out.println("捕获：空指针");
        }
    }

//     public static void testMultiCatch(){
//         try{
//
//         }catch(ArithmeticException){
//
//         }catch(NullPointerException){
//
//         }
//     }
}
