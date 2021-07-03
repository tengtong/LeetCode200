package dataStructure.arrayAndMatrix;

/**
 * 统计一个数字在升序数组中出现的次数
 * 有序==二分，找到第一个k，再找到最后一个k，然后相减+1就是个数
 *
 */
public class GetNumberOfK {
    public int solution(int [] array , int k) {
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int firstK = getFirstK(array, k, 0, length-1);//通过二分查找，找到第一个k
        int lastK = getLastK(array, k, 0, length-1);//通过二分查找，找到最后一个k
        if(firstK != -1 && lastK != -1){//只要firstK和lastK不是特殊情况，相减+1就是个数
            return lastK - firstK + 1;
        }
        return 0;
    }
    //二分查找
    //递归写法
    private int getFirstK(int [] array , int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if(array[mid] > k){//如果k<arr[mid]，说明区间在左侧，重新缩小区间
            return getFirstK(array, k, start, mid-1);
        }else if (array[mid] < k){//同理
            return getFirstK(array, k, mid+1, end);
        }else if(mid-1 >=0 && array[mid-1] == k){//进入了有k值的范围区间，开始寻找第一个k//arr[mid]的前一个元素index>=0且大小也为k时，缩小范围继续寻找
            return getFirstK(array, k, start, mid-1);
        }else{
            //直到不满足上述条件时，即array[mid]=k，mid-1<0 或 arr[mid-1]!=k
            return mid;
        }
    }
    //循环写法
    private int getLastK(int [] array , int k, int start, int end){
        int length = array.length;
        int mid = (start + end) >> 1;
        //while循环，每次循环都会进入一个判断语句，然后执行一些操作，完成一次循环，等再次进入循环，会再次进入一个判断语句...
        while(start <= end){
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1 < length && array[mid+1] == k){
                start = mid+1;
            }else{
                //直到不满足上述条件时，即array[mid]=k，且array[mid+1]!=k 或 mid+1 >= length
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }
}
