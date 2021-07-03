package others;

import java.util.*;

public class QuickSort {
    public void solution(int[] arr,int begin,int end){
        if (arr.length <= 1 || arr ==null || begin > end){
            return;
        }
        int pivotIndex = partition(arr,0,arr.length);
        solution(arr,pivotIndex+1,arr.length);
        solution(arr,0,pivotIndex-1);
    }
    private int partition(int[] arr,int begin,int end){
        int pivot = arr[end];
        int pivotIndex = begin;
        for (int i=begin;i<end;i++){
            if (arr[i] < pivot){
                if (i > pivotIndex){
                    swap(arr,pivotIndex,i);
                }
                pivotIndex++;
            }
        }
        swap(arr,end,pivotIndex);
        return pivotIndex;
    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
