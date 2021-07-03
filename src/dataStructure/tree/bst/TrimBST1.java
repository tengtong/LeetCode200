package dataStructure.tree.bst;

import dataStructure.tree.TreeNode;

/**
 * 修剪二叉查找树，使得树中的所有节点的值都落在[L,R]区间上
 */
public class TrimBST1 {
    public TreeNode trimBST(TreeNode root,int L,int R){
        //截止条件
        if (root == null) return null;
        //先对根节点进行判断，左<中<右
        if (root.val > R) return trimBST(root.left,L,R);//如果root.val比最大的大，则只可能在左子树中存在符合条件的节点
        if (root.val < L) return trimBST(root.right,L,R);//同理，如果root.val比最小的小，则只可能在右子树中存在符合条件的节点
        //如果根节点的值落在区间内，则在左右子树中判断是否符合条件的值是否存在，并进行节点拼接
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        return root;
    }
}
