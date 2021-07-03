package dataStructure.tree.noRecursionTraversal;

import dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归实现中序遍历
 * 中序遍历：左中后
 * 思路：
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ret = new ArrayList<>();//结果集
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ret;
        TreeNode cur = root;//这里不能先往栈里添加root，中序遍历是左中右，故栈里先压入左节点
        while (cur != null || !stack.isEmpty()){
            //先遍历和添加完左子树
            while (cur != null){
                stack.push(cur);//压入
                cur = cur.left;
            }
            TreeNode node = stack.pop();//实际顺序的是按出栈顺序来
            ret.add(node.val);
            cur = node.right;
        }
        return ret;
    }
}
