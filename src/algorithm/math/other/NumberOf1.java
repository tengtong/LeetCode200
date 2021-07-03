package algorithm.math.other;

/**
 * 输入一个整数，求其二进制表达式中1的个数
 * 找一个辅助数，<<1，与二进制数"与"运算，与上了就count++
 * 因为"与、或、非、异或"是位运算，好比11&01=01
 * 十进制之间使用位运算符，虽然操作上是从位上进行，但是结果还是以十进制的形式展示
 * 这里要考虑负数补码的情况，因为 >>> 是无视符号的右移
 */
public class NumberOf1 {
    public int solution(int n) {
        int count = 0;
        int flag = 1;//工具"1"进行位与
        while (flag < n) {//flag<n才行，给flag一个运行范围
            if ((n & flag) != 0) {//因为flag只有一个位置上有1，但是一旦n上同位置也有1，则结果必不会为0，所以count++，且一旦n上同位置上为0，则结果就是0，因为flag只有一个位置上有1，故可以以此区分
                count++;
            }
            flag = flag << 1;//左移工具"1"
        }
        return count;
    }
}
