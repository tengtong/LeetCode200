package dataStructure.arrayAndMatrix;

/**
 * 寻找一个数字在升序数组中出现的次数
 * 有序 == 二分
 */
public class GetNumberOfKTest {
    public int GetNumberOfK(int [] arr , int k) {
        int length = arr.length;
        if(length==0){
            return 0;
        }
        //找到元素中第一个k和最后一个k，然后相减+1就是个数
        int firstK = getFirsrK(arr,0,length-1,k);
        int lastK = getLastK(arr,0,length-1,k);
        if(firstK==-1&&lastK==-1){
            return lastK-firstK+1;
        }
        return 0;
    }
    //二分法找到第一个k
    public int getFirsrK(int[] arr,int start,int end,int k){
        int mid = (start+end)>>1;
        //递归有截止条件
        if(start>end){//判断特殊情况
            return -1;
        }
        if (k<arr[mid]){
            return getFirsrK(arr,start,mid-1,k);
        }else if(k>arr[mid]){
            return getFirsrK(arr,mid+1,end,k);
        }else if(mid-1>=0&&arr[mid-1]==k){//向左寻找第一个k//还需要进一步递归的条件//这里比较特殊，是要找到第一个k，而不是只要找到k，故还需要添加新的条件
            return getFirsrK(arr,start,mid-1,k);
        }else {//都不满足，就是找到了第一个k
            return mid;
        }
    }
    //用二分法找到最后一个k
    public int getLastK(int[] arr,int start,int end,int k){
        int mid = (start+end)>>1;//右移一位即可，就相当于/2
        while(start <= end){
            if(k<arr[mid]){
                end = mid-1;
            } else if(k>arr[mid]){
                start = mid+1;
            } else if(mid+1<=arr.length&&arr[mid+1]==k){
                start = mid+1;
            } else {
                return mid;
            }
            mid = (start+end)>>1;
        }
        return -1;//如果mid没有return，则return -1；
    }
}
