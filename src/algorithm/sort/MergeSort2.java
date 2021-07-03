package algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort2 {

    //方法：递归将数组分为左、右数组,"分"
    public int[] solution(int[] arr){
        int len = arr.length;
        int mid = len / 2;
        //截止条件
        if (len <= 1){
            return arr;
        }
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,len);
        return merge(solution(left),solution(right));
    }

    //方法：将两个小数组排序并归并成一个大数组，"治"
    public int[] merge(int[] right,int[] left){
        int[] newArr = new int[right.length + left.length];
        int rightIndex = 0, leftIndex = 0;
        for (int i=0;i<newArr.length;i++){
            if (rightIndex >= right.length){
                newArr[i] = left[leftIndex++];
            }else if (leftIndex >= left.length){
                newArr[i] = right[rightIndex++];
            }else if (left[leftIndex] < right[rightIndex]){
                newArr[i] = left[leftIndex++];
            }else {
                newArr[i] = right[rightIndex++];
            }
        }
        return newArr;
    }

}
