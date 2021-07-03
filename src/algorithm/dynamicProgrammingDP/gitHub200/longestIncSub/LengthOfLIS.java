package algorithm.dynamicProgrammingDP.gitHub200.longestIncSub;

/**
 * 最长递增子序列
 * 已知一个序列 {S1, S2,...,Sn}，取出若干数组成新的序列 {Si1, Si2,..., Sim}
 *     其中 i1、i2 ... im 保持递增，即新序列中各个数仍然保持原数列中的先后顺序，称新序列为原序列的一个子序列
 *     如果在子序列中，当下标ix>iy时，Six>Siy，称子序列为原序列的一个递增子序列 。
 * 定义一个数组 dp 存储最长递增子序列的长度，dp[n] 表示以 Sn 结尾的序列的最长递增子序列长度。对于一个递增子序列 {Si1, Si2,...,Sim}
 * 如果 im < n 并且 Sim < Sn，此时 {Si1, Si2,..., Sim, Sn} 为一个递增子序列，递增子序列的长度增加 1
 * 满足上述条件的递增子序列中，长度最长的那个递增子序列就是要找的，在长度最长的递增子序列上加上 Sn 就构成了以 Sn 为结尾的最长递增子序列。因此 dp[n] = max{ dp[i]+1 | Si < Sn && i < n} 。
 * 因为在求 dp[n] 时可能无法找到一个满足条件的递增子序列，此时 {Sn} 就构成了递增子序列，需要对前面的求解方程做修改，令 dp[n] 最小为 1，即：
 * 对于一个长度为 N 的序列，最长递增子序列并不一定会以 SN 为结尾，因此 dp[N] 不是序列的最长递增子序列的长度，需要遍历 dp 数组找出最大值才是所要的结果，max{ dp[i] | 1 <= i <= N} 即为所求。
 */

import java.util.Arrays;

/**
 * 最长递增子序列
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        return Arrays.stream(dp).max().orElse(0);
    }

/**
 *  使用 Stream 求最大值会导致运行时间过长，可以改成以下形式：
 *  int ret = 0;
 *  for (int i = 0; i < n; i++) {
 *      ret = Math.max(ret, dp[i]);
 *  }
 *  return ret;
 *  以上解法的时间复杂度为 O(N2)，可以使用二分查找将时间复杂度降低为 O(NlogN)
 *  定义一个 tails 数组，其中 tails[i] 存储长度为 i + 1 的最长递增子序列的最后一个元素。对于一个元素 x，
 *      -如果它大于 tails 数组所有的值，那么把它添加到 tails 后面，表示最长递增子序列长度加 1；
 *      -如果 tails[i-1] < x <= tails[i]，那么更新 tails[i] = x。
 *      例如对于数组 [4,3,6,5]，有
 *  tails      len      num
 *  []         0        4
 *  [4]        1        3
 *  [3]        1        6
 *  [3,6]      2        5
 *  [3,5]      2        null
 *  可以看出tails数组保持有序，因此在查找Si位于tails数组的位置时就可以使用二分查找
 */
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(tails, len, num);
            tails[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }
    private int binarySearch(int[] tails, int len, int key) {
        int l = 0, h = len;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (tails[mid] == key) {
                return mid;
            } else if (tails[mid] > key) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

