package algorithm.binarySearch;

/**
 * 二分查找
 * 也称折半查找，每次都能将查询区间减半，是一个不断精确区间的过程，时间复杂度O(logN)，比一遍for循环O(n)还快
 *
 * m计算
 * mid = (low + high) / 2
 * mid = low + (high - low) / 2
 * 故，low+high可能会出现加法溢出，也就是加法结果大于整型能表示的范围，故更推荐第二种
 *
 * 未成功查找的返回值
 * 结束循环，还没有找到key，那么表示查找失败有一下两种方法
 * -1 : 以一个错误码表示没有查找到key
 * low : 将key插入到nums中的正确位置
 */

/*******************************************************************************/

/**
 * 正常实现
 * intput：[1,2,3,4,5]
 * output: 3
 */
public class BinarySearch {
    //key是目标值
    public int binarySearch(int[] nums, int key) {
        int low = 0, high = nums.length - 1;//index
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key > nums[mid]) {//目标值落在区间右侧
                low = mid + 1;
            } else if (key == nums[mid]) {//可以精确查找，故找到直接return
                return mid;
            } else if (key < nums[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 变种
     * 变种要注意边界值的判断，例如一个有重复元素的数组中查找key的最左位置
     * 该实现和正常实现有以下不同：
     *    high的赋值表达式为high=mid
     *    循环条件为low<high
     *    最后返回low而不是-1
     * key<=在nums[mid]的情况下，可以推导出最key位于[low,mid]区间中，这是一个闭区间，high的赋值表达式为high=mid，因为mid的位置也是解
     * 在high的赋值表达式为high=mid的情况下，如果循环条件为low<=high，那么会出现循环无法退出的情况，因此循环条件只能low<high
     * 以下演示了循环条件为low<=high时循环环无法退出的情况：//且下面是正常的查找过程
     * nums = {0, 1, 2}, key = 1
     * low  mid  high
     * 0    1    2      key<=nums[mid]
     * 0    0    1      key> nums[mid]
     * 1    1    1      key<=nums[mid]  //low=mid+1
     * 1    1    1      key<=nums[mid]
     *
     * 注意：这里的返回值是low，故当循环体退出时，不表示没有查找到key，因此最后返回的结果不应该是-1
     * 为了验证有没有查找到，需要在调用端判断一下返回位置上的值和key是否相等 key==nums[ binarySearchII({1,2,2,3,4}, 2) ]
     */
    public int binarySearchII(int[] nums, int key) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;// 3/2==1
            //这里不设置if(key == nums[mid])，因为可能key是有重复的，所以得找到最左边的一个才行
            //这里设置key<=num[mid]，要重新设置high值了，表示区间的右侧匹配到了key，但不一定是最左边的那个，故还要进入if，还要进行二分，还要再进一步缩小区间进行匹配
            //若 if(key >= nums[mid]) { low = mid; } 表示区间的左侧有元素匹配上了，但可能不是最右边的一个，故还需要继续二分
            //**//故，看匹配的是左边还是右边，只要看if下面的语句，是修改的左区间还是右区间，如果修改的是左区间，则匹配的是重复元素中最右侧的一个
            if (key <= nums[mid]) {
                high = mid;//因为if中还有==号，high=mid，不能取high=mid-1
            } else {
                low = mid + 1;//**//
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int mid = 3/2;
        System.out.println(mid);// 3/2=1
    }
}