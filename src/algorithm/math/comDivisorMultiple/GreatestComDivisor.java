package algorithm.math.comDivisorMultiple;

/**
 * 最大公约数
 */
//TODO
public class GreatestComDivisor {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //最小公倍数为两数的乘积除以最大公约数。
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
