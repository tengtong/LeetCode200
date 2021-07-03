package dataStructure.arrayAndMatrix;

/**
 * 分隔数组
 * 我们将现有的数组分割成几个“块”，并将这些块在内部重新进行排序，但块与块的顺序不能更换
 * 之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * 求最多能分多少块
 * intput: arr = [4,3,2,1,0]
 * output: 1
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation: [1, 0], [2], [3], [4]
 * 思路：[当前, 第一小的元素 0] [当前，第二小的元素] [当前，第三小的元素] ...
 *      确定右区间：每找到数组中第i小的元素的位置，就是当前块的后区间，就分到第i块
 *
 *      [nums[0], ...] [比nums[0]大的元素，...] ...
 *      确定左区间：把当前元素当作前区间，然后直到找到比其还大的元素，以比其他的元素作为新区间的左区间，继续后续寻找
 *      ?[4,3,8,1,0] => [4,3] [8,1,0]
 */
public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null) return 0;
        int ret = 0;
        int right = arr[0];
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (right == i) {
                ret++;
            }
        }
        return ret;
    }
}
