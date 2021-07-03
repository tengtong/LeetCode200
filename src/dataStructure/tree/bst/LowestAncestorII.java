package dataStructure.tree.bst;

import dataStructure.tree.TreeNode;

/**
 * 寻找二叉树的最近公共祖先
 * 思路：二叉树中的节点没有二叉查找树中那样存在大小关系，这里普通二叉树的公共祖先，就利用二叉的性质，只寻找和判断p和q的位置
 *      从root节点出，往两侧遍历，root进行左移和右移，如果p和q分布在两侧，则root就是公共祖先
 *                            若p和q都分布在同一侧，则先遍历到的就是两者最近的公共祖先
 */
public class LowestAncestorII {

    //方法：
    //例：5 4 => 5 ，当从3向下遍历时，收到left=5，就不在往左侧遍历了，右侧没有5和4，right=null，故得到结果为5，这里只找到5就不需要继续遍历下去了
    public TreeNode lowestAncestorII(TreeNode root,TreeNode p,TreeNode q){
        if (root == null || root == p || root == q) return root;//截止条件//如果遍历到叶节点或者p、q节点，直接return
        //判断p和q是否在是root的左右，因为只有上述条件才会return
        TreeNode left = lowestAncestorII(root.left,p,q);
        TreeNode right = lowestAncestorII(root.right,p,q);
        //用 "? :"代替复杂的if语句的
        //left是否为null，如果为null，则p和q都在right上，则会返回两者高度较高的节点，即返回的就是两者最近的公共祖先
        //              如果不为null，则表示左侧有查询到q或p，则判断right是否为空，如果right为空，则表示两个节点都在left上，则返回直接返回left即可
        //                                                               如果right不为空，则表示q、p分布在left、right两侧，直接返回root即可
        return left == null ? right : (right == null ? left : root);
    }
}
