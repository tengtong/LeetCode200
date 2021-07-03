package dataStructure.listNode;

/**
 * 链表元素按节点编号的奇偶性聚集
 * 要求按原地算法（不新增链表），空间复杂度为O(1)，时间复杂度为O(nodes)
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * 即第1.3.5.7...奇数位置的节点放前面，偶数位置的节点放后面
 * 思路：这里原始链表是1->2->3->4->5->6->7
 *      需要改成的链表是1->3->5->7->2->4->6
 *      因统计规律只是分奇偶编号位置，比较简单，故直接用跳表的方式对奇偶数链表进行单独统计，再链接在一起
 *      若统计规律为其他，只需要用两个if判断，再分别进入两个链表实现统计，最后再合并即可
 */
public class OddEvenList {
    public ListNode oddEvenList (ListNode head) {
        //处理特殊情况
        if (head == null) return head;
        //odd奇数，even偶数
        //evenHead为第二个节点即偶数位置链表的头，先进行保存
        //odd从第一个节点开始处理，even从第二节点开始处理
        ListNode odd = head, even = head.next, evenHead = even;
        //只要奇偶位置链表有一个节点为null，表示已经统计到了最后一位
        while (even != null && even.next != null) {
            //1->3->5->7
            odd.next = odd.next.next;
            odd = odd.next;
            //2->4->6
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
