package algorithm.dynamicProgrammingDP.gitHub200.array;

import java.util.*;
/**
 * 最大子串之和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums){
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] += Math.max(nums[i-1],0);//如果前一个nums[i]比0大则加上它，否则加0//局部最优解
            res = Math.max(res,nums[i]);//累加值再与自身判断一下，避免累加之后反而变小了
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = sc.nextInt();
        }
        MaxSubArray maxSubArray = new MaxSubArray();
        int res = maxSubArray.maxSubArray(arr);
        System.out.println(res);
    }
}
