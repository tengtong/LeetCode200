package algorithm.dynamicProgrammingDP.gitHub200.stockTrading;

/**
 * 买卖股票
 * 输入：[7,1,5,3,6,4]
 * 输出: 5
 */
public class MaxProfit0 {
    public int solution(int[] prices) {
        int [] dp = new int[prices.length];//dp：到当前最止能获得的最大利润
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(prices[i] - min, dp[i-1]);//dp[i]的记录可以避免重复计算，从而在更新min不需要再从头进行循环
            min = Math.min(min, prices[i]);
        }
        return dp[prices.length-1];
    }

}
