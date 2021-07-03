package algorithm.math.baseConversion;

/**
 * 26进制
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * 因为是从 1 开始计算的，而不是从 0 开始，因此需要对 n 执行 -1 操作
 */
//TODO
public class ToTitle {
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        n--;
        return convertToTitle(n / 26) + (char) (n % 26 + 'A');
    }
}
