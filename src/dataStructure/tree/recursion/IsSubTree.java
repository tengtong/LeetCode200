package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 子树判断
 * 输入两棵树，s和t，判断t是否是s的子树
 * 子树：从两个子树从root节点往下都相同才是，如下这种情况t不是s的子树：
 * Given tree s:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 *
 * Given tree t:
 *    4
 *   / \
 *  1   2
 *
 * 思路：也是两层递归，第一层递归遍历主树，当找到root节点相同时，开始第二层递归遍历逐个节点判断两个树是否相等
 */
public class IsSubTree {
    public boolean isSubTree(TreeNode s,TreeNode t){
        if (s == null) return false;
        return isSubtreeWithRoot(s,t) || isSubTree(s.left,t) || isSubTree(s.right,t);
    }
    private boolean isSubtreeWithRoot(TreeNode s,TreeNode t){
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;//如果t和s都为null的时候第一个if语句就进行判断了
        if (t.val != s.val) return false;//主要的判断逻辑
        return isSubtreeWithRoot(s.left,t.left) && isSubtreeWithRoot(s.right,t.right);
    }
}
