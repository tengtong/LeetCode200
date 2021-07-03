package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 翻转树
 */

//递归的操作逻辑，最终都是在一个节点上完成的
public class InvertTree {
    //方法：交换当前节点的左右子树
    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return null;
        }
        //将 内部交换 过的左、右节点进行交换
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
