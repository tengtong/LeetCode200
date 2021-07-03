package algorithm.search.backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 含有相同元素求子集
 * intput: nums = [1,2,2]
 * output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubSetsII {
    public List<List<Integer>> subSetWithDup(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();
        List<Integer> tempSubSet = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];
        Arrays.sort(nums);//原始数组中有重复出现的元素，先进行排序
        //不同的子集大小
        for (int size = 0; size <= nums.length; size++) {
            backtracking(tempSubSet, subSets, 0, hasVisited, size,nums);
        }
        return subSets;
    }

    private void backtracking(List<Integer> tempSubSet, List<List<Integer>> subSets, int start, boolean[] hasVisited, final int size, final int[] nums) {
        //递归出口
        if (tempSubSet.size() == size) {
            subSets.add(new ArrayList<>(tempSubSet));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //有相同元素出现
            if (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            tempSubSet.add(nums[i]);
            hasVisited[i] = true;
            backtracking(tempSubSet, subSets, i + 1, hasVisited, size, nums);
            tempSubSet.remove(tempSubSet.size() - 1);
        }
    }
}
