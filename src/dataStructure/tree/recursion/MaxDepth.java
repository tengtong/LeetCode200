package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 树的高度
 * 高度：从下往上，叶节点高度是1（房子的高度，从下往上数）
 * 深度：从上往下，根节点的深度是1
 * 思路：根节点的高度是0，树的高度=max(左子树高度，右子树高度)
 */

/**
 *              (1)
 *        (2)        (3)
 *     (4)   (5)  (6)   (7)
 */
public class MaxDepth {
    public int maxDepth(TreeNode root){//root(1)
        if (root == null) {//截止条件，根节点的高度是0
            return 0;
        }
        //代码是一行一行的运行的，但是同一行中计算是从左到右进行的
        //   故先计算完solution(root.left)，再计算solution(root.right)方法
        //   即先递归计算完一侧的树，再递归计算另一侧的树
        int res = Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        return res;
    }
}

