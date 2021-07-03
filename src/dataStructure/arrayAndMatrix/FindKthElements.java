package dataStructure.arrayAndMatrix;

/**
 * 找到第k大的数字
 */
import java.util.*;
public class FindKthElements {
    public ArrayList<Integer> findKthElements2(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(arr.length <= 0 || arr == null || arr.length < k) {
            return res;
        }
        for(int i = 0;i < k;i ++) {
            int maxValueIndex = this.getMaxValueIndex(arr, k);
            if(arr[maxValueIndex] > arr[i]) {
                int temp = arr[maxValueIndex];
                arr[maxValueIndex] = arr[i];
                arr[i] = temp;
            }
        }
        for(int i = 0;i < k;i ++) {
            res.add(arr[i]);
        }
        return res;
    }
    //选择排序：选出最大值的下标
    public int getMaxValueIndex(int[] arr, int k) {//在index=k之后寻找数组中的最大值
        int maxValueIndex = k;
        for(int i = k + 1;i < arr.length;i ++) {
            if(arr[i] > arr[maxValueIndex]) {
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        FindKthElements fke = new FindKthElements();
        ArrayList<Integer> list = fke.findKthElements2(arr,3);
        for(Integer l:list){
            System.out.print(l);
        }
    }
}
