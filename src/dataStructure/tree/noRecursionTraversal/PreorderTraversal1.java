package dataStructure.tree.noRecursionTraversal;

import dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归实现前序遍历
 * 思路：dfs-栈
 */
public class PreorderTraversal1 {
    public List<Integer> preorderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;//因为这里是对整棵树的所有节点进行遍历，可能出现部分节点不存在，故需要contiue
            res.add(node.val);//添加中间节点
            stack.push(node.right);
            stack.push(node.left);
        }
        return res;
    }
}
