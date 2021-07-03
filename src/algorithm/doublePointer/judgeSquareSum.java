package algorithm.doublePointer;

/**
 * 判断一个非负整数是否为两个整数的平方和，即target==x^2+y^2;
 * 这里的数字范围相当于[0,sqrt(target)]，故还是双指针问题
 */
public class judgeSquareSum {
    public boolean judgeSquareSum(int target) {
        if (target < 0) return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
