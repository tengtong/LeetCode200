package dataStructure.arrayAndMatrix;

/**
 * 嵌套数组
 * S[i]表示一个集合，集合的第一个元素是A[i]，第二个元素是A[A[i]]，如此嵌套下去，直到出现重复的元素，求最大的 S[i]。
 * 这里到最后一位会出现环，因为最后一位也要保证符合A[A[i]]的要求
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * 思路：直接遍历数组即可，从每一位出发，寻找当前元素能嵌套的最大层数，然后max每个元素即可
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int max = 0;
        //遍历元素
        for (int i = 0; i < nums.length; i++) {
            //找出每个元素能嵌套下去的最大元素
            int cnt = 0;
            //从当前元素开始嵌套查询，j为index，只要当前位置的值不为-1，即没有被访问过，就往下执行
            //对于这种不知道循环次数的循环体，可以用while的形式
            for (int j = i; nums[j] != -1; ) {
                cnt++;
                int t = nums[j];
                nums[j] = -1;//标记该位置已经被访问
                             //这里使用标记，而不是start=nums[start]
                             //可以在下一个i值的统计中，减少重复计算，以此避免超时
                j = t;//设置下一个j，因为这里的for没有i的赋值语句，需要手动赋值
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
