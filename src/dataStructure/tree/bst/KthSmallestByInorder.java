package dataStructure.tree.bst;

import dataStructure.tree.TreeNode;

/**
 * 寻找二叉查找树的第k小个元素 - 中序遍历法
 * 思路：二叉查找树的中序遍历是左中右，值是从小到大，故使用中序遍历统计，从左边开始，当访问到第k个元素时，就是第k个小的元素
 */
public class KthSmallestByInorder {
    private int cnt = 0;
    private int val;//结果值

    //方法：主函数
    public int KthSmallestByInorder(TreeNode root,int k){
        inOrder(root,k);
        return val;
    }

    //方法：通过中序遍历将结果值存在val属性中
    //中序遍历本身就是从小到大的过程
    //递归，只看3个节点，或者t1、root、t2
    private void inOrder(TreeNode node,int k){
        if (node == null) return;//截止条件
        inOrder(node.left,k);//走到最左下角的节点，给节点的cnt是0，再往上层return，val值逐渐变大，就可以找到倒数第k个数
        cnt++;
        if (cnt == k){
            val = node.val;
            return;
        }
        inOrder(node.right,k);
    }
}
