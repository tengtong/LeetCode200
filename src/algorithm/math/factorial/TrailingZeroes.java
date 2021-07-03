package algorithm.math.factorial;

/**
 * 统计阶乘尾部有多少个0
 * 尾部的0由2*5得到，2的数量明显多余5的数量，因此只要统计有多少个5即可
 * 对于一个数N，它所包含5的个数为: N/5+N/5^2+N/5^3+...，其中N/5表示不大于N的数中5的倍数贡献一个5，N/5^2表示不大于N的数中5^2的倍数再共享一个5
 */
//TODO
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
