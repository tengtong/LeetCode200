package algorithm.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 1-9数组的组合求和
 * 从1-9数字中选出k个数不重复的数，使得它们的和为n
 * intput: k=3, n=9
 * output: [[1,2,6],[1,3,5],[2,3,4]]
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k,int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> tempCombine = new ArrayList<>();
        backtracking(tempCombine, combinations, k, n, 1);
        return combinations;
    }

    /**
     *
     * @param tempCombine
     * @param combinations
     * @param k k个数
     * @param n 和为n
     * @param start
     */
    private void backtracking(List<Integer> tempCombine, List<List<Integer>> combinations, int k, int n, int start) {
        //递归出口
        if (k == 0 && n == 0) {
            combinations.add(new ArrayList<>(tempCombine));
            return;
        }
        if (k == 0 || n == 0) {//全选完了，但是条件未同时成立，即不符合标准，失败，不存储结果，回传
            return;
        }
        for (int i = start; i <= 9; i++) {
            tempCombine.add(i);//添加结果进入临时集
            backtracking(tempCombine, combinations, k - 1 , n - i, i + 1);
            tempCombine.remove(tempCombine.size() - 1);
            //因为从所选的序列1-9中按序排列组合，可以将所有的结果都考虑进行，且不回头，故不用设置标志集
        }
    }
}
