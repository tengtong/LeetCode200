package dataStructure.listNode;

/**
 * 交换链表中的相邻节点
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 空间复杂度O(1)，不能修改val值
 * 思路：两个一组，1和2，3和4，交换位置，递归
 */
public class SwapPairs {
    public ListNode swapPairs (ListNode head) {
        //创建一个val为-1的临时节点
        ListNode node = new ListNode(-1);
        //临时节点接在head前面
        node.next = head;
        //前驱节点，用于记录
        //因为这里要交换两个节点，pre->l1->l2改成pre->l2->l1，故需要操作包括前驱节点的3个节点
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            //（交换节点）next指针是记录下一个pre
            //pre->1->2, pre->2->1
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;
            //重新pre
            pre = l1;
        }
        return node.next;
    }
}
