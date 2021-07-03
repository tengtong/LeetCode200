package dataStructure.arrayAndMatrix;

import java.util.Arrays;

//顺时针打印矩阵
class PrintMatrix {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] matrix = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                matrix[i][j] = sc.nextInt();
//            }
//        }
        int[][] matrix2 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] ret = PrintMatrix.niShiZhenDaYin(matrix2);
        System.out.println(Arrays.toString(ret));
    }

    //顺指针打印矩阵
    //思路：用一个辅助矩阵记录已经走过的路径，用元素总数当作移动的总次数，并定义一个方向矩阵用于记录下次需要修改的方向（类同bfs）
    private static int[] shunShiZhenDaYin (int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[][] helper = new boolean[n][m];
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int total = n * m;
        int[] ret = new int[total];
        int row = 0, col = 0;
        int nextRow = 0, nextCol = 0;
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            ret[i] = matrix[row][col];
            helper[row][col] = true;
            //每次移动前都判断一下是否需要移向，即判断一下下一个坐标的是否出界或者helper[nextRow][nextCol]==true
            nextRow = row + direction[directionIndex][0];
            nextCol = col + direction[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || helper[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;//因为每次专向都是固定的，所以只要按direction[]数组的顺序进行转向就可以了
            }
            row += direction[directionIndex][0];
            col += direction[directionIndex][1];
        }
        return ret;
    }

    //逆时针打印矩阵
    private static int[] niShiZhenDaYin (int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[][] helper = new boolean[n][m];
        int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int total = n * m;
        int[] ret = new int[total];
        int row = 0, col = 0;
        int nextRow = 0, nextCol = 0;
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            ret[i] = matrix[row][col];
            helper[row][col] = true;
            //每次移动前都判断一下是否需要移向，即判断一下下一个坐标的是否出界或者helper[nextRow][nextCol]==true
            nextRow = row + direction[directionIndex][0];
            nextCol = col + direction[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || helper[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;//因为每次专向都是固定的，所以只要按direction[]数组的顺序进行转向就可以了
            }
            row += direction[directionIndex][0];
            col += direction[directionIndex][1];
        }
        return ret;
    }
}