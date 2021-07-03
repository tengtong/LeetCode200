package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 最小路径
 * 根节点到叶节点的最小路径长度
 * 思路：递归遍历树，最小路径和==Math.min(rightDepth,leftDepth)+1
 */
public class MinDepth {
    //方法：找出当前节点的深度
    public int minDepth(TreeNode root){
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {//处理只有单枝的情况，该节点不是叶节点，即最小深度不为1
            return right + left + 1;
        }
        return Math.min(left,right) + 1;//找出左右节点的深度的最小值再+1，作为当前节点的最小深度
    }
}
