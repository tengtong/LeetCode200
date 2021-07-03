package dataStructure.tree.others;

/**
 * 判断二叉树是否平衡
 * 二叉树==递归
 * 平衡：左右孩子节点深度差<=1
 */
public class IsBalancedTest {
    public boolean solution(TreeNode root){
        if(root==null){
            return false;
        }
        return helper(root)!=-1?true:false;
    }
    //判断主体，判断一个节点的左右孩子深度差是否<=1，
    //递归判断全树
    //如果深度差>1，即不平衡则return -1;
    //输出：当前节点的深度，若不平衡则返回-1
    public int helper(TreeNode root){
        if(root == null){//叶节点的深度为0//截止条件
            return 0;
        }
        int depthLeft = helper(root.left);//左孩子节点的深度
        //这里需要先对depthLeft进行判断，如果是depthLeft==-1，则直接return -1；不然若depthRight==-1，两个相减==0，会出现bug
        if(depthLeft==-1){
            return -1;
        }
        int depthRight = helper(root.right);//右孩子节点的深度
        if(depthRight==-1){//同理
            return -1;
        }
        if(Math.abs(depthLeft-depthRight)<=1){//若|左孩子-右孩子|<=1，则当前root是平衡的
            return 1+Math.max(depthLeft,depthRight);//返回当前节点的深度，便于上一级进行判断
        }else {
            return -1;//结束循环，有一处不平衡就直接返回判断结果
        }
    }
}
//错误记录
//if (root.left==null){
//      return 0;
//}else if(root.right==null){//同理
//      return 0;
//}
//递归的最底层一般是叶节点，即root==null，我这里使用倒数第二节点当底层
//递归就要考虑最底层情况，树的最底层是叶节点
