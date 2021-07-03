package algorithm.math.comDivisorMultiple;

/**
 * 最大公约数最小公倍数
 * x 和 y 的最大公约数为：gcd(x,y) = 2min(m0,n0) * 3min(m1,n1) * 5min(m2,n2) * ...
 * x 和 y 的最小公倍数为：lcm(x,y) = 2max(m0,n0) * 3max(m1,n1) * 5max(m2,n2) * ...
 */

/**
 * 生成素数序列
 * 埃拉托斯特尼筛法在每次找到一个素数时，将能被素数整除的数排除掉
 */
//TODO
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) {
                continue;
            }
            count++;
            // 从 i * i 开始，因为如果 k < i，那么 k * i 在之前就已经被去除过了
            for (long j = (long) (i) * i; j < n; j += i) {
                notPrimes[(int) j] = true;
            }
        }
        return count;
    }
}
