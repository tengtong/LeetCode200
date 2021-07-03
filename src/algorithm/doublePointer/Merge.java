package algorithm.doublePointer;

/**
 * 把归两个数组
 * 双指针，一个放在num1上，一个放在num2上
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output:
 * [1,2,2,3,5,6]
 */
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 2;int index2 = 2;//双指针
        int newIndex = 5;
        //遍历两个数组，从小到大的排入num1中
        //这里情况比较特殊，最后结果放在num1中，故需要从后往前存，从大到小
        while (newIndex>0){
            if(index1==0 || index2!=0){
                nums1[newIndex--]=nums2[index2--];
            }else if(index2==0 || index1!=0){
                nums1[newIndex--]=nums1[index1--];
            }else if(nums1[index1]>nums2[index2]){
                nums1[newIndex--]=nums1[index1--];
            }else {
                nums1[newIndex--]=nums2[index2--];
            }
        }
    }

    public static void main(String[] args) {
        int [] num1 = {1,2,3,0,0,0};
        int [] num2 = {2,5,6};
        Merge.merge(num1,3,num2,3);
        for(int n:num1){
            System.out.print(n+" ");
        }
    }
}
