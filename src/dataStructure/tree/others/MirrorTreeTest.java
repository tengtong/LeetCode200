package dataStructure.tree.others;

/**
 * 返回当前树的镜像树
 * 交换左右节点
 */
public class MirrorTreeTest {
    public void mirror(TreeNode root) {
        if(root == null){
            return;
        }
        //当前层操作
        TreeNode temp;
        temp = root.right;
        root.right = root.left;
        root.left = temp;
        if(root.left != null){//因为递归是从底层回弹回来的，所以"当前层操作"最先是最底层实现的
            mirror(root.left);
        }
        if(root.right != null){
            mirror(root.right);
        }
    }
}
