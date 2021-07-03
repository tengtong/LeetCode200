package dataStructure.tree.others;
import java.util.*;

/**
 * 将二叉搜索树转换成一个排序的双向链表
 * 二叉搜索树的中序遍历是（左、中、右）=》（小、中、大）
 */
public class aaaConvert {
    public TreeNode solution(TreeNode pRootOfTree) {
        //先判断特殊情况
        if (pRootOfTree == null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();//用栈来存放结果集
        TreeNode p = pRootOfTree;//备份根结点/不破坏原结构
        TreeNode pre = null;//用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while (p != null || !stack.isEmpty()) {//节点不为null 或者 栈不为空
            while (p != null) {//遍历树//往栈中压入链表的左节点，直至叶节点
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();//压出栈中的左节点，栈顶是叶节点
            if (isFirst) {
                pRootOfTree = p;//将中序遍历序列中的第一个节点记为pRootOfTree
                pre = pRootOfTree;
                isFirst = false;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;
    }

    /**
     *
     * @param root
     * @return
     */
    public TreeNode solution1(TreeNode root) {
        if(root==null)//判断特殊情况
            return null;
        if(root.left==null&&root.right==null)//递归截止条件
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = solution1(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = solution1(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }
}
//拷贝树或者链表，有时候只拷贝头节点，在处理时内部的Node没准会发生变化，也会出现拷贝