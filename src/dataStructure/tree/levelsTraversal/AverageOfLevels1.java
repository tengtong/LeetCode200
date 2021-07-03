package dataStructure.tree.levelsTraversal;

import dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 计算一棵树每层节点的平均数
 */
public class AverageOfLevels1 {
    public List<Double> averageOfLevels(TreeNode root){
        if (root == null) return null;
        List<Double> res = new ArrayList<>();//结果集
        Queue<TreeNode> queue = new LinkedList<>();//存放每层的节点
        queue.add(root);
        while (!queue.isEmpty()){
            int cnt = queue.size();
            double sum = 0;
            for (int i = 0;i<cnt;i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
            Double ave = sum / cnt;
            res.add(ave);
        }
        return res;
    }
}
