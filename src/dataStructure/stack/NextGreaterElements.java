package dataStructure.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 循环数组中比当前元素大的下一个元素
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 *              The number 2 can't find next greater number;
 *              The second 1's next greater number needs to search circularly, which is also 2.
 * 思路：思路同上一题，在数组中寻找符合一定条件的元素，使用一个index向后遍历数组，使用栈来存储暂时不符合条件的元素
 *      这类题目有几个显著特征
 *      一、在数组中寻找符合一定条件的元素
 *      二、使用栈来存储暂时不符合条件的元素
 *      三、for() {//向后遍历元素，栈中存着前一位元素和其他未处理的元素，每一轮循环都使用当前的元素对栈中的元素进行处理
 *          while() {//处理栈中所有符合条件的元素
 *              处理元素，并存入结果集
 *          }
 *          将当前元素添加进栈，在下一轮循环中进行处理
 *      }
 */
public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        //next结果集
        int[] next = new int[n];
        //数组填充
        Arrays.fill(next,-1);
        //临时栈，存放待处理元素的索引
        Stack<Integer> pre = new Stack<>();
        //for循环，i<n*2，保证能循环两边
        for (int i = 0; i < n * 2; i++) {
            //取出当前待比较元素
            //'%'取余，'/'整除，i%n保证i的范围在[0,n]之间
            int num = nums[i % n];
            //如果栈pre是空的，且数组[栈顶元素]小于当前元素，则进入while语句
            while (!pre.isEmpty() && nums[pre.peek()] < num) {
                //如果符合条件则将当前元素存入结果集
                next[pre.pop()] = num;
            }
            //如果此时的i比n小，则说明还在第一遍循环
            if (i < n){
                //则将i压入栈中
                pre.push(i);
            }
        }
        return next;
    }
}
