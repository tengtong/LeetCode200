package dataStructure.tree.bst;

import com.sun.deploy.panel.ITreeNode;
import dataStructure.tree.TreeNode;

/**
 * 从有序数组中构造二叉查找树
 */
public class SortedArrayToBST1 {

    //方法：主函数
    public TreeNode SortedArrayToBST1(int[] nums){
        return toBST(nums,0,nums.length-1);
    }

    //方法：辅助方法，通过nums的[sIdx,eIdx]构树
    //递归：通过中序遍历的顺序添加树
    private TreeNode toBST(int[] nums,int sIdx,int eIdx){
        int mIdx = (sIdx + eIdx) / 2;
        TreeNode root = new TreeNode(nums[mIdx]);//因为是从无到有的构树，每层的节点都要创建，并相互拼接起来
        root.left = toBST(nums,sIdx,mIdx - 1);
        root.right = toBST(nums,mIdx + 1,eIdx);
        return root;
    }
}
