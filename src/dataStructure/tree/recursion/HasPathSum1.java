package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

public class HasPathSum1 {

    //方法：判断该层的 root.val+root.left/right.val==sum，即判断该层的路径和是否是sum值
    public boolean hasPathSum1(TreeNode root,int sum){
        //特殊情况
        if (root == null){
            return false;
        }

        //截止条件
        if (root.right == null && root.left == null && root.val == sum){
            return true;
        }
        //对根节点进行判断，递归逻辑只写root层即可
        boolean res = hasPathSum1(root.left,sum-root.val) || hasPathSum1(root.right,sum-root.val);
        return res;
    }
}
