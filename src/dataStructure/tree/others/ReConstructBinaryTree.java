package dataStructure.tree.others;

/**
 * 重建二叉树
 * 输入前序遍历和中序遍历，重建二叉树
 * 中序遍历可以提供中间节点
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {//pre前序，in中序
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //方法：根据当前的中序和前序序列，重建对应的树
    //递归，一般都是通过输入和返回值确定方法作用，然后写根节点这一层，再补上截止条件就可以了，中间层会自动实现的
    private TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn) {//重载函数，根据输入的参数选择对应的函数
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode node=new TreeNode(pre[startPre]);//前序遍历的节点是第一个元素//前序遍历只是提供中间节点
        //遍历中序序列
        for(int i=startIn;i<=endIn;i++) {
            if (in[i] == pre[startPre]) {//当找到中间节点时，左侧就是左孩子节点，右侧就是右孩子节点
                //先根据 中间节点 将中序遍历的（左，中，右）三个部分从序列中分开 ====》[startIn,i-1]i[i+1,endIn] ====》确定左侧序列的长度：(i-1)-startIn
                //再根据 左侧序列长度 将前序序列（中，左，右）三个部分从序列中分开 ====》startPre[startPre+1,startPre+i-startIn][startPre+i-startIn+1,endIn]
                //根据中序遍历左侧序列重建左节点
                node.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);//根据前序遍历、中序遍历的左侧序列重建左节点
                //根据中序遍历右侧序列重建右节点
                node.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);//同理
            }
        }
        return node;
    }
}
