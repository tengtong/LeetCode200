package dataStructure.listNode;

/**
 * 分隔链表
 * 把链表分隔成 k 部分，每部分的长度都应该尽可能相同，排在前面的长度应该大于等于后面的。
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1,
 * and earlier parts are a larger size than the later parts.
 * 思路：统计链表长度，然后按k统计分隔个数和每个链表的长度，进行分隔链表
 */
public class SplitListToParts {
    public ListNode[] splitListToParts (ListNode root, int k) {
        int N = 0;
        //创建临时链表，用于统计链表长度
        ListNode cur = root;
        //统计链表长度
        while (cur != null) {
            N++;
            cur = cur.next;
        }
        //取余，判断最大的curSize有几组
        int mod = N % k;
        //除数，判断共有几段链表
        int size = N / k;
        //结果集，存4段链表
        ListNode[] ret = new ListNode[k];
        cur = root;
        for (int i = 0; cur != null && i < k; i++) {
            //cur初始是整个链表，在截取的时候，修饰头和尾，然后将截取后的cur存入结果集ret[i]
            ret[i] = cur;
            //(mod-- >0 ? 1 : 0)
            //因为是余数，所以肯定不能保证满足k组，不然就整除了
            //然后对每个组+1，依次耗尽余数mod
            int curSize = size + (mod-- > 0 ? 1 : 0);
            //根绝curSize截取cur，存入
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            //临时变量next
            ListNode next = cur.next;
            //修饰当前链表cur的尾部，确定链表段
            cur.next = null;
            //保持遍历，修饰下一个链表段的头部
            cur = next;
        }
        return ret;
    }
}
