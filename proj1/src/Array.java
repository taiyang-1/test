/**
 * @author lyf
 */
public class Array {
    public static void main(String[] args) {
        int array[] = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int)(Math.random()*10+1);
        }
//        找最大值
        int max = array[0];
        for (int i = 0; i < array.length-1 ; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
//        找最小值
        int min = array[0];
        for (int i = 0; i < array.length-1 ; i++) {
            if (array[i]<min)
                min = array[i];
        }
//        平均数
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("最大值="+max);
        System.out.println("最小值="+min);
        System.out.println("总和="+sum);
        System.out.println("平均数="+sum/10);
//        冒泡排序
        int temp =0;
        for (int i = 0; i < array.length-1; i++) {
        for (int j = 0; j < array.length-1-i; j++) {
            if (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }

        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
