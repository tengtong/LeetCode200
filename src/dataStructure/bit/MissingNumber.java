package dataStructure.bit;

/**
 * 找出数组中缺失的那个数
 * Input: [3,0,1]
 * Output: 2
 * 题目描述：数组元素在 0-n 之间，但是有一个数是缺失的，要求找到这个缺失的数
 */
//TODO
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ nums.length;
    }
}
