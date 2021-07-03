package algorithm.sort;

import java.util.*;

/**
 * 找到倒数第K个元素
 * Input: [3,2,1,5,6,4] and K=2
 * Output: 5
 * 思路：小顶堆、快速选择（TopK Elements问题，找到Kth Element元素，再遍历一边数组找出比这个元素大的所有元素）
 */
public class KthElement {

    //方法一：快排，时间复杂度O(nlogn)，空间复杂度O(1)
    public int solution1(int[] nums,int k){
        Arrays.sort(nums);
        return nums[nums.length-k];//第k的值，这里k指的是位置/坐标，即倒数第k个，倒数第一个坐标为nums.length-1，即k=1
    }

    //方法二：堆，时间复杂度O(nlogn)，空间复杂度O(K)
    public int solution2(int[] nums,int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();//PriorityQueue默认是小顶堆，可以通过改变比较器参数的方法修改为大顶堆
        for(int val:nums){
            heap.add(val);
            //求第k=2大的元素，因为是小顶堆，堆顶元素比堆中的任意元素都小，当heap.size()==2时，堆顶就是第2大的元素
            //即设置堆的大小，并把数组的所有元素都添加到堆中，然后最后的堆顶就是第k大的元素
            //如果是大顶堆的话，heap.size()=nums.length-k，堆内元素都比堆顶小，堆顶即为第k大的元素
            if(heap.size()>k){//维护堆的大小为k
                heap.poll();//poll方法用于检索和删除队列的开头
            }
        }
        return heap.peek();
    }

    //方法三：快速选择，利用快排的partition思想，时间复杂度O(n)，空间复杂度O(1)，根据返回的基准坐标的大小修改循环区间
    public int solution(int[] nums,int k){
        k = nums.length - k;//转换成倒数第K大的元素，这样只要找到左侧个数k-1个的基准，则该基准元素即为所求
        int begin = 0, end = nums.length-1;
        while(begin < end){
            int j = paratition(nums,begin,end);//返回的是基准坐标
            if (j==k){
                break;
            } else if ( j<k ){//根据基准坐标大小修改partition的下标
                begin = j+1;
            } else if ( j>k ){
                end = j-1;
            }
        }
        return nums[k];//这里原来的数组nums是乱序的，经过while跳出来的数组至少能保证坐标k左侧的元素都比nums[k]小，即nums[k]为倒数第k大的元素
    }
    //paratition，在数组nums从i到length元素中，找出基准坐标，随机选择一个数，然后对该范围的数组进行分区
    private int paratition(int[] nums,int begin,int end){
        int pivot = nums[end];//每次都选择最后一个容易导致出现最坏情况，时间复杂度为O(n*n)
        int pivotIndex = begin;
        for(int i=begin;i<end;i++){
            if (pivot>nums[i]){
                if (pivotIndex<i){
                    swap(nums,i,pivotIndex);
                }
                pivotIndex++;
            }
        }
        swap(nums,pivotIndex,end);
        return pivotIndex;
    }
    //交换
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
