package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 相同节点值的最大路径长度
 *              1
 *             / \
 *            4   5
 *           / \   \
 *          4   4   5
 *
 * Output : 2
 */
public class LongestUniValuePath {
    private int path = 0;

    //方法：主函数
    public int longestUniValuePath(TreeNode root){
        dfs(root);
        return path;
    }

    //方法：深度优先遍历
    private int dfs (TreeNode root){
        if (root == null) return 0;//截止条件
        int left = dfs(root.left);//一直深度遍历到叶节点才return
        int right = dfs(root.right);
        //逻辑，判断当前节点的val和子节点的val相同
        int leftPath = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        int rightPath = (root.right != null && root.right.val == root.val) ? right + 1 : 0;
        path = Math.max(path,leftPath + rightPath);
        return Math.max(leftPath,rightPath);
    }
}
