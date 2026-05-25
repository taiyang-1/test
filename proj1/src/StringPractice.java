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
}
