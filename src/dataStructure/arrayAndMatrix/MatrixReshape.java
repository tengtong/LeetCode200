package dataStructure.arrayAndMatrix;

/**
 * 改变矩阵维度
 * input: [[1,2],
 *         [3,4]]
 *        r=1, c=4 (将新的矩阵换成1*4的矩阵)
 * output: [[1,2,3,4]]
 */
public class MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        //矩阵的行高，统计二维矩阵中有几个一维矩阵
        int row = nums.length;
        //矩阵的列宽，统计一个一维矩阵中的个数，就是矩阵的列宽
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        //结果集
        int[][] reshapedNums = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                /* 本身取出矩阵中的每个元素需要进行两个for循环来取，普通方法就是先取出来放到一个数组中，然后再用两个for循环赋值
                 * 这里用这条语句nums[index / col][index % col]就可以实现逐个取出所有元素，厉害厉害
                 * index/col取的是第几个一维矩阵
                 * index%col取的是一维矩阵中元素的位置
                 */
                reshapedNums[i][j] = nums[index / col][index % col];
                index++;//i<r,j<c可以保证矩阵中总的元素个数不变
            }
        }
        return reshapedNums;
    }
}
