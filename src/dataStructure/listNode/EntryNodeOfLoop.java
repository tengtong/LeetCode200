package dataStructure.listNode;

/**
 * 寻找一个有环链表的的环入口结点
 * 用追及问题可以解决
 */
public class EntryNodeOfLoop {
    public ListNode solution(ListNode pHead)
    {
        ListNode fast=pHead;
        ListNode low=pHead;
        //1、先判断特殊情况
        if(fast==null||fast.next==null)
            return null;
        //2、快慢指针，找到相遇点
        while(fast!=null&&fast.next!=null){//如果有环的话node.next就不会为空，如果node.next为空就说明没有环
            fast=fast.next.next;
            low=low.next;
            if(fast==low)//相遇，跳出循环
                break;
        }
        //3、一个从起点开始，一个从相遇点开始，然后重新相遇的点就是环的节点
        low=pHead;
        while(fast!=low){
            fast=fast.next;
            low=low.next;
        }
        return low;
    }
}
