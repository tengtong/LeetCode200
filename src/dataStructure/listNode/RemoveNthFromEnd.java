package dataStructure.listNode;

/**
 * 删除链表的倒数第n个节点
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 思路：设置两个链表，第一个链表从第一个节点出发，第二个链表从第n个节点出发
 *      当第二个链表遍历到末端时，第一个链表到达了倒数第n个节点，对该节点进行删除/拼接前后节点的操作
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        //快节点
        ListNode fast = head;
        //后移n次
        while (n-- > 0) {
            fast = fast.next;
        }
        //如果此时快指针空，表示链表总长为n+1
        if (fast == null) return head.next;
        ListNode slow = head;
        //通过快慢指针找到倒数第n个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //删除倒数第n个节点
        slow.next = slow.next.next;
        return head;
    }
}
