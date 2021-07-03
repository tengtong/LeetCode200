package algorithm.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 含有相同元素的全排列
 * 在上一中情况中，增加了重复元素出现的可能
 * Input：[1,1,2]
 * Output：[
 *           [1,1,2],
 *           [1,2,1],
 *           [2,1,1]
 *         ]
 * 思路：数组中可能含有相同元素，进行排列的时候就可能有出现重复的排列，要求重复的排列只返回一个
 *      在实现时，和Permutations不同的是，需要对原始数组进行排序，然后在添加一个元素时，判断这个元素是否等于前一个元素，
 *      如果等于，并且前一个元素还未访问，那么就跳过这个元素
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //初始化变量
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> tempPermute = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] hasVisited = new boolean[nums.length];
        //主方法
        backtracking(tempPermute, permutes, hasVisited, nums);
        return permutes;
    }

    /**
     * 回溯
     * @param tempPermute 临时集
     * @param permutes 结果集
     * @param visited 标记集
     * @param nums
     */
    private void backtracking(List<Integer> tempPermute, List<List<Integer>> permutes, boolean[] visited, final int[] nums) {
        //递归出口
        if (tempPermute.size() == nums.length) {
            permutes.add(new ArrayList<>(tempPermute));//为什么new
            return;
        }
        //for循环
        for (int i = 0; i < visited.length; i++) {
            //在添加一个元素时，先判断这个元素是否等于前一个元素，如果等于并且前一个元素还未访问，那么就跳过这个元素
            if (i != 0 && nums[i] == nums[i-1] && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {//如果该元素已经被访问过，跳过
                continue;
            }
            visited[i] = true;//修改标记位
            tempPermute.add(nums[i]);//将结果添加进临时集
            backtracking(tempPermute, permutes, visited, nums);//回溯
            tempPermute.remove(tempPermute.size() - 1);
            visited[i] = false;
        }
    }
}
