package algorithm.dynamicProgrammingDP.gitHub200.backpack;

import java.util.*;

/**
 * 零钱兑换
 * 动态规划可以减少重复计算
 * 输入：coins，硬币的几种面额
 *      amount，总金额
 * 输出：凑成总金额的最少硬币数
 */
public class CoinChange2 {
    public int solution(int[] coins,int amount){
        int max = amount + 1;
        int[] dp = new int[amount+1];//dp[amount]表示
        Arrays.fill(dp,max);//使用max对数组进行充填//属于基本数据结构-数组[]的工具类，与Collections类似
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                dp[i] = Math.min(dp[i],dp[i-coins[j]+1]);
            }
        }
        return dp[amount]>amount?-1:dp[amount];//如果dp[amount]>amount，哪怕硬币面额都是1，也是不合理的，故是无效答案
    }
}
