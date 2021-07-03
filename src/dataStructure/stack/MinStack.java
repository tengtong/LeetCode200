package dataStructure.stack;

import java.util.Stack;

/**
 * 最小值栈
 * 一个能使用getMin方法可以获取到当前元素
 * 思路：这里用一个统计最小值的栈来辅助
 *      每插入一个元素时，就实时统计当前栈中最小的元素插入minStack，位置与dataStack栈中元素位置一一对应
 */
public class MinStack {

    //定义属性
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    //初始化所有属性
    public void minStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        dataStack.add(x);
        min = Math.min(min, x);
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
