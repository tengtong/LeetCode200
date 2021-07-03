package dataStructure.bit;

/**
 * 实现整数的加法
 * a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
 * 递归会终止的原因是 (a & b) << 1 最右边会多一个 0，那么继续递归，进位最右边的 0 会慢慢增多，最后进位会变为 0，递归终止
 */
//TODO
public class GetSum {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum((a ^ b), (a & b) << 1);
    }
}
