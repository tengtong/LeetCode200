package algorithm.doublePointer;

/**
 * 判断链表是否有环
 * 快慢指针，判断两个指针是否会相遇
 */
public class HasCycle {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public boolean hasCycle(ListNode head) {
        ListNode fastNode = head.next;
        ListNode slowNode = head;
        if(head == null){
            return false;
        }
        while (fastNode!=null && slowNode!=null && fastNode.next!=null){//链表的循环条件，因为fastNode.next.next，故要多考虑fastNode.next也不能为null
            if(fastNode == slowNode){
                return true;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return false;
    }
}

