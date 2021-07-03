package algorithm.dynamicProgrammingDP.gitHub200.matrixPath;

import java.util.Arrays;

/**
 * 矩阵的总路径数
 * 统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
