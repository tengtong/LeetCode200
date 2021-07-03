package dataStructure.tree.bst;

import dataStructure.tree.TreeNode;

/**
 * 寻找二叉查找树中第k个元素 - 递归法
 */
public class KthSmallestByrecursion {

    //方法：寻找二叉查找树中第k个元素
    public int kthSmallestByrecursion(TreeNode root,int k){
        int leftCnt = count(root.left);
        if (leftCnt == k - 1) return root.val;
        if (leftCnt > k - 1) return kthSmallestByrecursion(root.left,k);//如果左侧节点的个数比看k-1多，则说明目标节点落在左侧
        return kthSmallestByrecursion(root.right, k-leftCnt-1);//否则，就在右侧，故在当前节点右侧再找(k-leftCnt-1)个
    }

    //方法：统计该节点下的子节点个数（包括自身节点）
    private int count(TreeNode node){
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);// "return 1 +"，return时，"+1"，加的当前节点
    }
}
