package dataStructure.arrayAndMatrix;

/**
 * 判断是否为托普利茨矩阵
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是托普利茨矩阵
 * 给你一个mxn的矩阵matrix，如果这个矩阵是托普利茨矩阵，返回true；否则，返回false
 * 1234
 * 5123
 * 9512
 */
public class IsToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        //判断右上三角
        for (int i = 0; i < matrix[0].length; i++) {
            if (!check(matrix, matrix[0][i], 0, i)) {
                return false;
            }
        }
        //判断左下三角
        for (int i = 0; i < matrix.length; i++) {
            if (!check(matrix, matrix[i][0], i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int[][] matrix, int expectValue, int row, int col) {
        //截止条件，表示走完了当前元素的对角线
        if (row >= matrix.length || col >= matrix[0].length) {
            return true;
        }

        //如果当前元素
        if (matrix[row][col] != expectValue) {
            return false;
        }

        //重复性的工作可以写成递归，左上到右下的对角线，相邻元素确实是row+1, col+1
        return check(matrix, expectValue, row + 1, col + 1);
    }
}
