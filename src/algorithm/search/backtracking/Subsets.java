package algorithm.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 找出集合的所有子集，子集不能重复例如[1,2]和[2,1]
 * intput：nums = [1,2,3]
 * output：[[],[1],[1,2],[1,3],[1,2,3],[2],[2,3],[3]]
 */
public class Subsets {
    public List<List<Integer>> subSets(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();
        List<Integer> tempSubSet = new ArrayList<>();
        //多层回溯
        for (int size = 0; size <= nums.length; size++) {
            backtracking(tempSubSet, subSets, 0, size, nums);
        }
        return subSets;
    }

    private void backtracking(List<Integer> tempSubSet, List<List<Integer>> subSets, int start, final int size, final int[] nums) {
        //递归出口
        if (tempSubSet.size() == size) {
            subSets.add(new ArrayList<>(tempSubSet));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tempSubSet.add(nums[i]);
            backtracking(tempSubSet, subSets, i + 1, size, nums);
            tempSubSet.remove(tempSubSet.size() - 1);
        }
    }
}
