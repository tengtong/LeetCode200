package algorithm.math.other;

import java.util.*;

/**
 * 在数组中寻找和为s且乘积最小的两个数
 * 距离越远，乘积最小
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> solution(int [] array, int sum) {
        ArrayList res = new ArrayList();
        int length = array.length;
        int i = 0, j = length - 1;
        while(i < j){//循环条件已知的用for循环，未知的用where循环//遍历数组，这里设置双指针i、j，因为这里有两个变量有两个判断条件，所以不方便写在for循环里
            if(array[i] + array[j] == sum){
                res.add(array[i]);
                res.add(array[j]);
                break;
            }
            while(i < j && array[i] + array[j] > sum) j--;//一直向左收缩j，直到找到之和为sum的j
            while(i < j && array[i] + array[j] < sum) i++;
        }
        return res;
    }
}
