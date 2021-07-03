package dataStructure.listNode;

//寻找两个链表的交点
public class GetIntersectionNodeTT {
    public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}
