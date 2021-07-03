package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 判断树的路径和是否等于指定的数
 * 路径和：从root到leaf的所有节点的和
 */
public class HasPathSum {
    //从root节点往下递归
    public boolean hasPathSum(TreeNode root,int sum){
        //先判断特殊情况
        if (root == null){
            return false;
        }
        //即遍历到根节点了，且路径和为sum
        if (root.left == null && root.right == null && root.val == sum){
            return true;
        }
        //递归判断左右节点
        boolean res = hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
        return res;
    }
}
