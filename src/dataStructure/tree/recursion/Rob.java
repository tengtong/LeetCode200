package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 间隔遍历 - 打家劫舍III
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警
 * 思路：两种情况，取较大值
 */
public class Rob {

    //方法：打劫当前节点
    public int rob(TreeNode root){
        if (root == null) return 0;
        //第一种情况，打劫root、root.left.left、root.left.right
        //           和root、root.right.left、root.right.right
        int val1 = root.val;//打劫root
        if (root.left != null){//打劫root.left.left、打劫root.left.right
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null){//打劫root.right.left、打劫root.right.right
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        //第二种情况，打劫root.left、root.right
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1,val2);
    }
}
