package algorithm.math.other;

/**
 * 求1+2+3+...+n
 * 不能使用乘除法、for、while、if、else、switch、case及条件判断语句
 * 使用递归代替循环
 * 使用之前的Add（异或求相加值、(a&&b)<<1求进位值）
 */
public class SumOfOneToN {
    public int solution(int n) {
        int sum = n;
        //1、先判断特殊情况，n=0时，会被(n>0)的条件短路，不符合第一个条件，直接false返回0，也相当于截止条件
        //2、n>0时，执行第二个条件，sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)
        boolean ans = (n>0)&&((sum = sum+solution(n-1))>0);
        return sum;
    }
}
