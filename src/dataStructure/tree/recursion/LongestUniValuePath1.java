package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 寻找相同节点值的最大路径长度
 * 思路：dfs，先遍历完一条路径
 */
public class LongestUniValuePath1 {

    private int path;

    public int longestUniValuePath1(TreeNode root){
        dfs(root);
        return path;
    }

    //方法：深度遍历一条路径直到叶节点
    private int dfs (TreeNode root){
        if (root == null) return 0;//截止条件
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
        path = Math.max(path, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
