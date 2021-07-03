package dataStructure.listNode;

/**
 * 实现链表的翻转
 */
public class ReverseListTT {
    public ListNode solution(ListNode head){
        if(head == null){
            return head;
        }
        //先创建preNode和nextNode实现翻转逻辑
        ListNode preNode = null;
        ListNode nextNode = null;
        while (head != null){
            nextNode = head.next;//现保存head.next
            head.next = preNode;//实现翻转逻辑
            preNode = head;//更新preNode
            head = nextNode;//更新head，实现整体顺序后移
        }
        return preNode;
    }
}
