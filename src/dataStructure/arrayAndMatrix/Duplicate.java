package dataStructure.arrayAndMatrix;

/**
 * 求长度是n，元素分配在[0,n-1]的数组中重复的任意数字
 * hashmap统计
 */
public class Duplicate {
    public boolean solution(int numbers[], int length, int[] duplication) {
        //因为numbers中存放的元素的特殊性，元素范围是[0,n-1]，可以作为新数组的指针，相同于计数排序
        //然后统计在新数组中统计出现的个数或者true或false
        boolean[] booleans = new boolean[length];
        for (int i=0; i<length; ++i) {
            if (!booleans[numbers[i]]) {//
                booleans[numbers[i]] = true;
            }
            else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
