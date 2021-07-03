package dataStructure.tree.bst;

import dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找二叉查找树中出现次数最多的值
 * 思路1：中序遍历全树，得到arrs，再用hashMap统计次数
 * 思路2：两次递归，一次递归遍历全部，二次递归，找出所有与当前节点相同的节点
 *       因为二叉查找树，左<=中<=右，值相同的值只会出现在相邻节点，故用两次递归可以统计
 *       一次递归，遍历全树。二次递归，找出所有值相同的节点，且用curCnt计数，然后比对多个curCnt找出maxCnt
 *       递归在逻辑上就等于循环，内部逻辑相同的话，时间复杂度也相同，只是实现方式不同而已
 * Input：
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 * return [2].
 */
public class FindMode {
    private int curCnt = 1;//当前统计次数
    private int maxCnt = 1;//最多出现次数
    private TreeNode preNode = null;//这里要设置前驱节点，这样才能与当前节点的值进行比较，

    //方法：主函数
    public int[] findMode(TreeNode root){
        List<Integer> maxCntNums = new ArrayList<>();//最多出现次数的val值集合//这里先用了ArrayList是为了方便add
        inOrder(root,maxCntNums);//中序遍历为了找出maxCntNums//这里将maxCntNums对象的引用地址传入，inOrder方法在操作
        int[] ret = new int[maxCntNums.size()];//将ArrayList全部存入int[]
        int idx = 0;
        for (int num:maxCntNums){
            ret[idx++] = num;
        }
        return ret;
    }

    //方法：中序遍历，找出出现次数最多的val值（答案可能不止一个）
    //递归：递归处理时，左右节点的处理直接交给递归，我们只要集中处理中间节点node即可
    //     因为树中在一层来看，他是一个中间节点，然后再加上左节点和右节点
    //     但是从全树来看，它都是一个一个node拼接而成的，左右节点只是节点之间的逻辑关系
    //     所以在递归时，我们会遍历所有的节点，每个节点都会进入 inOrder(node) ，进行一遍的业务操作
    private void inOrder(TreeNode node, List<Integer> nums){
        if (node == null) return;//截止条件，这里只是统计次数
        //递归左节点
        inOrder(node.left,nums);
        //处理node，一次递归只处理一个node
        //方法的目的是为了找出出现次数最多val值，即要先统计当前node的val值
        //这里的统计是和preNode的val进行比较，才知道当前节点是否和前驱节点的val一致，也因为这个是二叉查找树，左<=中<=右，故相同节点有的话，一定在左右节点上，这里也是按中序遍历的顺序进行遍历的，保证了val值之间的大小顺序
        if (preNode != null){
            if (preNode.val == node.val) curCnt++;
            else curCnt = 1;
        }
        //统计完当前节点的val值后，判断curCnt和maxCnt的大小，判断当前节点的出现次数是否为最多，如果是，更新nums数组中的内容，更新maxCnt
        //maxCnt是出现的最大次数，nums是结果集存放出现最大次数的元素值(一组元素只add一个，这也与输出要求相符，如果出现次数相同，则也添加到nums中)
        if (curCnt > maxCnt){
            maxCnt = curCnt;
            nums.clear();//nums必须有个clear操作，这样保证更新maxCnt的同时，也更新nums，故用Set并没有什么区别，因为这里nums是和maxCnt一起更新的//一次递归只处理一个node//处理当前node时，只要符合条件，nums数组会先清零，再添加，这样能保证nums只存放Cnt为为最大的元素（允许存放Cnt相同，但val不同的节点）
            nums.add(node.val);//并将当前node.val添加到nums
        } else if (curCnt == maxCnt){
            nums.add(node.val);//如果出现次数相同，也添加到nums中
        }
        //处理完node，更新preNode
        preNode = node;
        //递归右节点
        inOrder(node.right,nums);
    }
}
