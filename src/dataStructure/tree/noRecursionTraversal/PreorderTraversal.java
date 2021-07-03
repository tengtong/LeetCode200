package dataStructure.tree.noRecursionTraversal;

import dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前中后序遍历，DFS
 *
 * void preDfs(TreeNode root){
 *     visit(root);
 *     preDfs(root.left);
 *     preDfs(root.right);
 * }
 *
 * void inDfs(TreeNode root){
 *     inDfs(root.left);
 *     visit(root);
 *     inDfs(root.right);
 * }
 *
 * void postDfs(TreeNode root){
 *     postDfs(root.left);
 *     postDfs(root.right);
 *     visit(root);
 * }
 *
 */

/**
 * 非递归实现二叉树的前序遍历
 * 前序遍历：中左右
 * 栈：用栈来保存当前节点信息，当遍历新节点返回时能够继续遍历当前节点，可以使用递归栈
 * 思路：bfs是广度优先，即队列中只要存一层的结果值就可以了（同一维度的点），不用走回头路，是一次性对所有方向都开始走
 *      dfs是深度优先，即需要用栈来保存一个方法的路径值，使用栈能在一条路走不通时保证回到出发点，再重新从另一个方向走
 *      即dfs一次只走一个方向，bfs同时走所有方向
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> ret = new ArrayList<>();//结果集
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//压入
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);//先添加中间节点
            stack.push(node.right);//先右后左，保证左子树先遍历；后面再取的时候会先弹出左节点进行统计
            stack.push(node.left);
        }
        return ret;
    }
}
