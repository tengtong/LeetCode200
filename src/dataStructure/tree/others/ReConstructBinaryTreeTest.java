package dataStructure.tree.others;

/**
 * 根据前序遍历和中序遍历重建树
 * 前序：中左右
 * 中序：左中右
 */
public class ReConstructBinaryTreeTest {
    public TreeNode reConstructBinaryTree(int[] pre,int[] in){
        TreeNode root = helper(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //方法：根据当前序列重建树(最简单的树：左节点、中间节点、右节点)
    //辅助函数，帮助实现递归
    //递归，只要实现当前层，再加上截止条件，其他层会自动实现的
    //重建当前层的结构，思路：前序节点提供中间节点，中序节就可以分割序列为(左,中,右),然后反向给前序节点提供左侧序列长度，以此分割前序序列
    public TreeNode helper(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){

        //截止条件
        if(startPre > endPre || startIn > endIn){
            return null;//这里return 是根据方法的返回值确定的
        }

        //先找到中间节点
        int mid = pre[startPre];
        TreeNode node = new TreeNode(mid) ;
        //遍历中序节点，分割序列
        for(int i=startIn;i<endIn;i++) {
            if (in[i] == mid) {
                //重建当前节点的左右节点
                //in:[startIn,i-1]i[i+1,endIn]
                //pre：startPre[startPre+1,startPre+1+(i-1-startIn)][startPre+i-startIn+1,endPre]
                node.left = helper(pre, startPre, startPre + i - startIn, in, startIn, i - 1);
                node.right = helper(pre, i + 1, endIn, in, startPre + i - startIn + 1, endPre);
            }
            break;
        }
        return node;
    }
}
