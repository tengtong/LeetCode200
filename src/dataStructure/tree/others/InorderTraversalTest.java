package dataStructure.tree.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现当前树的中序遍历
 */
public class InorderTraversalTest {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();//用来存结果集
        //这里用一个辅助方法来写递归，因为需要保存list的值
        helper(root,list);
        return list;
    }

    /**
     * 找到当前节点的中序遍历
     * @param root
     * @param list
     */
    public void  helper(TreeNode root,List<Integer> list){

        if(root == null){//最后补上截止条件
            return;
        }

        //当前层操作
        //先找到左孩子的中序遍历
        if(root.left != null){
            helper(root.left,list);
        }
        //再添加中间节点的值
        list.add(root.val);
        //再找到右孩子的中序遍历
        if(root.right != null){
            helper(root.right,list);
        }
    }
}
