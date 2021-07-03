package dataStructure.tree.bst;

import dataStructure.tree.TreeNode;

/**
 * 二叉查找树的最近公共祖先
 * （一个节点也可以是它自己的祖先）
 * 思路：涉及到二叉查找树，就一定会用到 左<中<右 这个性质
 */
public class LowestAncestor {
    //方法：找出p和q的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        //如果根节点的值比q和p的值都要大，那么p和q的公共祖先肯定在root节点的左侧，故在左侧寻找
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        //同理，如果根节点的值比q和p的值都要小，则在右侧寻找
        if (root.val < q.val && root.val < q.val) return lowestCommonAncestor(root.right,p,q);
        //其他情况的话，根节点就是其最近公共祖先
        return root;
    }
}
