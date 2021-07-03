package dataStructure.tree.others;

import java.util.*;
/**
 * 把二叉树打印成多行
 */
public class Print {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();//每个ArrayList<Integer>代表一层
        depth(pRoot, 1, list);
        return list;
    }
    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if (root == null) return;//截止条件
        //动态扩容
        if (depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth - 1).add(root.val);//递归过程//"depth-1"取的是数组的下标，初始层数是1
        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }
}
