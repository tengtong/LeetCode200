package algorithm.search.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出二叉树中所有从根到叶子的路径
 * Input：
 *   1
 *  /  \
 * 2    3
 *  \
 *   5
 * output：["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    public List<String> binayTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        //特殊情况
        if (root == null) {
            return paths;
        }
        List<Integer> values = new ArrayList<>();
        backtracking(root, values, paths);
        return paths;
    }

    /**
     * 回溯
     * @param node
     * @param values 临时集
     * @param paths 结果集
     */
    private void backtracking(TreeNode node, List<Integer> values, List<String> paths) {
        //递归出口
        if (node == null) {
            return;
        }
        //先添加当前节点到临时路径中
        values.add(node.val);
        //做一下判断，如果当前节点是叶节点，则表示其中一条路径已经走完，打印出来
        if (isLeaf(node)) {
            paths.add(buildPath(values));
        } else {
            //如果不是叶节点，则对左右节点递归，进行同样操作
            //树的左右节点递归，相当于是for循环过程了
            backtracking(node.left, values, paths);
            backtracking(node.right, values, paths);
        }
        //delete操作，移除已经走过的路径
        values.remove(values.size() - 1);
    }

    /**
     * 判读该节点是否为叶子节点
     * ps：方法单独写出来，是了为了解耦
     * @param node
     * @return
     */
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * 建立路径：将收集到结果调整为输出打印
     * @param values
     * @return
     */
    private String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        //从values中取出，然后循环遍历打印
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            //若打印的不是最后一个元素，则做中间拼接
            if (i != values.size() - 1) {
                str.append("->");
            }
        }
        return str.toString();
    }
}
