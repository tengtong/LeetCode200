package algorithm.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 含有相同元素的组合求和
 * intput: candidate=[10, 1, 2, 7, 6, 1, 5], target=8,
 * output: [
 *          [1, 7],
 *          [1, 2, 5],
 *          [2, 6],
 *          [1, 1, 6]
 *         ]
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> tempCombine = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] hasVisited = new boolean[candidates.length];
        backtracking(tempCombine, combinations, hasVisited, 0, target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> tempCombine, List<List<Integer>> combinations, boolean[] visited, int start, int target, final int[] candidates) {
        //递归出口
        if (target == 0) {
            combinations.add(new ArrayList<>(tempCombine));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //当前元素不是第一个，且大小与上一个元素相同，且上一个元素未访问过 ==> 跳过
            if (i != 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (candidates[i] <= target) {
                tempCombine.add(candidates[i]);
                visited[i] = true;
                backtracking(tempCombine, combinations, visited, i + 1, target - candidates[i], candidates);
                tempCombine.remove(tempCombine.size() - 1);
            }
        }
    }
}
