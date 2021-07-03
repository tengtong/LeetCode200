package algorithm.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 给定整数n和k，返回{1...n}中所有可能的k个数的组合
 * Input: n = 4, k = 2,
 * Output: [
 *           [1,2],
 *           [1,3],
 *           [1,4],
 *           [2,3],
 *           [2,4],
 *           [3,4],
 *         ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> tempCombine = new ArrayList<>();
        backtracking(tempCombine, combinations, 1, k, n);
        return combinations;
    }

    private void backtracking(List<Integer> tempCombine, List<List<Integer>> combinations, int strat, int k, final int n) {
        //递归出口
        if (k == 0) {
            combinations.add(new ArrayList<>(tempCombine));
            return;
        }
        for (int i = strat; i <= n - k + 1; i++) {//剪枝，设置条件，元素的初始大小start，子集的位数i<=n-k+1
            tempCombine.add(i);
            backtracking(tempCombine, combinations, i + 1, k - 1, n);
            tempCombine.remove(tempCombine.size() - 1);
        }
    }
}
