package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 判断树是否是左右对称
 * 思路：递归判断左右节点是否相等
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root){
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode t1,TreeNode t2){//方法重载
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSymmetric(t1.left,t2.right) && isSymmetric(t1.right,t2.left);
    }
}
