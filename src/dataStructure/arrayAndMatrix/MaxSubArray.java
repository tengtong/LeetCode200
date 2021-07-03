package dataStructure.arrayAndMatrix;

/**
 * 连续子数组的最大和
 */
public class MaxSubArray {
    public  int solution(int[] array) {
        int res = array[0];
        for(int i=1;i<array.length;i++){
            array[i] += Math.max(array[i-1],0);//主要判断前一个元素array[i-1]是否大于0，以此判断是否要累加前一个元素//局部最优解
            res = Math.max(res,array[i]);//累加值再与自身判断一下，避免累加之后反而变小了
        }
        return res;
    }
}
