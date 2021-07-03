package dataStructure.tree.bst;

import dataStructure.listNode.ListNode;
import dataStructure.tree.TreeNode;

/**
 * 根据有序链表构造平衡的二叉查找树
 * 思路：
 */
public class SortedListToBST {

    //方法：主函数
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);//如果下个节点为空，则根据当前节点返回一个TreeNode
        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        preMid.next = null; //断开链表
        TreeNode t = new TreeNode(mid.val);
        t.left = sortedListToBST(head);
        t.right = sortedListToBST(mid.next);
        return t;
    }

    //方法：找到一个链表的中间节点
    private ListNode preMid(ListNode head){
        ListNode slow = head, fast = head.next;
        ListNode pre = head;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}
