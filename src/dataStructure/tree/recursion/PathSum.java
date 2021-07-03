package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

/**
 * 统计指定路径和存在的数量，路径不一定以root开头，也不一定以leaf结尾，但是必须要连续
 * 思路：这里与其他递归不同的是，不是遍历整颗树，只是在树中寻找符合条件的连续的节点
 *      故用 helperStartWithRoot 来递归判断从当前节点开始是否有符合的连续节点
 *      solution 只是用来递归遍历树中的每个节点，再用 helperStartWithRoot 对每个节点进行判断
 *      以此实现对每个节点的查询，即使用了两个递归进行判断
 */
public class PathSum {

    public int pathSum(TreeNode root,int sum){
        if (root == null){
            return 0;
        }
        int res = pathSumStartWithRoot(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
        return res;
    }
    //方法：
    private int pathSumStartWithRoot(TreeNode root,int sum){
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) {
            res++;
        }
        res += pathSumStartWithRoot(root.left,sum - root.val) + pathSumStartWithRoot(root.right,sum - root.val);
        return res;
    }
}
