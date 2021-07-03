package dataStructure.listNode;

/**
 * 合并两个排序链表
 * 思路：逐个对比节点，然后按大小插入（可以用递归实现）
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        //限制条件：比到最后的情况，如果list1==null，list2则还有值说明，在最后的比较中list2才是较大的一个，开始触底回弹
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        //1、对两个链表的value值进行比较
        //1.1、当list2.value的值较大时，返回（list2，list1.next），继续对list2和list1.next进行比较
        if(l1.val <= l2.val){
            //比较完之后，递归回传，把较大的值接在较小的值的后面
            l1.next = mergeTwoLists(l1.next, l2);
            //1.1和1.2交替回传，1.1是处理的情况是list2.value值大，当最后list2最后在list1中落网时，会在1.2中实现return，开始回传
            return l1;
        }
        //1.2、当list2.value的值较大时，返回（list2，list1.next），继续对list2和list1.next进行比较
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
