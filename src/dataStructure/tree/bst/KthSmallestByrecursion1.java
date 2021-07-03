package dataStructure.tree.bst;

import dataStructure.tree.TreeNode;

/**
 * 在二叉查找树中寻找第k小的元素
 * 思路1：中序遍历法。因为二叉查找树的中序遍历是很特殊的，它的中序遍历结果是一个有序数列，故借助于中序遍历，在中序遍历中从左往右取第k个元素，就是第k个小的元素
 * 思路2：递归法。这里借助二叉查找树的性质，左<中<右，左子树的节点值都比中间节点的值小。第k小的元素，就等于(左侧有k-1个节点个数)的节点的val值
 *             故这里创建一个递归方法-count(node)，用来统计node节点下面所有的节点个数（包括自身），以此来实现当前节点的个数统计
 *
 */
public class KthSmallestByrecursion1 {

    //方法：主函数
    public int kthSmallestByrecursion1(TreeNode root,int k){
        int leftCnt = count(root.left);
        if (leftCnt == k -1) return root.val;//直到找到当前节点的左侧节点个数为k-1时，当前的节点的val值就是树中第k小的元素
        else if (leftCnt > k -1) return kthSmallestByrecursion1(root.left,k);
        else return kthSmallestByrecursion1(root.right,k-leftCnt-1);

    }

    //方法：统计当前节点下的总节点个数（包括自身）
    private int count(TreeNode node){
        if (node == null) return 0;//截止条件
        return 1 + count(node.left) + count(node.right);
    }
}
