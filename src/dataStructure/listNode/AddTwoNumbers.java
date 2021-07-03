package dataStructure.listNode;

import java.util.Stack;

/**
 * 链表求和
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * 思路：同时从后往前遍历两个链表 --> 使用栈存放链表节点
 */
public class AddTwoNumbers {
    /**
     * 链表val值逐个相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        //head为新链表的头节点
        ListNode head = new ListNode(-1);
        int carry = 0;
        //只要l1Stack和l2Stack不为空，就表示有还有节点可以累加
        //carry!=0则表示当l1Stack和l2Stack都为空时，也有进位符需要计算
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            //栈为空，则该位置不存在节点，val用0来做计算
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            //node节点为当前val值累加后的节点
            ListNode node = new ListNode(sum % 10);
            //将node节点加入到head节点之后，实现头插
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    /**
     * 倒序将链表val值存入stack中
     * @param l
     * @return
     */
    private Stack<Integer> buildStack (ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
}
