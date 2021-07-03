package algorithm.math.other;

/**
 * 3 的 n 次方
 */
//TODO
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        return n > 0 && (1162261467 % n == 0);
    }
}
