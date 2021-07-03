package dataStructure.hashMap;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断数组是否有重复元素
 * intput: [1,2,3,1]
 * output: true
 *
 * 思路：1.hashMap计数
 *      2.存入hashSet后，比较前后的长度
 */
public class ContainsDuplicate {
    public boolean containsDuplicate (int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //set.size <= nums.length
        return set.size() < nums.length;
    }
}
