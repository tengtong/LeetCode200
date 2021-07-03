package dataStructure.stack;

import java.util.Stack;

/**
 * 栈做队列
 * 两个栈实现队列
 * 思路：push时，元素都push到in栈中
 *      pop时，pop out栈中的元素，当且只有out栈中的元素为空时，才一次性将in栈中的所有元素压入out栈中
 */
public class StackToQueue {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int x){ in.push(x); }

    public int pop() {
        if (in.isEmpty() && out.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        in2out();
        return out.pop();
    }

    public int peek() {
        in2out();
        return out.peek();
    }

    //将in栈中的元素转移到out栈中
    //只有当out栈为空时，才将in栈的元素全部转移到out栈中
    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
