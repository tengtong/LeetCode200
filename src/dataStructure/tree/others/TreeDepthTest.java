package dataStructure.tree.others;

/**
 * 取当前节点的深度
 * 当前节点的深度=Math.max(左孩子深度，右孩子深度)+1
 */
public class TreeDepthTest {
    public int treeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        //当前层操作
        int left = treeDepth(root.left);//递归入口//当前节点左孩子的深度
        int right = treeDepth(root.right);
        return Math.max(left,right)+1;
    }
}
