package dataStructure.tree.bst;

import dataStructure.tree.TreeNode;

/**
 * 把二叉查找树每个节点的值都加上比它大的节点的值
 * Input: The root of a Binary Search Tree like this:
 *
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *
 *              18
 *             /   \
 *           20     13
 *
 * 思路：右中左顺序遍历树，依次累加
 */
public class ConvertBST {
    private int sum = 0;

    public TreeNode converBST(TreeNode root){
        traver(root);
        return root;
    }

    //方法：
    //递归：只要把一个层的逻辑写出来就可以了，即三个节点的逻辑
    //     在递归中，node.left和node.right 的逻辑要调用递归方法来实现，因为 node.left和node.right 在下一层，也只是一个node
    //     故如果不用递归实现左右节点逻辑，直接写node和node.right/left的逻辑，会导致逻辑只实现了一层
    //     一定程度上可以理解为只要关心 中间节点 的逻辑即可，即传入的node参数
    private void traver(TreeNode node){
        if (node == null) return;//截止条件
        traver(node.right);
        sum += node.val;//这里直接累加sum即可，因为sum在root.right层中已经累加过了root.right的val
        node.val = sum;
        traver(node.left);
    }
}
