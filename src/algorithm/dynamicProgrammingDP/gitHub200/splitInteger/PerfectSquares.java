package algorithm.dynamicProgrammingDP.gitHub200.splitInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * 按平方数来分割整数
 * 给定正整数n，返回和为n的完全平方数的最少数量
 * intput: n=12
 * output: 3 (12=4+4+4)
 * intput: n = 13
 * output: 2 (13=9+4)
 * ps：动态规划，不用害怕，只要尝试去分析，并且从简单的例子出发，都能找到规律
 * 思路：生成1~n之间的所有的完全平方数
 *      n=nums[i]*dp[n-i]
 */
//TODO
public class PerfectSquares {
    public int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {
                if (square > i) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }
}
