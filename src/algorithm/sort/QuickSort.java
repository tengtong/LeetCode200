package algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    //1
    public void sort(int[] array,int begin,int end){
        //截止条件
        if (array.length <= 1 || begin >= end){
            return;
        }
        int pivotIndex = partiton(array,begin,end);//分区，以pivot中心点，分割左右区域
        sort(array,begin,pivotIndex-1);//再细化分区
        sort(array,pivotIndex+1,end);
    }
    //2、分区
    public int partiton(int[] array,int begin,int end){
        int pivot = array[end];
        int pivotIndex = begin;
        for (int i=begin;i<end;i++){
            if (array[i] < pivot){
                if (i>pivotIndex){
                    swap(array,i,pivotIndex);
                }
                pivotIndex++;
            }
        }
        swap(array,pivotIndex,end);
        return pivotIndex;
    }
    public void swap(int[] array,int i,int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,6,8,3,5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
