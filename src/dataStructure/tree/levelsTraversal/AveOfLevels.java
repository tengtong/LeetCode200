package dataStructure.tree.levelsTraversal;

/**
 * 层次遍历
 * 使用BFS进行层次遍历，不需要使用两个队列来分别存储当前层的节点和下一层的节点，因为在开始遍历一层的节点时，
 * 当前队列中的节点数就是当前层的节点数，只要控制遍历这么多节点数，就能保证这次遍历的都是当前层的节点
 */

import dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历：
 * 使用BFS进行层次遍历，不需要使用两个队列来分别存储当前层的节点和下一层的节点。
 * 因为在开始遍历一层的节点时，当前队列中的节点数就是当前层的节点数，只要控制遍历这么多节点数，就能保证这次遍历的都是当前层的节点
 * （因为是二叉，每层的节点数量是固定的，空的为null）
 */

/**
 * 求一颗树每层节点的平均数
 * 思路：BFS，遍历每层的节点，遍历时再往队列中添加当前节点的左右孩子节点
 */
public class AveOfLevels {

    //方法：BFS，队列，什么时候往队列中添加元素
    public List<Double> averageOfLevels(TreeNode root){
        List<Double> res = new ArrayList<>();//结果集
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int cnt = queue.size();//cnt count
            double sum = 0;
            for (int i = 0;i < cnt;i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(sum / cnt);
        }
        return res;
    }
}
