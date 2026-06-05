/**
 * 泛型方法 + 泛型接口
 * @author lyf
 */

// 1. 自定义泛型接口
interface MyComparable<T> {
    int compareTo(T other);
}

// 2. 让 String 实现这个接口（用内部类包装）
class MyString implements MyComparable<MyString> {
    String value;

    MyString(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(MyString other) {
        return this.value.length() - other.value.length();
    }
}

public class GenericDemo2 {


    // 泛型方法：打印任意数组
    public static <T> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    // 泛型方法：交换数组元素
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // 测试 printArray
        Integer[] intArr = {1, 2, 3, 4, 5};
        System.out.print("intArr: ");
        printArray(intArr);

        String[] strArr = {"张三", "李四", "王五"};
        System.out.print("strArr: ");
        printArray(strArr);

        // 测试 swap
        swap(strArr, 0, 2);
        System.out.print("swap后 strArr: ");
        printArray(strArr);

        // 测试自定义泛型接口
        MyString s1 = new MyString("abc");
        MyString s2 = new MyString("hello");
        System.out.println("比较结果: " + s1.compareTo(s2));  // 3 - 5 = -2
    }
}
