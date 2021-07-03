package algorithm.binarySearch;

/**
 * 求开方
 * input: 4
 * output: 2
 * input: 8
 * output: 2
 * explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
 *
 * 思路：一个数x的开方sqrt一定在0～x，并且满足sqrt==x/sqrt，可以利用二分查找在0~x之间查找sqrt
 *      对于x=8，它的开方是2.82842...，最后应该返回2，而不是3
 *      //？//在循环条件为low<=high并且退出循环时，high总是比low小1，也就是说high=2,low=3，因此最后返回值是high而不是low
 *      常规情况的话，直接用for循环遍历(0,n)，然后用i*i==key，判断一下就可以找出最符合的i值，但是时间复杂度为O(n)，而二分查找的话为O(logn)
 */
public class Sqrt {
    public int sqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 1, high = x;
        while (low <= high) {//循环结束的条件与low和high的初始值有关
            int mid = low + (high - low) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {//mid偏大
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
