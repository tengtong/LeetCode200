package dataStructure.hashMap;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组nums，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度
 * 要求时间复杂度O(n)
 */
public class LongestConsecutive {
    public int longestConsecutive (int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        //因为只要求找出连续的最长序列，对每个元素具体出现多少遍没有要求，故每个元素value都设为1
        for (int num : nums) {
            countForNum.put(num, 1);
        }
        //遍历nums，从每个num出发，看找能找到的最长连续序列长度是多少
        for (int num : nums) {
            forward(countForNum, num);
        }
        //完成forwara之后，每个以num的出发的最长连续序列长度都已经存在value中了，只需要遍历，找出max
        return maxCount(countForNum);
    }

    //**//
    //统计从num出发的最长连续序列长度
    private int forward(Map<Integer, Integer> coutForNum, int num) {
        if (!coutForNum.containsKey(num)) {
            return 0;
        }
        int cnt = coutForNum.get(num);
        //如果cnt>1，表示当前元素已经搜索，直接返回结果
        if (cnt > 1) {
            return cnt;
        }
        cnt = forward(coutForNum, num + 1) + 1;
        //每搜索完一个元素，就最终统计出来的最长连续序列长度作赋值给 value//(num, 从num出发的最长连续序列长度)
        coutForNum.put(num, cnt);
        return cnt;
    }

    private int maxCount(Map<Integer, Integer> countForNum) {
        int max = 0;
        for (int num : countForNum.keySet()) {
            max = Math.max(max, countForNum.get(num));
        }
        return max;
    }
}
