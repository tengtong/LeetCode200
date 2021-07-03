package algorithm.binarySearch;

/**
 * 有序数组的single element
 * 一个有序数组只有一个数不出现两次，找出这个数
 * Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
 * Output: 2
 * 思路：
 * 拿到题目找几个简单的例子观察一下
 * 要求以O(logN)时间复杂度进行求解，因此不能遍历数组并进行异或操作来求解，这么做的时间复杂度为O(N)
 * 令index为Single Element在数组中的位置。在index之后，数组中原来存在的成对状态被改变。如果m为偶数，并且m+1<index，那么nums[m]==nums[m+1]；m+1>=index，那么nums[m]!=nums[m+1]
 * 从上面的规律可以知道，如果nums[m]==nums[m+1]，那么index所在的数组位置为[m+2,h]，此时令l=m+2；如果nums[m]!=nums[m+1]，那么index所在的数组位置为[l,m]，此时令h=m//因为m的位置是single Element，也会出现这个情况
 * 因为h的赋值表达式为h=m，那么循环条件也就只能使用l<h这种形式
 */
public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        //当出现l>=h的时候，跳出循环
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;//保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {//即m+1都符合规律，single Element在m+1之后，即[m+2,h]
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
}
