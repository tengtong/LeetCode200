package algorithm.dynamicProgrammingDP.jiuZhang.coordinate1;

// 63. 不同路径 II
public class UniquePathsII {

    // 方法一：动态规划
    // 思路：在unique Paths的基础上，在矩阵中出现了障碍物坐标的情况，行走依旧向下或者向右
    //      有障碍物的为1，空的为0
    //      分如下几类情况讨论：
    //      1、如果[0][0]和[row-1][col-1]位置上有障碍物，则无法到达目的地，return 0
    //      2、如果i==0||j==0的位置上为有障碍物，则i==0||j==0整条路径上都无法走
    //      3、[i][j]是由[i-1][j]和[i][j-1]上走过来，如果该位置上有障碍物，则此路不通
    // 通过率：33/41，边界情况没考虑好
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        // dp[i][j]表示从坐标[0][0]到坐标[i,j]的不同路径数
        int[][] dp = new int[row][col];
        // 先考虑0行0列的特殊情况
        if (row == 0 || col == 0) {
            return 0;
        }
        // 如果初始和终点位置上有障碍物，则无法到达
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }
        // 要对边界情况特殊考虑，不然直接判断会数组下标溢出
        dp[0][0] = 1;
        // i == 0
        for (int j = 1 ; j < col; ++j) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }
        // j == 0
        for (int i = 1; i < row; ++i) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                // 对矩阵中间位置进行考虑
                if (obstacleGrid[i - 1][j] == 1) {
                    dp[i][j] = dp[i][j - 1];
                } else if (obstacleGrid[i][j - 1] == 1) {
                    dp[i][j] = dp[i - 1][j];
                } else if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    // 方法二：动态规划（优解版）
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        //获取网格的长宽
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        if (row == 0 || col == 0) {
            return 0;
        }
        // dp[i][j]表示从[0,0]到[i][j]的不同路径数（子问题）
        int[][] dp = new int[row][col];
        int i, j;
        // 这个for循环计算当前状态dp[i][j]的结果
        for (i = 0; i < row; ++i) {
            for (j = 0; j < col; ++j) {
                // 先判断障碍物的情况
                if (obstacleGrid[i][j] == 1) {
                    // 有障碍物，到[i][j]无法达到，此路不通，也就没有路径数
                    dp[i][j] = 0;
                    continue;
                }
                // 再判断位置是出发点的情况
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                // 这里将上和左两个维度分开考虑，有左边加左边，有上边加上面，则不需要对边界情况进行单独考虑
                dp[i][j] = 0;
                // 有上边，加上边
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                // 有左边，加左边
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsII test = new UniquePathsII();
        System.out.println(test.uniquePathsWithObstacles1(arr));
    }
}
