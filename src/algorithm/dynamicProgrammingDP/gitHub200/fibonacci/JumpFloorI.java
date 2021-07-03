package algorithm.dynamicProgrammingDP.gitHub200.fibonacci;

/**
 * 动态规划
 * 递归和动态规划都是将原问题拆成多个子问题来求解，区别就是，动态规划保存了子问题的解避免了重复计算
 * 应用场景：求解最值问题
 */

/**
 * 爬楼梯，有N阶楼梯，每次只能上一阶或者两阶，求有多少种上楼梯的方法
 * 方法一：数学找规律，归纳法
 *       f(1) = 1-f(0) = 1;
 *       f(2) = 1-f(1) + 2-f(0) = 2;
 *       f(3) = 1-f(2) + 2-f(1) = 3;
 *       f(4) = 1-f(3) + 2-f(2) = 4;
 *        ...
 *       f(n) = 1-f(n-1) + 2-f(n-2);
 * 方法二：动态规划
 *       定义数组，dp[i]表示走到第i个楼梯的方法数
 *       dp[i] = dp[i-1] + dp[i-2]，第i个楼梯可以从i-1或i-2个楼梯再一步到达，故如此表达
 */
public class JumpFloorI {
    public static int solution(int n){
        if(n<1){
            return 0;//往往需要考虑特殊情况
        } else if(n==1){
            return 1;
        } else if(n==2){
            return 2;
        }
        return solution(n-1)+solution(n-2);
    }

    public static int solution2(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 7;
        int res = JumpFloorI.solution2(n);
        System.out.println(res);
    }
}
