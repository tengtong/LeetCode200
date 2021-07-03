package algorithm.binarySearch;

/**
 * 查找区间
 * 给定一个有序数组nums和一个目标target，要求找到target在nums中的第一个位置和最后一个位置
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 可以用二分查找找出第一个位置和最后一个位置，但是寻找的方法有所不同，需要实现两个二分查找
 * 我们将寻找target最后一个位置，转换成寻找target+1第一个位置，再往前移动一个位置。这样我们只需要实现一个二分查找代码即可
 * 即最后一个8的位置==第一个9的位置-1
 *
 * 在寻找第一个位置的二分查找代码中，需要注意h的取值为nums.length，而不是nums.length-1
 * nums = [2,2], target = 2
 * 如果h的取值为nums.length-1，那么last=findFirst(nums, target+1)-1=1-1=0
 * 这是因为findLeft只会返回[0,nums.length-1]范围的值，对于findFirst([2,2],3)
 * 我们希望返回3插入nums中的位置，也就是数组最后一个位置再往后一个位置，即 nums.length
 * 所以我们需要将h取值为nums.length，从而使得findFirst返回的区间更大，能够覆盖target大于nums最后一个元素的情况
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length; //注意 h 的初始值
        while (l < h) {
            int m = l + (h - l) / 2;
            //找他的最左侧一个元素，修改右区间，hig
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
