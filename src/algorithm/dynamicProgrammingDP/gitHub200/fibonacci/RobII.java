package algorithm.dynamicProgrammingDP.gitHub200.fibonacci;

/**
 * 强盗在环形街区抢劫
 * 思路：该问题在原问题的基础上加了头尾相连的规则，那么只要多考虑这一个条件即可
 * 潜规则：抢过的房子已经没钱了，不能再抢一遍；头尾相连，则表示头尾抢劫的时候也不能挨着抢
 */
public class RobII {
    public static int solution(int[] nums){
        //1、处理一些特殊情况
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        //2、把头尾问题转化成为 (一个不包括头，一个不包含尾)的max问题
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n -1));
    }
    private static int helper(int[] nums, int first, int last){
        int[] dp = new int[nums.length];
        dp[first] = nums[first];
        dp[first + 1] = Math.max(nums[first],nums[first+1]);
        for (int i = first+2; i < last+1; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], nums[i-1]);
        }
        return dp[last];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,4,2,5};//2,4,5
        int res = RobII.solution(nums);
        System.out.println(res);
    }
}
