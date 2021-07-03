package algorithm.sort;

import java.util.Arrays;

/**
 * 荷兰国旗，三向切分（小于切分元素，等于切分元素，大于切分元素）
 * Input: [2,0,2,1,1,0]，只有0/1/2三种元素
 * Output: [0,0,1,1,2,2]
 */
public class SortColors {
    //方法一：分区
    public static void solution(int[] nums){
        int zero = -1, one = 0, two = nums.length;//代表三个颜色//zero是左区间，one是基准，two是右区间
        while(one<two){
            if(nums[one] == 0){//one就是基准坐标，num[0]==0，也就是等于，判断基准位置的元素是否比基准小
                swap(nums,++zero,one++);
            }else if(nums[one] == 2){//判断基准位置的元素是否比基准大
                swap(nums,--two,one);
            }else {//这里比较特殊，基准不止1个
                one++;
            }
        }
        System.out.println("zero:"+zero);
        System.out.println("one:"+one);
        System.out.println("two:"+two);
    }
    //方法二：快排的分区思想，只不过这里需要先遍历一边，找到一个基准"1"的初始位置
    public static void solution2(int[] nums){
        int pivot = 1,pivotIndex = 0;
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                temp = i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                if (pivotIndex<i){
                    swap(nums,i,pivotIndex);
                }
                pivotIndex++;
            }
        }
        swap(nums,pivotIndex,temp);
    }
    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        SortColors.solution(nums);
        System.out.println(Arrays.toString(nums));
    }
}
