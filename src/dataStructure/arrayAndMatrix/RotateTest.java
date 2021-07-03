package dataStructure.arrayAndMatrix;

/**
 * 旋转矩阵
 * 先转置矩阵，然后交换列
 * **********************
 * 二维数组
 * int[][] arr == arr[1,2][3,4]
 * 1 3
 * 2 4
 * 故 row = arr.length;
 * col = arr[0].length;
 */
public class RotateTest {
    public void solution(int[][] matrix) {
        //转置矩阵
        int row = matrix.length;//int[][] == int[[],[]],[[],[]];
        int col = matrix[0].length;//这里因为旋转的是正方形，故行列长度一致
        for (int i=0;i<row;i++){
            for (int j=i;j<col;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //交换列
        for (int i=0;i<row;i++){
            for (int j=0;j<col/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col-1-j];
                matrix[i][col-1-j] = temp;
            }
        }

    }
}
