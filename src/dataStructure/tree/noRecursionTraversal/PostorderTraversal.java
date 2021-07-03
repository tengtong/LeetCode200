package dataStructure.tree.noRecursionTraversal;

import dataStructure.tree.TreeNode;

import java.util.*;

/**
 * 非递归实现后序遍历
 * 思路：前序遍历为 root -> left -> right，后序遍历为 left -> right -> root
 *      可以修改前序遍历成为 root -> right -> left，那么这个顺序就和后序遍历正好相反。
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(ret);
        return ret;
    }
}
