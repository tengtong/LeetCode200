package dataStructure.listNode;

/**
 * 判断链表是否是回文链表
 * O(1)空间复杂度
 * 思路：将链表切成两半，把后半段反转，然后比较两半是否相等
 *      传统的字符串回文串是对比头尾节点，然后依次向中间比较，但是链表不易遍历任意位置，且不能往前访问
 *      所以采用将链表切成两半，在对后半端采取反转的形式，来判断两部分是否相等
 *      而对半分的时候，所有要确认节点的奇偶个数，偶数的话直接切半，奇数的话有一个中间节点，故需要先统计个数
 *      因为保证时间效率，采用快慢指针法，快慢指针可以定点链表中的任意位置
 */
public class IsPalindrome {

    /**
     * 判断以head为头节点的链表是否是回文串
     * @param head
     * @return
     */
    public boolean isPalindrome (ListNode head) {
        //判断特殊情况
        if (head == null || head.next == null) return true;
        //找到链表的中间节点
        //当快节点到末尾时，慢节点刚到链表中间。fast初始就从1开始走，slow初始就从0开始走
        ListNode slow = head, fast = head.next;
        //如果fast为null，表示1->3->5，第5个节点为null，则共有偶数个节点
        //如果fast.next为null，表示1->3->5，表示第6个节点为null，则共有奇数个节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果 fast != null 代表 fast.next == null
        //表示链表为奇数个节点，让 slow 指向下一个节点，切割[0,slow+1]，将中间节点切下
        //否则链表为偶数个节点，那么[0,slow]正好一半
        if (fast != null) slow = slow.next;
        //切成两个链表
        //链表一：包括中间节点
        //链表二：不包括中间节点
        //cut方法就是获取链表一
        cut (head, slow);
        return isEqual (head, reverse(slow));
    }

    /**
     * 截取链表中[head, cutNode]部分
     * @param head
     * @param cutNode
     */
    private void cut(ListNode head, ListNode cutNode) {
        while (head.next != cutNode) {
            head = head.next;
        }
        //cutNode节点之后的链表都不要了
        head.next = null;
    }

    /**
     * 反转链表——头插法
     * @param head
     * @return
     */
    private ListNode reverse (ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            //临时保存head节点的后一位节点
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    /**
     * 判断两个链表是否相同
     * @param l1
     * @param l2
     * @return
     */
    private boolean isEqual(ListNode l1, ListNode l2) {
        //必须l1和l2同时不为null，才会进入while循环
        //否则只要有一个为null，即表示之前的节点都匹配，另一个不为null的链表剩余的是中间节点，为true
        //或者两个都为null，表示之前的节点都匹配，为true
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
