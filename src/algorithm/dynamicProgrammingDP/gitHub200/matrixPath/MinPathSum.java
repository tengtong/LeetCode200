package algorithm.dynamicProgrammingDP.gitHub200.matrixPath;

/**
 * 矩阵最小路径和（最值）
 * 题目：求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动
 * input：[[1,3,1],
 *         [1,5,1],
 *         [4,2,1]]
 * output: 7
 * 思路：求出每一步的最优解，累计每一步就是整体的最有解
 */
public class MinPathSum {
    public int solution1(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;//行，统计有几个一维数组
        int col = grid[0].length;//列
        int[] dp = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    dp[j] = dp[j];//只能从上侧走到该位置
                } else if (i == 0) {
                    dp[j] = dp[j - 1];//只能从左侧走到该位置
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[col - 1];
    }

    public int solution2(int[][] grid) {
        //1、先判断特殊情况
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];//dp[i][j]表示从点到右下角的最小路径和
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinPathSum minPathSum = new MinPathSum();
        int res = minPathSum.solution2(grid);
        System.out.println(res);
    }
}
