package algorithm.dynamicProgrammingDP.gitHub200.stringCompilee;

/**
 * 字符串编辑
 */

/**
 * 删除两个字符串的字符使它们相等
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * 可以转换为求两个字符串的最长公共子序列问题。
 */
//TODO
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
