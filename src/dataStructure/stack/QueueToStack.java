package dataStructure.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列做栈
 * 思路：一个队列实现栈，详见push方法
 */
public class QueueToStack {

    private Queue<Integer> queue;

    public void MyStack() {
        queue = new LinkedList<>();
    }

    //5->1->2->3->4
    //3->4->5->1->2
    //1->2->3->4->5
    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while (cnt-- > 1) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
//cnt: count
//ret: result
