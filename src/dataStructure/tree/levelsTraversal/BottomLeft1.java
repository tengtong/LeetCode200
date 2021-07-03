package dataStructure.tree.levelsTraversal;

import dataStructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 得到左下角的节点
 *
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 *
 * 思路：先找到最后一层，然后再找最左侧的节点，只要每层都往队列里从左到右的添加元素，最后一层的queue的第一个元素，就是最后一层最左侧的节点
 */
public class BottomLeft1 {
    //方法：找到最后一层的左节点（一般只有一个方法就是题目的要求，如果两个及以上就要判断一下了）
    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (i == 0) res = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }
}
