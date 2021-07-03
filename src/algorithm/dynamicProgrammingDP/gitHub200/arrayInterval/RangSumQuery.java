package algorithm.dynamicProgrammingDP.gitHub200.arrayInterval;

/**
 * 数组区间和
 * Input：[-2, 0, 3, -5, 2, -1]
 * output：
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * 思路：求区间i～j的和，可以转换为sum[j+1]-sum[i]，其中sum[i]为0~i-1的和
 */
public class RangSumQuery {
    private int[] sums;

    public void NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
