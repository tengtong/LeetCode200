package others;

import java.util.*;

public class MergeSort {

    public int[] solution(int[] arr){
        int len = arr.length;
        int mid = len / 2;
        if (arr.length <= 1 || arr ==null){
            return arr;
        }
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,len);
        return merge(solution(left),solution(right));
    }
    private int[] merge(int[] left,int[] right){
        int[] newArr = new int[left.length+right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i=0;i<newArr.length;i++){
            if (leftIndex >= left.length) {
                newArr[i] = right[rightIndex++];
            } else if (rightIndex >= right.length){
                newArr[i] = left[leftIndex++];
            } else if(left[leftIndex] < right[rightIndex]){
                newArr[i] = left[leftIndex++];
            } else {
                newArr[i] = right[rightIndex++];
            }
        }
        return newArr;
    }
}
