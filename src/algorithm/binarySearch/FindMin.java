package algorithm.binarySearch;

/**
 * 旋转数组的最小数字
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转
 * 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]，请找出其中最小的元素。
 * Input: [3,4,5,1,2]
 * Output: 1
 * 思路：二分查找，直接根据 元素左侧和右侧大小比较 就可以直接查找出来，直接设置查找条件即可
 */
public class FindMin {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            //因为h最初始是最右侧的元素，因为经过旋转，最右侧的元素一定不是最大的
            //而最小的元素一定在最右侧元素的左序列上
            //故，如果若nums[m]<=nums[h]，即中间值比最右侧值小，则往左缩减区间，最小值在[l, mid]之间
            if (nums[m] <= nums[h]) {
                h = m;
            } else {//若nums[m]>nums[h]，即中间值比右侧值大，则向右缩减区间，最小值在[mid+1, h]之间
                l = m + 1;
            }
        }
        return nums[l];
    }
}
