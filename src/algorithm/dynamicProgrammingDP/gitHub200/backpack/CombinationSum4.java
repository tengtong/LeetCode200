package algorithm.dynamicProgrammingDP.gitHub200.backpack;

import java.util.Arrays;

/**
 * 组合总和
 * nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Therefore the output is 7.
 * 涉及顺序的完全背包。
 */
//TODO
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maximum = new int[target + 1];
        maximum[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
                maximum[i] += maximum[i - nums[j]];
            }
        }
        return maximum[target];
    }
}
