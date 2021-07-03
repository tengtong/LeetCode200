package algorithm.dynamicProgrammingDP.gitHub200.array;

/**
 * 最长递增子序列
 * 输入: [10,9,2,5,3,7,10,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,10,18]，它的长度是 5。
 */
public class LongestIncSub {
    public static int solution(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];//dp[i]记录的是[0,i]中最长序列的长度
        for (int i=0;i<len;i++){
            int max = 1;
            for (int j=0;j<i;j++){//dp[i]和dp[i-1]统计的最长序列可能不是同一个，故每次都重头开始找
                if (nums[i] > nums[j]) {//这里只要nums[i]>nums[j],那么在j的序列后加上i即可，j的序列前面已经算过了，故dp[j]+1
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        int ret = 0;
        for (int i = 0;i<len;i++){
            ret = Math.max(ret,dp[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,10,18};
        int res = solution(nums);
        System.out.println(res);
    }
}
