package algorithm.binarySearch;

/**
 * 第一个错误的版本
 * 给定一个元素n代表有[1, 2, ..., n]版本，在第x位置开始出现错误版本，导致后面的版本都错误。可以调用isBadVersion(int x)知道某个版本是否错误，要求找到第一个错误的版本
 * 如果第m个版本出错，则表示第一个错误的版本在[l,m]之间，令h=m；否则第一个错误的版本在[m+1,h]之间，令l=m+1
 * 因为h的赋值表达式为h=m，因此循环条件为l<h
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1, h = n;
        //若while(low<=hig)，则需要在while中实现if精确查询截止条件后return
        //若while(low<hig)，则表示while中没有精确查询截止条件，只有不符合条件的判断，故最终是low=mid=hig时退出循环，low即为查找元素的下标
        while (l < h) {
            int mid = l + (h - l) / 2;
            //相当于找到出错的最左边一位，故在条件范围内，修改右区间
            if (isBadVersion(mid)) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int x) {
        //这里方法省略
        return true;
    }
}
