package dataStructure.stack;

import sun.jvm.hotspot.utilities.IntArray;

import java.util.Arrays;
import java.util.Stack;

/**
 * 数组中元素与下一个比它大的元素之间的距离
 * Input: [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * 思路：在遍历数组时用栈把数组中的数存起来，如果当前遍历的数比栈顶元素来的大，说明栈顶元素的下一个比它大的数组就是当前元素
 * 心得：多做题，自然有思路
 */
public class DailyTemperatures {
    //temperatures: [73,74,75,71,69,72,76,73]
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        //2、初始化结果集dist
        //   保证在没有找到符合的条件无法进行计算时，有默认结果0
        int[] dist = new int[n];
        //3、临时栈indexs，栈中存放的是当前待处理元素的index，处理完就pop出
        Stack<Integer> indexs = new Stack<>();
        //4、for循环，循环n次
        for (int curIndex = 0; curIndex < n; curIndex++) {
            //5、每个for循环就运行一个while语句
            //   while（如果栈不是空的 && 数组[cur] > 数组[栈顶元素位置]）
            //   如果满足while条件，表示找到了比当前待处理元素大的元素
            while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
                //栈顶存储的是待处理元素的index，且是前驱节点//而curIndex为当前元素
                int preIndex = indexs.pop();
                //结果集[pre] = i - preIndex
                dist[preIndex] = curIndex - preIndex;
            }
            //6、indexs添加当前i
            indexs.add(curIndex);
        }
        return dist;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] dist = DailyTemperatures.dailyTemperatures(temperatures);
        //打印数组
        System.out.println(Arrays.toString(dist));
    }
}
