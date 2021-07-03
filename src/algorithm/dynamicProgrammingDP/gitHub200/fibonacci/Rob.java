package algorithm.dynamicProgrammingDP.gitHub200.fibonacci;

/**
 * 强盗抢劫，抢劫一排住户，但是不能抢劫邻近的住户，求最大的抢劫量
 * 动态规划：dp[i]表示抢到第i个住户时的最大抢劫量，因为不能抢劫邻近住户，即抢劫了第i-1个，就不能再抢劫第i个住户
 *         dp[i] = max(dp[i-2] + nums[i], dp[i-1])
 * 总结：为什么动态规划可以避免重复计算，因为子问题的解都放在dp[i]数组里了
 */
public class Rob {
    public static int solution(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);//动态规划通过子问题的最优解来求解父问题的最优解
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,4,2,5};//3,4,5
        int res = Rob.solution(nums);
        System.out.println(res);
    }
}
