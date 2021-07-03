package dataStructure.tree.bst;

import dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在二叉查找树中寻找两个节点，使他们的和为一个给定值
 * 思路：使用中序遍历得到有序数组之后，再使用双指针对数组进行查找
 *      这里要注意：这题不能分别在左右子树两部分来处理这种思想，因为两个待求的节点可能分别在左右子树中
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 */
public class FindTarget {

    //方法：主函数
    public boolean findTarget(TreeNode root, int k){
        List<Integer> nums = new ArrayList<>();
        inOrder(root,nums);//使用中序遍历，将节点值都存入nums中//nums要么用类属性来共享，要么就当参数进行传递
        int i = 0, j = nums.size() -1;
        while (i< j){//因为中序遍历的数是从小到大，故从头尾分别开始走//双指针，每次情况不同移动不同指针，for中只有一个条件判断语句，故不合适，要用while
            int sum = nums.get(i) + nums.get(j);
            if (sum == k) return true;
            if (sum < k) i++;//j不移动，i右移
            j--;
        }
        //如果全部移动完，i和j相遇还没有 sum == k ，则不存在这两个节点，false
        return false;
    }

    //方法：中序遍历，并将结果存入nums
    //     递归版本，四行代码
    private void inOrder(TreeNode root,List<Integer> nums){
        if (root == null) return;
        inOrder(root.left,nums);
        nums.add(root.val);
        inOrder(root.right,nums);
    }
}
