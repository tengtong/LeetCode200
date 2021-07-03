package dataStructure.arrayAndMatrix;

/**
 * 有序矩阵查找
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target，该矩阵具有以下特性：
 * 每行的元素从左到右升序排列
 * 每列的元素从上到下升序排列
 * 如果存在返回true，不存在返回false
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //判断特殊情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //[
        //  [ ,2,x],
        //  [ , , ],
        //  [ , , ]
        // ]
        //从x的位置出发，向左或向下寻找
        //且第二排的第一位比第一排的最后一位还要大，故从第一排的最后一位开始寻找合理
        //每一列的最后一个元素都是该行最大元素
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
