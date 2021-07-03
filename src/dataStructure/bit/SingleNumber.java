package dataStructure.bit;

/**
 * 数组中唯一一个不重复的元素
 * Input: [4,1,2,1,2]
 * Output: 4
 * 两个相同的数异或的结果为 0，对所有数进行异或操作，最后的结果就是单独出现的那个数。
 */
//TODO
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) ret = ret ^ n;
        return ret;
    }
}
