package dataStructure.tree.recursion;

import dataStructure.tree.TreeNode;

public class PathSum1 {

    //方法：递归树
    public int pathSum1(TreeNode root,int sum){
        if (root == null) return 0;//判断特殊情况
        int res = 0;
        res = pathSumStartWithRoot(root,sum) + pathSum1(root.left,sum) + pathSum1(root.right,sum);
        return res;
    }

    //方法：从当前节点开始递归寻找符合条件的路径
    private int pathSumStartWithRoot(TreeNode root,int sum){
        //截止条件
        int res = 0;
        if (root == null) return 0;
        if (root.val == sum) res++;//只有找到符合条件的完整路径，才有res+1
        //这里res的自加只是为了保证当 符合上述if语句时 把在if中res累加一次的结果 在最后res统计中进行一次计算进来
        //即这里不写 res = helperStartWithRoot() + helperStartWithRoot();
        //只是为了记录当前节点符合条件时的结果值进行一次保存
        //即只有在 if(root.val == sum) 成立时
        //   res = 1 + helperStartWithRoot() + helperStartWithRoot();
        //平常都相当于
        //   res = 0 + helperStartWithRoot() + helperStartWithRoot();
        res = res + pathSumStartWithRoot(root.left,sum-root.val) + pathSumStartWithRoot(root.right,sum-root.val);
        return res;
    }
}
