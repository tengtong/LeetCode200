package dataStructure.bit;

/**
 * 判断一个数是不是 2 的 n 次方
 */
//TODO
public class IsPowerOfTwo {
    //二进制表示只有一个 1 存在。
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    //利用 1000 & 0111 == 0 这种性质，得到以下解法：
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
