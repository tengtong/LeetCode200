package dataStructure.string;

/**
 * 判断一个整数是否是回文数（不能使用额外空间）
 * Input: 121
 * Output: true
 */
public class IsPalindromeII {
    public boolean isPalindrome2 (int x) {
        if (x == 0) {
            return true;
        }
        //如果小于0，或者是10的倍数（%是取余）
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        return x == right || x == right /10;
    }
}
