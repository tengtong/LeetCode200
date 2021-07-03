package dataStructure.tree.bst;

import dataStructure.tree.TreeNode;

/**
 * 从有序数组中构造二叉查找树
 * 思路：按中序遍历的顺序进行构树
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums){
        return toBST(nums,0,nums.length-1);
    }

    //方法：从nums的[sIdx,eIdx]构建一个树TreeNode
    //递归：只要考虑一层，三个节点的逻辑即可
    private TreeNode toBST(int[] nums,int sIdx,int eIdx){//sIdx: startedIndex
        if (sIdx > eIdx) return null;
        int mIdx = (sIdx + eIdx) / 2;
        TreeNode root = new TreeNode(nums[mIdx]);//mIdx是根节点
        root.left = toBST(nums,sIdx,mIdx - 1);//构建左子树，并实现拼接
        root.right = toBST(nums,mIdx + 1,eIdx);//构建右子树，并实现拼接
        return root;
    }
}
