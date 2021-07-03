package dataStructure.arrayAndMatrix;

/**
 * 找到数组中最长的连续1
 * 给定一个二进制数组，计算其中最大的1的个数
 * intput: [1,1,0,1,1,1]
 * output: 3
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        //max最大长度，cur当前长度
        int max = 0, cur = 0;
        //只遍历一次，逐个元素统计（动态规划）
        //如果当前元素==0，将该cur置为0，
        for (int x : nums) {
            //我之前在纠结两个两段连续的1，只用一个变量cur统计的问题
            //但实际上这两者是不连续的，不会出现统计第一个段的时候，也需要统计第二段的情况
            //也就是只有在第一段统计完，遇到0断开之后才会需要统计第二段，故成立
            //而且用当前元素的值，来统计连续变量的值，确实之前没用过
            cur = x == 0 ? 0 : cur + 1;
            /* if(x==0) {
             *   cur = 0
             * } else {
             *   cur++;
             * }
             */
            max = Math.max(max, cur);
        }
        return max;
    }
}
