package dataStructure.hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长和谐序列
 * 找出一个和谐数组，和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1
 * intput：nums = [1,3,2,2,5,2,3,7]
 * output：5  ([3,2,2,2,3])
 *
 * 思路：
 *      1.（这里不要求连续，故不适用）用for循环遍历数组，用一个min和max来统计，然后每个符合条件的都存入hashMap，key存长度，value存结果
 *      2. 这里不要求连续，只要找出符合条件的最大长度子数组即可，故只要hashMap计数后，找出最长的两个相邻元素，并统计最终长度即可
 */
public class FindLHS {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        //将nums中的每个元素挨个以key=num存入hashmap
        for (int num : nums) {
            //countForNum.getOrDefault(num, 0)，如果key有value值就正常取出返回，如果无则返回0
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        //从keySet中取出key，要注意map中的key或者Entry都是无序的
        //这里是逐个遍历全部的key值，故只要判断tontainsKey(num+1)，不需要判断(num-1)
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num + 1)) {
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
    }
}
