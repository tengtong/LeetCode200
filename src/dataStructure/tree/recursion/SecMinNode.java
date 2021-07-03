package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 找出二叉树中第二小的节点
 * Input:
 *    2
 *   / \
 *  2   5
 *     / \
 *     5  7
 *
 * Output: 5
 * 思路：遍历所有节点，找出第二小的节点值
 */
public class SecMinNode {

    //方法：寻找第二小的节点
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;//截止条件，root节点为空
        if (root.left == null && root.right == null) return -1;//截止条件，root左右节点为空，只有根节点
        //统计左、右节点的最小值
        int leftVal = root.left.val;//左孩子节点的val值
        int rightVal = root.right.val;//右孩子节点的val值
        if (leftVal == root.val) {//如果root.val==root.left.val，则继续从root.left开始继续寻找
            leftVal = findSecondMinimumValue(root.left);//找到左节点倒数第二小的节点值
        }
        if (rightVal == root.val) {//同上
            rightVal = findSecondMinimumValue(root.right);//找到右节点倒数第二小的节点值
        }
        //两个倒数第二小的，取较小的，就是全树倒数第二小的
        if (leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
        if (leftVal != -1) return leftVal;
        return rightVal;
    }
}
