package dataStructure.listNode;

/**
 * 寻找两个链表的第一个公共节点
 * phead1：1+[公共]，phead2：3+[公共]
 * 1+[公共]+3+[公共]
 * 3+[公共]+1+[公共]
 * 两个链表的长度可能不相同，但相加后长度一定相同
 * 即可能a！=b，但a+b==b+a
 */
public class FindFirstCommonNode {
    public ListNode solution(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
//      长度相同有公共结点，第一次就遍历到；没有公共结点，走到尾部NULL相遇，返回null
//      长度不同有公共结点，第一遍差值就出来了，第二遍一起到公共结点，例如：1+[公共]、3+[公共]；没有公共，一起到结尾null
        while(p1!=p2){
            p1 = (p1==null ? pHead2 : p1.next);//遍历pHead1，如果遍历完了开始遍历pHead2
            p2 = (p2==null ? pHead1 : p2.next);//同理
        }
        return p1;
    }
}
