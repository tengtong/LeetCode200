package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

public class MaxDepth1 {
    public int maxDepth1(TreeNode root){
        //截止条件
        if (root == null){
            return 0;
        }
        int left_high = maxDepth1(root.left);
        int right_high = maxDepth1(root.right);
        int res = Math.max(left_high,right_high);
        return res;
    }
}
