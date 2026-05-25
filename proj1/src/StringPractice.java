/**
 * @author lyf
 */
/*
* String str = "Hello World";

// (1) length() - 获取字符串长度
int len = str.length();  // 11

// (2) charAt(int index) - 获取指定位置的字符
char c = str.charAt(0);  // 'H'

// (3) indexOf(String s) - 查找子串首次出现的位置
int pos = str.indexOf("World");  // 6
int pos2 = str.indexOf("xyz");   // -1 (没找到返回-1)

// (4) lastIndexOf(String s) - 查找子串最后一次出现的位置
String str2 = "abcabc";
int lastPos = str2.lastIndexOf("abc");  // 3

// (5) substring(int start, int end) - 截取子串
String sub1 = str.substring(0, 5);     // "Hello" (不包含end位置)
String sub2 = str.substring(6);        // "World" (从索引6到末尾)

* */
public class StringPractice {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverse(str));

        System.out.println(isPalindrome("abcba"));
        System.out.println(countChar("hello",'l'));

        countChar("huiad19391");
    }
    public static String reverse(String str){
       // return new StringBuilder(str).reverse().toString();
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while(left<right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
//    判断回文
public static String isPalindrome(String str){
    char[] chars = str.toCharArray();
    int left = 0;
    int right = chars.length-1;
    while(left<right){
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
    }
    if(new String(chars).equals(str)){
        return "是回文";
    }else{
        return "不是回文";
}
}
   public static int countChar(String str,char c){
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==c){
                count++;
            }
        }
        return count;
   }

   public static void countChar(String str) {
       int number = 0;
       int c = 0;
       for (int i = 0; i < str.length(); i++) {
           if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
               number++;
           } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'|| str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
               c++;
           }

       }
       System.out.println("数字个数：" + number);
       System.out.println("字母个数：" + c);
   }
    public static void count(String str){
        char[] arr = new char[128];
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            arr[ch]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {                     // 这个位置有记录
                char ch = (char) i;                // 把下标转回字符，97 → 'a'
                System.out.println(ch + " 出现 " + arr[i] + " 次");
            }
        }
    }


}
