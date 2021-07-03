package algorithm.doublePointer;

/**
 * 判断有序数组的两数之和是否为目标值
 * 双指针法
 */
public class TwoSumTest {
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int sum = 0;int i=0;int j=numbers.length-1;
        if(numbers.length == 0){ return null;}
        while (i<j){
            sum = numbers[i]+numbers[j];
            if(sum==target){
                return new int[]{i+1,j+1};
            }else if(sum<target){
                i++;//i只加不减，保证不会走回头路，不会陷在在某个区域反复
            }else {
                j--;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int [] numbers = new int[]{2,7,11,15};
        int target = 10;
        int[] res = TwoSumTest.twoSum(numbers,target);
        for(int r:res){
            System.out.println(r+1);
        }
    }
}
