package algorithm.dynamicProgrammingDP.gitHub200.backpack;

/**
 * 变种
 * 完全背包：物品数量为无限个
 * 多重背包：物品数量有限制
 * 多维费用背包：物品不仅有重量，还有体积，同时考虑这两种限制
 * 其它：物品之间相互约束或者依赖
 */

/**
 * 划分数组为和相等的两部分
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 划分数组为和相等的两部分
 * 可以看成一个背包大小为 sum/2 的 0-1 背包问题
 */
//TODO
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = computeArraySum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        for (int num : nums) {                 // 0-1 背包一个物品只能用一次
            for (int i = W; i >= num; i--) {   // 从后往前，先计算 dp[i] 再计算 dp[i-num]
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
