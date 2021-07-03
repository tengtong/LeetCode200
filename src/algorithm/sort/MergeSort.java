package algorithm.sort;

import java.util.*;

public class MergeSort {
    /**
     * 主函数，递归分治
     * @param arr
     * @return
     */
    public int[] solution(int[] arr){
        int len = arr.length;
        int mid = len / 2;
        if(len <= 1){//递归要写截止条件
            return arr;
        }
        int[] left = Arrays.copyOfRange(arr,0,mid);//Arrays是数组的工具类，Collections是集合的工具类，这里Arrays和ArrayList可不相同
        int[] right = Arrays.copyOfRange(arr,mid,len);
        return merge(solution(left),solution(right));
    }

    /**
     * 两个数组排成一个新数组，双指针法
     * @param left
     * @param right
     * @return 返回一个排好序的新数组
     */
    private int[] merge(int[] left,int[] right){
        int[] newArr = new int[left.length + right.length];
        int lindex = 0;
        int rindex = 0;
        for(int i = 0; i < newArr.length; i++){
            if (lindex >= left.length){
                newArr[i] = right[rindex++];
            }else if (rindex >= right.length){
                newArr[i] = left[lindex++];
            }else if (left[lindex] < right[rindex]){//决定了整个数组是从小到大的排序方式
                newArr[i] = left[lindex++];
            }else {
                newArr[i] = right[rindex++];
            }
        }
        return newArr;
    }
}
