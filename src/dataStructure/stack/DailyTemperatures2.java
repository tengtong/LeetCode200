package dataStructure.stack;

import java.util.Stack;

/**
 *  数组中元素与下一个比它大的元素之间的距离
 *  Input: [73,74,75,71,69,72,76,73]
 *  Output: [1,1,4,2,1,1,0,0]
 *  思路：用栈来存储之前未处理的元素
 */
public class DailyTemperatures2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        //结果集
        int[] dist = new int[n];
        //临时栈
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < temperatures.length; curIndex++){

            //找到比当前元素大时进入while语句
            while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = curIndex - preIndex;
            }
            indexs.add(curIndex);
        }
        return dist;
    }
}
