/**
 * @author lyf
 */
//二维数据，矩阵转换
public class ArrayMatrixTranspose {
    public static void main(String[] args) {
        int[][]a = new int[3][3];
        int num = 1;
        for(int i = 0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = num ;
                num++;
            }
        }
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                System.out.print(a[i][j] + " ");
                }
            System.out.println("");
        }
        //矩阵转换
        int[][]b = transposeArray(a);
    }

    public static int[][] transposeArray(int[][]a){
        int temp = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i +1; j < 3; j++) {
                temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }return a;
    }
}
