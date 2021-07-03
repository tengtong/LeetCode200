package dataStructure.listNode;

/**
 * 归并两个有序链表
 * 递归法
 * 总结：链表的递归法，对整条链表的操作和小节点的操作相同则可以使用递归循环
 */
public class MergeTwoListsTT {
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        //截止条件
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
