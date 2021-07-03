package algorithm.dynamicProgrammingDP.gitHub200.longestIncSub;

import java.util.Arrays;

/**
 * 一组整数对能够构成的最长链
 * 对于(a,b)和(c,d)，如果b<c，则它们可以构成一条链
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 */
public class FindLongestChain {
    // 求最长数对链长度
    // 方法一：类同最长递增子序列
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        // 这里没有要求是最长子序列，可以回头找链节串起来，故先排序
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int n = pairs.length;
        // dp[i]表示以pairs[i]为结尾的最长数组
        int[] dp = new int[n];
        // 给所有dp值赋1
        Arrays.fill(dp, 1);
        // pairs[i][0]为当前需要处理的元素
        for (int i = 1; i < n; i++) {
            // pairs[j][1]为i之前的序列
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
