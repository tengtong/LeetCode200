package dataStructure.tree.levelsTraversal;

import dataStructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 得到左下角的节点
 */
public class BottomLeft {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {//一个while就是一个队列，一层节点
            root = queue.poll();//更新root
            //这里是先添加右节点、左节点，那么队列末就是最左侧的左节点，故while循环结束之后，上面更新了root节点，故最后的节点就是最左侧的节点
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }
}
