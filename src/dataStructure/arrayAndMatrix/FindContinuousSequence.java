package dataStructure.arrayAndMatrix;

import java.util.*;

/**
 * 和为s的连续正数序列（至少包括两个）
 * 滑动窗口
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > solution(int sum) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();//存放结果
        int plow = 1,phigh = 2;//两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        while(phigh > plow){
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;//由于是连续序列，有求和公式是
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();//相等，那么就将窗口范围的所有数添加进结果集
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;//记录一个list后，plow++，开始寻找下一个符合条件的窗口
            }else if(cur < sum){
                phigh++;//如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else{
                plow++;//如果当前窗口内的值之和大于sum，那么左边窗口右移一下
            }
        }
        return result;
    }
}
