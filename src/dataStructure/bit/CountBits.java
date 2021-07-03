package dataStructure.bit;

/**
 * 统计从 0 ~ n 每个数的二进制表示中 1 的个数
 * 对于数字 6(110)，它可以看成是 4(100) 再加一个 2(10)，因此 dp[i] = dp[i&(i-1)] + 1;
 */
//TODO
public class CountBits {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for(int i = 1; i <= num; i++){
            ret[i] = ret[i&(i-1)] + 1;
        }
        return ret;
    }
}
