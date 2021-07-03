package dataStructure.listNode;

import java.util.List;

/**
 * 反转链表
 */
public class ReverseList {

    /**
     * 递归（递归只要写一层操作就可以了，然后把截止条件理清楚，整个中间流程就自动的完成，不需要向面向过程变成一样把每一步的流程都写清楚）
     * @method：reversrList，完成对head节点及之后节点的反转
     * @param head
     * @return
     */
    public ListNode reverseList (ListNode head) {
        //截止条件
        if (head == null || head.next == null) {
            return head;
        }
        //定义next节点
        ListNode next = head.next;
        //reverserList方法：完成对next节点以及之后的节点完成反转
        //那么剩下只要对head节点和next节点完成反转，就完成了对所有节点的反转
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 头插法
     * 原链表的 head 节点就是新链表的末尾节点
     */
    public ListNode reverseList2 (ListNode head) {
        //newHead 是反转后链表的头节点
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            //(保存next节点)定义 next 节点，用于保存 head 节点的下一个节点
            ListNode next = head.next;
            //(修改head节点的后驱节点)重置 head.next 完成head节点的反转操作
            head.next = newHead.next;
            //head 节点也就是新链表的末尾节点
            //(在修改head)newHead节点就是把head节点当作新链表的末尾节点，然后不断的向前插入，即头插法
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }

    /**
     * 非递归版
     * 拆解链表，逐个节点反转
     */
    public ListNode solution(ListNode head) {
        if(head == null){//先处理特殊情况
            return head;
        }
        //这里先创建preNode、nextNode，方便建立逻辑，操作中只要把节点放到对应的变量中即可，变量之间的逻辑不会变换
        //这里 =null 是因为，要保持倒序后链包的尾指针为null
        ListNode preNode = null;
        ListNode nextNode = null;
        //遍历链表
        while(head != null) {
            //实现了链表断开，Node.next从指向nextNode换成指向preNode
            //这里先更新NextNode是因为需要先保存.next后续的节点，不然后面把head.next节点指向preNode，后续的节点会丢失
            //保存原来的下一位指针
            nextNode = head.next;
            //实现翻转逻辑
            head.next = preNode;
            //更新链表中节点的下标，整体后移一位
            //这里的更新是先更行preNode指针，是因为我们更新链表下标的顺序是从前往后，故所以先更新前面的指针
            //更新preNode
            preNode = head;
            //更新head
            head = nextNode;
        }
        //最终是放在preNode上
        return preNode;
    }
}
