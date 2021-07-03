package dataStructure.listNode;

/**
 * 找出两个链表的交点，若不存在则返回null
 * 两种情况
 * 1、如果存在相交：a+b+c = b+c+a (a为链表A非公共部分，b为链表B非公共部分，c为两个链表的相交部分)
 * 2、如果不存在相交：a+b = b+a //遍历A、B链表，若不存在交点则会在在null处结束
 *
 * 若只是判断是否存在交点
 * 1、把第一个链表的结尾连接到第二链表的的开头，看第二个链表是否存在环
 * 2、或者直接比较两个链表的最后一个节点是否相同（⭐️）
 *
 * 总结：
 * 链表是一个节点一个节点的集合，不是线段
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            //条件判断语句，如果判断当前的l1是否为空节点，如果是的话表示A链表已经遍历完开始遍历B链表，否则继续遍历
            //若存在的话，在遍历B的中间某一节节点就找到交点，跳出循环
            //若不存在的话，在遍历完B时找到交点null，跳出循环，故这个代码对两种情况都适用
            l1 = (l1 == null) ? headB : l1.next;
            //同上
            l2 = (l2 == null) ? headA : l2.next;
        }
        //跳出循环时，当前节点即为交点
        return l1;
    }
}
