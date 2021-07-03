package dataStructure.arrayAndMatrix;

/**
 * 错误的集合
 * 集合s包含从1到n的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合丢失了一个数字并且有一个数字重复
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回
 * input: nums = [2,1,2,4]
 * output: [2,3]
 * 思路：
 * 最直接的方法就是对数组进行排序，时间复杂度为O(nlogn)
 * 主要思路是通过交换数组元素，使得数组上的元素在正确的位置上，时间复杂度O(n)，空间复杂度O(1)
 */
public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            //[2,1,2,4]
            //i=1时，1的位置上不是1，2的位置上不是2，那么两者交换
            //for循环遍历一遍，即可调整完所有位置
            while (nums[i] != i && nums[nums[i]] != nums[i]) {
                swap(nums, i ,nums[i] - 1);
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            //找到一组即可，因为也只有一组
            if (nums[i] != i) {
                return new int[]{nums[i], i};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
