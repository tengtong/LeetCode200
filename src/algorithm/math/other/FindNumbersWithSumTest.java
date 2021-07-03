package algorithm.math.other;

import java.util.ArrayList;

/**
 * 在数组中寻找和为s的乘积最小的两个数
 * 输入：arr、sum
 * 输出：list（a和b）
 */
public class FindNumbersWithSumTest {
    public ArrayList<Integer> solution(int [] arr, int sum) {
        if(arr==null){
            return null;
        }
        int i=0;int j=arr.length-1;//设置数组的头尾指针
        ArrayList<Integer> list = new ArrayList<>();//存放结果集
        while (i<j){
            int cur = arr[i]+arr[j];
            if(cur==sum){
                list.add(i);
                list.add(j);
                break;
            }else if(cur < sum){
                i++;
            }else if(cur > sum){
                j--;
            }
        }
        return list;
    }
}
