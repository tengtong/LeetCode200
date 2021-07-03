package dataStructure.tree.bst;

import dataStructure.tree.TreeNode;

import java.util.List;

/**
 * 寻找二叉查找树中第k小的元素
 * 遍历：前序、中序、后序遍历是可以使用dfs的思想
 */
public class KthSmallestByInorder1 {

    private int cnt = 0;
    private int val;//结果集
    private List<Integer> ret;

    //方法：主函数
    public int kthSmallestByInorder1(TreeNode root, int k){
        inOrder(root,k);
        return val;
    }

    //方法：中序遍历，左中右
    //树的递归只要把一层的关系理清楚就可以了
    //            root
    //         /       \
    //    root.left   root.right
    //      /   \      /     \
    // null     null null    null
    private void inOrder(TreeNode root, int k){
        //截止条件
        if (root == null) return;
        //左
        inOrder(root.left,k);//一直遍历到最左侧
        //中
        cnt++;//左下角节点的cnt==1；
        if (cnt == k){
            val = root.val;
        }
        //右
        inOrder(root.right,k);
    }
}
