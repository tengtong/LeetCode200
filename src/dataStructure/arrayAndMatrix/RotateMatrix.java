package dataStructure.arrayAndMatrix;

import java.util.Arrays;

/**
 * 顺时针打印矩阵(原旋转矩阵)
 * 思路：从外层到内，顺时针方向遍历矩阵
 */
public class RotateMatrix {
    //方法一：双for循环，交换四个角落的元素位置
    public static void solution(int[][] matrix, int matrixSize, int matrixColSize){
        int i,j,temp;
        for(i=0;i<matrixSize/2;i++){
            for(j=i;j<matrixColSize-i-1;j++){
                //交换四个角落的元素位置
                temp=matrix[i][j];
                matrix[i][j]=matrix[matrixSize-j-1][i];
                matrix[matrixSize-j-1][i]=matrix[matrixSize-i-1][matrixColSize-j-1];
                matrix[matrixSize-i-1][matrixColSize-j-1]=matrix[j][matrixColSize-i-1];
                matrix[j][matrixColSize-i-1]=temp;
            }
        }
    }
    //方法二：先转置，再交换列
    public static void solution2(int[][] matrix) {
        int n = matrix.length;
        //转置矩阵，矩阵行列互换
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {//交换matrix[j][i]和matrix[i][j]
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        //翻转每一行
        for (int i = 0; i < n; i++) {//int[行][列]
            for (int j = 0; j < n / 2; j++) {//对称交换列
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int [][] arrs = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("行row:"+arrs.length);//{{},{},{}}数组里面有三个元素，每个元素都是一个数组，打印也是一个个元素往下打印
        System.out.println("列col:"+arrs[0].length);
        System.out.println("---------");
        for (int[] arr:arrs){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("---------");
        RotateMatrix.solution(arrs,arrs.length,arrs[0].length);
        for (int[] arr:arrs){
            System.out.println(Arrays.toString(arr));
        }
    }
}
