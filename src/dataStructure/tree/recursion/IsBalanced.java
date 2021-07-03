package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 判断是否是平衡树
 * 判断标准：该树左右两个子树的高度差的绝对值不超过1，并且左右子树都是一颗平衡二叉树，即左右子树节点也符合这个标准
 */
public class IsBalanced {
    private boolean result = true;

    public boolean isBalanced(TreeNode root){
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left_high = maxDepth(root.left);
        int right_high = maxDepth(root.right);
        if (Math.abs(left_high - right_high) > 1){//如果其中一层左右子树的高度差大于1，则整颗树都是不平衡的
            result = false;
        }
        int root_high = Math.max(left_high,right_high) + 1;
        return root_high;
    }
}
