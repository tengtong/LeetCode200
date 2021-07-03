package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 归并两颗树
 * 相同位置val相加，不同位置保留
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode node1,TreeNode node2){

        //处理当前节点
        //处理节点不冲突的情况
        if (node1 == null && node2 == null){
            return null;
        }
        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }
        //处理节点冲突的情况
        TreeNode root = new TreeNode(node1.val + node2.val);

        //处理左右节点
        root.left = mergeTrees(node1.left,node2.left);
        root.right = mergeTrees(node1.right,node2.right);
        return root;
    }
}
