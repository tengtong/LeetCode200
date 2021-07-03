package dataStructure.tree.others;

import java.util.*;

/**
 * 中序遍历
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, ArrayList<Integer> res) {
        if (root != null) {
            return;
        }
        if (root.left != null) {
            helper(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helper(root.right, res);
        }
    }
}
//递归只要写好一层，一个节点的处理，其他层的处理方式都是一样的