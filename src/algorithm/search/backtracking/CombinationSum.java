package algorithm.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合求和
 * intput: candidate=[2,3,6,7], target=7
 * output: [[7],[2,2,3]]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> tempCombine = new ArrayList<>();
        backtracking(tempCombine, combinations, 0 ,target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> tempCombine, List<List<Integer>> combinations, int start, int target, final int[] candidates) {
        //递归出口
        if (target == 0) {
            combinations.add(new ArrayList<>(tempCombine));
            return;
        }
        //for循环
        //里面设置不同条件
        //candidates[i] <= target
        //target = target - candidates[i]
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                tempCombine.add(candidates[i]);
                backtracking(tempCombine, combinations, i, target - candidates[i], candidates);
                tempCombine.remove(tempCombine.size() - 1);
            }
        }
    }
}
