package dataStructure.tree.others;

/**
 * 将树进行左右镜像对称
 */
//树=递归=只要考虑一层的操作
public class MirrorTree {
    public void mirror(TreeNode root) {
        if(root == null) {//递归的截止条件
            return;
        }
        //执行操作：直接交换左右节点
        //递归都是一直遍历到底层，再开始回弹，方法都是回弹的时候从最底层开始执行的
        //  故交换节点也是从最底层开始执行的，以此实现镜像对称
        TreeNode tmp = null;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //递归
        if (root.left != null)//左节点不为空，递归左节点
            mirror(root.left);
        if (root.right != null)//右节点不为空，递归右节点
            mirror(root.right);
    }
}