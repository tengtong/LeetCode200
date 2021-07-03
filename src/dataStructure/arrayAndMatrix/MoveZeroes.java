package dataStructure.arrayAndMatrix;

/**
 * 把数组中的0移动到末尾
 * input: [0,1,0,3,12]
 * output: [1,3,12,0,0]
 * 思路：遍历数组找出'非0'的元素
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        //遍历数组
        for (int num:nums) {
            //如果当前数不为0
            if (num != 0) {
                //idx就是末尾不为0的数的位置//这里直接在原数组上进行修改，减少了空间复杂度
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
