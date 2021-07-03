package algorithm.dynamicProgrammingDP.gitHub200.array;

/**
 * 数组区间和
 * 给定 nums = [-2,0,3,-5,2,-1], i, j，求出index从i到j的元素之和
 */
public class RangeArray {
    public static int solution(int[] nums,int begin,int end){
        int[] dp = new int[nums.length];//dp[i]表示到坐标[0,i]区间的和
        dp[0] = nums[0];
        for (int i = 1;i < nums.length;i++){
            dp[i] = dp[i-1] + nums[i];
        }
        return dp[end] - dp[begin] + nums[begin];
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        int res = RangeArray.solution(nums,1,3);
        System.out.println(res);
    }
}
