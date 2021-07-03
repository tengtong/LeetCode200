package algorithm.dynamicProgrammingDP.gitHub200.fibonacci;

/**
 * 信件错排
 * 题目：有N个信和信封，它们被打乱，求错误装信方式的数量
 *
 * 思路：
 * 动态规划，dp[i]表示前i个信和信封的错误方式数量
 * 假设前i个信装到第j个信封里面，而第j个信装到第k个信封里面。根据i和k是否相等，有两种情况：
 * （1）i==k，交换i和j的信后，它们的信和信封在正确的位置，但是其余i-2封信有dp[i-2]种错误装信的方式，
 *     由于j有i-1种取值，因此共有(i-1)*dp[i-2]种错误装信方式
 * （2）i!=k，交换i和j的信后，第i个信和信封在正确的位置，其余i-1封信有dp[i-1]种错误装信方式，
 *     由于j有i-1种取值，因此共有(i-1)*dp[i-1]种错误装信方式
 *  故综上，错误装信方式共有：dp[i] = (i-1) * dp[i-2] + (i-2) * dp[i-1]
 */
public class LetterStaggered {
    public int letterStaggred (int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = (i-1) * dp[i-2] + (i-2) * dp[i-1];
        }
        return dp[n+1];
    }
}
