package dataStructure.listNode;

/**
 * 删除当前链表中重复的节点
 */
public class DeleteDuplicatesTT {
    public ListNode deleteDuplicates (ListNode head) {
        //截止条件
        //因为递归操作中涉及到head.next.val，故必须保证head.next也不能为空
        //若head.next==null，则返回head，不返回null
        if (head == null || head.next == null) return head;
        //递归入口
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
