package dataStructure.tree.others;

/**
 * 给定一个二叉树和其中的一个结点，找出中序遍历顺序的下一个结点
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //1、先判断特殊情况
        if (pNode == null)
            return null;
        //2、如果存在右节点，则下个节点是右子数中最左侧的节点
        if (pNode.right != null){
            pNode = pNode.right;
            //找到右子树中最左侧的节点
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        //3、不存在右节点的话，判断父节点是否为空
        while (pNode.next != null){
            TreeLinkNode proot = pNode.next;
            if (proot.left == pNode) {//如果当前结点就是父节点的左节点，则下一节点就是其父节点
                return proot;
            }
            //如果不满足上述条件，则表示该节点是右子树节点，找他的父节点的父节点的父节点...直到当前结点是其父节点的左孩子位置
            pNode = pNode.next;
        }
        return null;
    }
}
