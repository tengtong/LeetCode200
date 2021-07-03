package dataStructure.hashMap;

/**
 * 哈希表
 * 用法：1.计数
 *      2.以O(N)的空间复杂度换取O(1)的时间复杂度
 * 哈希表使用O(n)空间复杂度存储数据，并且用O(1)时间复杂度求解问题，
 * Java中的hashSet用于存储一个集合，可以查找元素是否集合中。如果元素有穷，并且范围不大，那么可以用一个布尔数组来存储
 * 一个元素是否存在。例如对于小写字符的元素，就可以用长度26的布尔数组来存储一个字符集合，使得空间复杂度降低为O(1)
 *
 * Java中的HashMap主要用于映射关系，从而把两个元素联系起来。HashMap也可以用来对元素进行计数统计，此时key为元素，value为计数
 * 和HashSet类似，如果元素有穷且范围不大，可以用整型数组来进行统计。在对一个内容进行压缩或者其他转化时，利用hashMap可以把原始内容
 * 和转换后的内容联系起来。例如在一个简化url的系统中(leetcode-535)
 */

import java.util.HashMap;

/**
 * 数组中两个数的和为给定值
 * intput：nums = [2,7,11,15], target = 9
 * output：[0,1]
 *
 * 思路：
 * 1.可以先对数组进行排序，然后使用双指针方法或者二分查找方法。这样做的时间复杂度为O(NlogN)，空间复杂度为O(1)
 * 2.用hashMap存储数组元素和索引的映射，在访问到nums[i]时，判断hashMap中是否存在target-nums[i]
 *   如果存在说明target-nums[i]所在的索引和i就是要找的两个数。该方法的时间复杂度为O(N)，空间复杂度为O(N)，使用空间换时间
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexForNum.containsKey(target - nums[i])) {
                return new int[] {indexForNum.get(target - nums[i]), i};
            }
        }
        return null;
    }
}
