package algorithm.dynamicProgrammingDP.gitHub200.splitInteger;

/**
 * 分割整数的最大乘积
 * 给定一个正整数，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化，并返回可获得的最大乘积
 * input: n=2
 * output: 1 (2=1+1，1*1=1)
 * intput: n=10
 * output: 36 (10=3+3+4，3*3*4=36)
 * 思路：dp[i]表示将正整数i拆分获得最大乘积值
 *      当i=0和i=1时，dp[0]=dp[1]=0
 *      当i>=2时，假设正整数i拆分出的第一个正整数j(1<j<i)，则有以下两种方案：
 *          将i拆分成j和i-j，且i-j不再拆分成多个正整数，此时的乘积是j*(i-j)
 *          将i拆分成j和i-j，且i-j继续拆分成多个正整数，此时的乘积是j*dp[i-j]
 *      因此当j固定时，有dp[i]=max(j*(i-j), j*dp[i-j])
 *      因为j的取值范围是[1,i-1]，故需要遍历所有的j值，才能获取到最大的dp[i]
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++){
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - 1], j * (i - 1)));
            }
        }
        return dp[n];
    }
}
