package algorithm.sort;

import java.util.Random;

public class QuickSort2 {
    //方法：排序
    public void sort(int[] arr,int begin,int end){//初始条件由main函数来传递

        if(arr.length<=1 || begin>end){//递归条件最后写，当递归到数组中只剩一个元素时，return，不作处理
            return;
        }
        int pivotIndex = partition(arr,begin,end);
        sort(arr,begin,pivotIndex-1);
        sort(arr,pivotIndex+1,end);
    }
    //方法：分区，根据基准值对数组进行分左右区
    public int partition(int[] arr,int begin,int end){
        //先确定基准pivot和pivotIndex
        Random random = new Random();
        int pivot = arr[end];
        int pivotIndex = begin;
        //遍历数组，对数组进行分区
        for(int i=begin;i<end;i++){
            if(arr[i] < pivot){
                if(i>pivotIndex){
                    swap(arr,i,pivotIndex);
                }
                pivotIndex++;
            }
        }
        swap(arr,pivotIndex,end);
        return pivotIndex;
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}