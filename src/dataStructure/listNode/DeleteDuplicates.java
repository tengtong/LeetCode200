package dataStructure.listNode;

/**
 * 从有序链表中删除重复的节点
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 思路：设置一个变量记录前一个节点的val值，用于与当前节点的val值对比（非递归版）
 *      对比前后节点的val值（递归版）
 * 总结：树的递归一次是一个二叉节点，即根节点和左、右节点之间的对比和操作
 *      链表的递归一次是当前节点和后驱节点之间的关系
 *      递归，就是对最小单元的一次处理（处理会涉及到与之相关的节点）
 */
public class DeleteDuplicates {
    /**
     * deleteDuplicates，删除以head为头节点链表的中重复的节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates (ListNode head) {
        //截止条件
        if (head == null || head.next == null) return head;
        //(递归入口)删除head.next及之后的节点中重复的节点，然后拼接在head后面
        head.next = deleteDuplicates(head.next);
        //对比一下当前节点和后一个节点的val值，如果相同则继续往后对比，若不相同则记录当前节点
        return head.val == head.next.val ? head.next : head;
    }
}
