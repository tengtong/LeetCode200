package algorithm.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 排列
 * 给定一个没有重复数字的序列，返回所有可能的全排列
 * Input：[1,2,3]
 * Output：[
 *          [1,2,3],
 *          [1,3,2],
 *          [2,1,3],
 *          [2,3,1],
 *          [3,1,2],
 *          [3,2,1]
 *        ]
 */
public class Permutations {
    /**
     * @param nums
     * @return 结果集，返回一个二维数组
     */
    public List<List<Integer>> permute(int[] nums) {
        //初始化变量
        List<List<Integer>> permutes = new ArrayList<>();//结果集
        List<Integer> tempPermute = new ArrayList<>();//子结果集
        boolean[] hasVisited = new boolean[nums.length];//元素标注
        backtracking(tempPermute, permutes, hasVisited, nums);
        return permutes;
    }

    /**
     * 回溯
     * @param tempPermute 临时集
     * @param permutes 结果集
     * @param visited 标志集，判断当前元素是否被访问，visited.length == mums.length
     * @param nums
     */
    private void backtracking(List<Integer> tempPermute, List<List<Integer>> permutes, boolean[] visited, final int[] nums) {
        //递归出口
        if (tempPermute.size() == nums.length) {
            permutes.add(new ArrayList<>(tempPermute));//重新构造一个List
        }
        //for循环
        //for实现最外层的循环，递归实现内部多层循环（内部多层循环逻辑相同，故一套递归语句就可实现）
        for (int i = 0; i < visited.length; i++) {
            //如果当前元素已经被访问过了，则跳过此次
            if (visited[i]) {
                continue;
            }
            visited[i] = true;//当前元素的标志置true
            tempPermute.add(nums[i]);//将结果添加到临时集
            backtracking(tempPermute, permutes, visited, nums);//递归
            tempPermute.remove(tempPermute.size() - 1);//移除已经处理完的元素
            visited[i] = false;//将已处理过的元素标志位重新置false
        }
    }
}
