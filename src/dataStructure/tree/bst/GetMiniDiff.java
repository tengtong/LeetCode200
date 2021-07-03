package dataStructure.tree.bst;

import dataStructure.tree.TreeNode;

/**
 * 在二叉查找树中查找两个节点之差的最小绝对值
 * 思路：利用二叉查找树的中序遍历为有序的性质，计算中序遍历中临近的两个节点之差的绝对值，取最小值
 *      二叉查找树左<=中<=右，故要求两个节点之差最小的话，肯定只有临近的节点值才会出现最小
 * Input:
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * Output:
 * 1
 */
public class GetMiniDiff {
    private int minDiff = Integer.MAX_VALUE;//先取最大，保证一定能被更新
    private TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root){
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode node){
        if (node == null) return;
        inOrder(node.left);
        //这里有点特殊的，因为要统计前后节点值的差，而中序遍历中只记录当前节点的情况，故需要保存preNode，才能计算前后两个节点的val值差
        if (preNode != null) minDiff = Math.max(minDiff,node.val - preNode.val);
        preNode = node;
        inOrder(node.right);
    }
}
