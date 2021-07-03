package dataStructure.arrayAndMatrix;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组的长度
 * 数组度定义为元素出现的最高频率，例如下面的数组度为2，因为'2'和'1'出现次数最高为2次
 * 任务是在nums中找到与nums拥有相同大小的度的最短连续子数组，返回其长度
 * 这里的子数组要保证与原数组的顺序相同，即只能截取，不能重排
 * intput: [1,2,2,3,1]
 * output: 2
 * explation: 拥有相同的度的所有子数组[1,2,2,3,1], [1,2,2,3], [2,2,3,1], [1,2,2], [2,2,3], [2,2]
 *            长度最短的为[2,2]，故返回其长度2
 * 思路：遍历数组，找到度最大的数，并确认它的首位和末尾，从而确定长度
 *      如果存在多个元素有相同的度，则对每种元素都确定一遍长度，然后找出最短
 */
public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        //统计所有元素的出现次数
        Map<Integer, Integer> numsCnt = new HashMap<>();
        //统计所有元素最后一次出现的index
        Map<Integer, Integer> numsLastIndex = new HashMap<>();
        //统计所有元素第一次出现的index
        Map<Integer, Integer> numsFirstIndex = new HashMap<>();

        //统计所有元素出现的次数，并每次都更新lastIndex，并将第一次出现的位置记录在firstIndex中
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numsCnt.put(num, numsCnt.getOrDefault(num, 0) + 1);
            numsLastIndex.put(num, i);
            if (!numsFirstIndex.containsKey(num)) {
                numsFirstIndex.put(num, i);
            }
        }

        //找出最大的度
        int maxCnt = 0;
        for (int num : nums) {
            maxCnt = Math.max(maxCnt, numsCnt.get(num));
        }

        //遍历元素，判断当前元素是否为度最大的元素
        //如果是的话，ret=lastIndex-firstIndex+1
        //然后找出最小的ret
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cnt = numsCnt.get(num);
            if (cnt != maxCnt) continue;
            ret = Math.min(ret, numsLastIndex.get(num) - numsFirstIndex.get(num) + 1);
        }

        //返回结果
        return ret;
    }
}
