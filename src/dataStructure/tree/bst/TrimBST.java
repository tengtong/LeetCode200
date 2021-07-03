package dataStructure.tree.bst;

/**
 * BST（二叉查找/排序/搜索树）：根节点大于等于左子树所有节点，小于等于右子树所有节点；且左右子树也是二叉查找树，没有健值相同的点
 * 性质：二叉查找树的 中序遍历 有序，查询效率比链表高
 */

import dataStructure.tree.TreeNode;

/**
 * 修剪二叉查找树
 * 修剪使得所有节点的值在[L, R]中 (R>=L)，只保留 L~R 之间的节点
 * Input:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * Output:
 *       3
 *      /
 *    2
 *   /
 *  1
 *
 *  思路：这里是BST，左<中<右，遍历树，对节点值进行判断，删除不满足的节点，删除后进行拼接
 */
public class TrimBST {

    /**
     * 方法：修剪二叉树，使得所有节点的值都在[L,R]之间
     * @param root 当前节点
     * @param L 左区间边界值
     * @param R 右区间边界值
     * @return 修剪后的root节点
     */
    public TreeNode trimBST(TreeNode root,int L,int R){
        if (root == null) return null;//如果
        if (root.val > R) return trimBST(root.left,L,R);//如果根节点比右边界大，则只要左子树中寻找适合的节点即可
        if (root.val < L) return trimBST(root.right,L,R);//同理
        //如果根节点在区间内，对左子树进行修剪，并将结果拼接在root.left上
        root.left = trimBST(root.left,L,R);//增删节点，只要重新对其next属性进行赋值即可
        root.right = trimBST(root.right,L,R);
        return root;
    }
}
