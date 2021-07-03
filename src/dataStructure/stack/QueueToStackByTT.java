package dataStructure.stack;

import java.util.Queue;

/**
 * 队列做栈
 * 思路：两个队列实现栈，详见push方法
 *      每有一个新的元素插入，就调整一次队列
 *      1->2->3
 *      4
 *      ==>
 *      null
 *      1->2->3->4
 *      就和蜘蛛卡牌一样，如果插入两个元素之后再调整，那么两个队列就调整不过来了，需要共3个队列才能腾出一个只存放最大值的队列
 */
public class QueueToStackByTT {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.add(x);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
        }
        if (queue2.isEmpty()) {
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
        }
    }

    public int pop() {
        if (queue1.isEmpty()) {
            return queue2.remove();
        } else {
            return queue1.remove();
        }
    }

    public int top() {
        if (queue1.isEmpty()) {
            return queue2.peek();
        } else {
            return queue1.peek();
        }
    }

    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return false;
        }
        return true;
    }
}
