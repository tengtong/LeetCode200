package algorithm.dynamicProgrammingDP.gitHub200.arrayInterval;

/**
 * 数组中等差递增子区间的个数
 * intput:A = [0, 1, 2, 3, 4]
 *
 * output: 6
 * [0, 1, 2],
 * [1, 2, 3],
 * [0, 1, 2, 3],
 * [0, 1, 2, 3, 4],
 * [ 1, 2, 3, 4],
 * [2, 3, 4]
 *
 * 思路：列几项，找规律，确定dp[i]
 *      dp[i]表示A[i]为结尾的等差递增子区间的个数
 *      A[i] - A[i-1] == A[i-1] - A[i-2]，那么[A[i-2],A[i-1],A[i]]构成了一个等差递增子区间，
 *      而且以A[i-1]为结尾的自增子区间的后面再加上一个A[i]，一样可以构成新的递增子区间
 *      dp[2] = 1
 *          [0, 1, 2]
 *      dp[3] = dp[2] + 1 = 2
 *          [0, 1, 2, 3]//[0, 1, 2]后面加了个3
 *          [1, 2, 3]//新的区间
 *      dp[4] = dp[3] + 1 = 3
 *          [0, 1, 2, 3, 4]//[0, 1, 2, 3]之后加上了4
 *          [1, 2, 3, 4]//[1, 2, 3]之后加了个4
 *          [2, 3, 4]//新区间
 *      综上，在A[i] - A[i-1] == A[i-1] - A[i-2]时，dp[i] = dp[i-1] + 1
 *          因为递增子区间不一定以最后一个元素为结尾，可以是任意一个元素结尾，因此需要返回dp数组累加的结果
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int total = 0;
        for (int cnt : dp) {
            total += cnt;
        }
        return total;
    }
}
