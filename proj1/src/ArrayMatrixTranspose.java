import java.util.Scanner;

/**
 * @author lyf
 */
//二维数据，矩阵转换
public class ArrayMatrixTranspose {
//    public static void main(String[] args) {
//        int[][]a = new int[3][3];
//        int num = 1;
//        for(int i = 0; i<3; i++) {
//            for (int j = 0; j < 3; j++) {
//                a[i][j] = num ;
//                num++;
//            }
//        }
//        for(int i = 0; i<3; i++){
//            for(int j = 0; j<3; j++){
//                System.out.print(a[i][j] + " ");
//                }
//            System.out.println("");
//        }
//        //矩阵转换
//        int[][]b = transposeArray(a);
//    }
//
//    public static int[][] transposeArray(int[][]a){
//        int temp = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = i +1; j < 3; j++) {
//                temp = a[i][j];
//                a[i][j] = a[j][i];
//                a[j][i] = temp;
//            }
//        }
//        for(int i = 0; i<3; i++){
//            for(int j = 0; j<3; j++){
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }return a;
//    }
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入矩阵的行数：");
    int row = scanner.nextInt();
    System.out.println("请输入矩阵的列数：");
    int col = scanner.nextInt();
    int[][]a = new int[row][col];
    int num = 1;
    for(int i = 0; i<row; i++) {
        for (int j = 0; j < col; j++) {
            a[i][j] = num ;
            num++;
        }
    }
    for(int i = 0; i<row; i++){
        for(int j = 0; j<col; j++){
            System.out.print(a[i][j] + " ");
        }
        System.out.println("");
    }
    //矩阵转换
    int[][] b = transposeArray(a);
}

    public static int[][] transposeArray(int[][]a){
        int rows = a.length;        // 获取原矩阵的行数
        int cols = a[0].length;     // 获取原矩阵的列数

        // 创建转置矩阵(行列互换)
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               transposed[j][i] = a[i][j];
            }
        }
        for(int i = 0; i<cols; i++){
            for(int j = 0; j<rows; j++){
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }return transposed;
    }
}
