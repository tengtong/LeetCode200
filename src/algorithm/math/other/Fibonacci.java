package algorithm.math.other;

/**
 * 斐波那契数列，写出斐波那契数列的第n项
 * 0，1，1，2，3，5，8，13...
 */
public class Fibonacci {
    public int solution(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return solution(n - 1) + solution(n - 2);
    }
}
