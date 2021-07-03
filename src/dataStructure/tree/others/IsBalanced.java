package dataStructure.tree.others;

/**
 * 判断一棵二叉树是否平衡
 * 平衡：高低深度差<=1
 * 输入：树
 * 输出：true or false
 */
public class IsBalanced {
    public boolean solution(TreeNode root) {
        return getDepth(root) != -1;
    }
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;//截止条件
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;//如果哪一层是-1，表示当层就不平衡，直接退出//return也可以当break用，而且是直接结束函数，比break还要厉害
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;//如果哪一层是-1，表示当层就不平衡，直接退出
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);//|左-右|>1，就返回-1退出，不然就返回树的高度
    }
}
