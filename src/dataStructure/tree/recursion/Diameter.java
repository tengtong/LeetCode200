package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 递归
 * 一棵树要么是空树，要么有两个指针，每个指针指向一棵树。树是一种递归结构，很多树的问题可以使用递归来处理
 * ps：递归在逻辑上就等于循环，内部逻辑相同的话，时间复杂度也相同，只是实现方式不同而已
 */


/**
 * 两节点的最长路径
 *           1
 *         /  \
 *       2     3
 *    /   \
 *  4       5
 *  result: [4,2,1,3] or [5,2,1,3]
 *
 *  思路：最长路径 = max(统计每个节点的左节点高度 + 右节点高度)
 *       因为最大路径也不一定过root节点，只要左右侧节点高度和够大即可
 */

/**
 * 总结：在递归中，树可以化简成一个简单的二叉节点
 *              1
 *            /  \
 *          2     3
 */
public class Diameter {

    private int max = 0;//max记录最大路径值

    public int diameter(TreeNode root){
        depth(root);
        return max;
    }

    private int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        //统计每个节点的左右节点高度，更新max
        int leftDepth = depth(root.left);//统计root.left的高度
        int rightDepth = depth(root.right);
        max = Math.max(max,leftDepth + rightDepth);
        //统计当前节点的深度（以用来在递归中查询当前节点的左右子节点的高度）
        int rootDepth = Math.max(leftDepth,rightDepth) + 1;
        return rootDepth;
    }
}
