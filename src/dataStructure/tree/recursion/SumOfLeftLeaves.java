package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 统计左叶子节点的和
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: 9+15=24
 * 思路：isLeaf(root.left)
 *      1、判断左节点。只对root.left进行判断，而不是到叶节点层进行判断，因为叶子节点无法确定是左节点还是右节点
 *      2、判断是否是叶子节点。叶子节点==没有左右孩子节点
 *         1+2==左叶子节点
 */
public class SumOfLeftLeaves {
    //方法：统计当前节点的左叶子节点的和
    public int sumOfLeftLeaves(TreeNode root){
        if (root == null) return 0;
        if (isLeaf(root.left)){//只判断isLeaf(root.left)，这样来寻找所有的左叶子节点//如果当前节点的左孩子节点是叶节点，则累加该节点的val值，并统计右孩子节点中的左叶子节点值
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        //如果当前节点的左孩子节点不是叶节点，则在当前节点的左孩子节点和右孩子中继续寻找
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    //方法：判断是否是叶节点，即没有左右孩子树
    private boolean isLeaf(TreeNode node){
        if (node == null) return false;
        return node.left == null && node.right == null;
    }
}
